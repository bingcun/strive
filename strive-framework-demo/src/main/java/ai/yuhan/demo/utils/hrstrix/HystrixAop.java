package ai.yuhan.demo.utils.hrstrix;

import ai.yuhan.demo.utils.RedisUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.concurrent.TimeUnit;

/**
 * @description: SpringAOP+自定义注解实现限流防刷
 * @author: bingcun.chen
 * @Date: 2021/5/20 16:26
 * @Version 1.0
 */
@Aspect
@Component
public class HystrixAop {

    @Pointcut("@annotation(ai.yuhan.demo.utils.hrstrix.hystrixCommand)")
    public void pointCut(){}

    @Around("pointCut()")
    public Object hystrixAop(ProceedingJoinPoint point) throws Throwable {
        //拿到注解的方法
        MethodSignature methodSignature = (MethodSignature) point.getSignature();
        //获取自定义注解
        hystrixCommand paramValid = methodSignature.getMethod().getDeclaredAnnotation(hystrixCommand.class);
        //限制时长
        int limit = paramValid.limit();
        //时间范围
        int timeScope = paramValid.timeScope();

        //limit timeScope 两个参数必填
        if(limit>0 && timeScope>0){
            //如果用在浏览器端可以通过session做为唯一标识来限流,如果是App可以用用户Id来防值重刷,以验证码为例防止重刷
            final String redisKey = "Strive_const" + ":" + "userId";
            String currentTimes = RedisUtils.get(redisKey);
            //判断当前值是否存在
            if(StringUtils.isEmpty(currentTimes)){
                RedisUtils.set(redisKey,"1",timeScope,TimeUnit.SECONDS);
            }else{
                //获取缓存中的数值
                int count = Integer.parseInt(currentTimes);
                if(count < limit){
                    RedisUtils.incr(redisKey,1);
                }else {
                    throw new Exception("当前访问过于频繁,请稍后操作");
                }
            }
        }

        return point.proceed();
    }
}
