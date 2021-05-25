package ai.yuhan.other.datastructure.careers.easy;

import org.junit.Test;

import java.util.*;

/**
 * @description: 在一个字符串(0 < = 字符串长度 < = 10000 ， 全部由字母组成)中找到第一个只出现一次的字符, 并返回它的位置,
 * 如果没有则返回 -1（需要区分大小写）.（从0开始计数）
 * <p>
 * 输入
 * "google"
 * 返回值
 * 4
 * @author: bingcun.chen
 * @Date: 2021/5/14 14:17
 * @Version 1.0
 */
public class NC31 {

    /**
     * 思路:
     * 1.遍历一遍字符串找到重复的字符串,并标记每个字符串的个数
     * 2.重新遍历一遍字符串,找到字符串出现一次的位置
     * @param str
     * @return
     */
    public int FirstNotRepeatingChar(String str) {
        if (str.length() < 1) return -1;
        Map<Character, Integer> maps = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            if (maps.containsKey(str.charAt(i))) {
                int temp = maps.get(str.charAt(i));
                maps.put(str.charAt(i), ++temp);
            } else {
                maps.put(str.charAt(i), 1);
            }
        }

        for (int j = 0; j < str.length(); j++) {
            if (maps.get(str.charAt(j)) == 1)
                return j;
        }
        return -1;
    }

    @Test
    public void test01() {
        String str = "google";
        System.out.println(FirstNotRepeatingChar(str));

    }

}
