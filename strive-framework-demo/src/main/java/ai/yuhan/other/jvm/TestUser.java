package ai.yuhan.other.jvm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

/**
 * @description:
 * @author: bingcun.chen
 * @Date: 2021/9/25 10:51
 * @Version 1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TestUser {
    private String id;
    private String name;

    void sout(){
        System.out.println("123456");
    }
}
