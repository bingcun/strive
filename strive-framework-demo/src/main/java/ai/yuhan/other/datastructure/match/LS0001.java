package ai.yuhan.other.datastructure.match;

import org.junit.Test;

/**
 * @description:
 * 给你一个二进制字符串 s 。如果字符串中由 1 组成的 最长 连续子字符串 严格长于 由 0 组成的 最长 连续子字符串，返回 true ；否则，返回 false 。
 *
 * 例如，s = "110100010" 中，由 1 组成的最长连续子字符串的长度是 2 ，由 0 组成的最长连续子字符串的长度是 3 。
 * 注意，如果字符串中不存在 0 ，此时认为由 0 组成的最长连续子字符串的长度是 0 。字符串中不存在 1 的情况也适用此规则。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "1101"
 * 输出：true
 * 解释：
 * 由 1 组成的最长连续子字符串的长度是 2："1101"
 * 由 0 组成的最长连续子字符串的长度是 1："1101"
 * 由 1 组成的子字符串更长，故返回 true 。
 * 示例 2：
 * 输入：s = "111000"
 * 输出：false
 * 解释：
 * 由 1 组成的最长连续子字符串的长度是 3："111000"
 * 由 0 组成的最长连续子字符串的长度是 3："111000"
 * 由 1 组成的子字符串不比由 0 组成的子字符串长，故返回 false 。
 * 示例 3：
 * 输入：s = "110100010"
 * 输出：false
 * 解释：
 * 由 1 组成的最长连续子字符串的长度是 2："110100010"
 * 由 0 组成的最长连续子字符串的长度是 3："110100010"
 * 由 1 组成的子字符串不比由 0 组成的子字符串长，故返回 false 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longer-contiguous-segments-of-ones-than-zeros
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * @author: bingcun.chen
 * @Date: 2021/5/24 9:27
 * @Version 1.0
 */
public class LS0001 {
    public boolean checkZeroOnes(String s) {
        int start01 = 0,maxStr01 = 0;
        int start00 = 0,maxStr00 = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                start01++;
            } else {
                start01 = 0;
            }
            if(s.charAt(i) == '0'){
                start00++;
            }else {
                start00 = 0;
            }
            maxStr01 = Math.max(maxStr01, start01);
            maxStr00 = Math.max(maxStr00,start00);
        }
        return maxStr01 > maxStr00;
    }

    @Test
    public void test01(){
        String str = "1101";
        System.out.println(checkZeroOnes(str));


    }

}
