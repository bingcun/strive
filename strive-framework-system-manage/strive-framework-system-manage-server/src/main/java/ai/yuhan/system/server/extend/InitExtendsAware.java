package ai.yuhan.system.server.extend;

import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Author: bingcun.chen
 * @Date: 2021/2/16 10:35
 * @Version: 1.0
 * @Email: 820306546@qq.com
 */
@Component
public class InitExtendsAware {

//    /**
//     * 处理预留拓展点:二开实现接口在业务代码中调用
//     */
//    public static void initClass(Object obj){
//        ApplicationContext ac = SpringContextHolder.getContext();
//        Map<String, SayHello> result = ac.getBeansOfType(SayHello.class);
//        if(null != result && !result.isEmpty()){
//            for(Map.Entry<String, SayHello> entry:result.entrySet()){
//                try {
//                        SayHello it = SpringContextHolder.getBean(entry.getValue().getClass());
//                        it.hello(ac);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }

//    /**
//     * 处理预留拓展点:二开实现抽象类在业务代码中调用
//     */
//    public static void initClassMethod(){
//        ApplicationContext ac = SpringContextHolder.getContext();
//        Map<String, SayHello2> result = ac.getBeansOfType(SayHello2.class);
//        if(null != result && !result.isEmpty()){
//            for(Map.Entry<String, SayHello2> entry:result.entrySet()){
//                try {
//                        SayHello2 it = SpringContextHolder.getBean(entry.getValue().getClass());
//                        it.hello2();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }



}
