package ai.yuhan.demo.conf;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.PostConstruct;

/**
 * @Author: bingcun.chen
 * @Date: 2021/2/22 8:02
 * @Version: 1.0
 * @Email: 820306546@qq.com
 */
@Data
@AllArgsConstructor
@Builder
public class Emp {
    private String name;
    private Integer age;
    private Double salary;

    public Emp(){
        System.out.println("走Emp的构造方法");
    }

    @PostConstruct
    private void init() {
        System.out.println("走Emp@PostConstruct的init的方法");
    }




}
