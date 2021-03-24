package ai.yuhan.demo.datastructure.base;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: bingcun.chen
 * @Date: 2021/3/21 20:52
 * @Version: 1.0
 * @Email: 820306546@qq.com
 */
public class TestHashMap {

    public static void main(String[] args) {
        Map map = new HashMap(11);
        map.put("yangguo","123");

        System.out.println(Math.abs("yangguo1".hashCode() % 16));





    }


}
