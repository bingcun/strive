package ai.yuhan.demo.utils.hrstrix;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @description:
 * @author: bingcun.chen
 * @Date: 2021/5/20 16:24
 * @Version 1.0
 */
@Target(ElementType.METHOD)
@Retention( RetentionPolicy.RUNTIME)
public @interface hystrixCommand {

    int limit();

    int timeScope();
}
