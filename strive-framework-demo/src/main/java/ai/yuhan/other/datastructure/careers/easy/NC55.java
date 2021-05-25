package ai.yuhan.other.datastructure.careers.easy;

import org.junit.Test;

import java.util.Arrays;

/**
 * @description: 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 输入:["abca","abc","abca","abc","abcc"]
 * 返回值: "abc"
 * @author: bingcun.chen
 * @Date: 2021/5/17 16:17
 * @Version 1.0
 */
public class NC55 {

    /**
     * 实现思路:解法1:
     * 通过冒泡排序或者数组的排序方法进行排序数组,找到最短的字符串,然后比较最长和最短字符串中的值,不匹配的时候返回截取的字符串
     * @param strs
     * @return
     */
    public String longestCommonPrefix01(String[] strs) {
        if(strs.length == 0)return "";
        // write code here
//        for(int i=1 ;i<strs.length;i++){
//            int curr = strs[i].length();
//            int next = strs[ i - 1].length();
//            if(curr>next){
//                String temp = strs[i - 1];
//                strs[i - 1] = strs[i] ;
//                strs[i] = temp;
//            }
//        }
        Arrays.sort(strs);
        int length = Math.min(strs[strs.length -1].length(),strs[0].length());
        int result;
        for(result=0;result<length;result++){
            if(strs[0].charAt(result) != strs[strs.length -1].charAt(result)){
                break;
            }
        }
        return strs[0].substring(0,result);
    }

    /**
     * 解法2:
     * 基于该结论，可以得到一种查找字符串数组中的最长公共前缀的简单方法。依次遍历字符串数组中的每个字符串，对于每个遍历到的字符串，更新最长公共前缀，
     * 当遍历完所有的字符串以后，即可得到字符串数组中的最长公共前缀,如果在尚未遍历完所有的字符串时，最长公共前缀已经是空串，则最长公共前缀一定是空串，
     * 因此不需要继续遍历剩下的字符串，直接返回空串即可。
     * @param strs
     * @return
     */
    public String longestCommonPrefix02(String[] strs){
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        int count = strs.length;
        for (int i = 1; i < count; i++) {
            prefix = longestCommonPrefix02(prefix, strs[i]);
            if (prefix.length() == 0) {
                break;
            }
        }
        return prefix;
    }

    public String longestCommonPrefix02(String str1, String str2) {
        int length = Math.min(str1.length(), str2.length());
        int index = 0;
        while (index < length && str1.charAt(index) == str2.charAt(index)) {
            index++;
        }
        return str1.substring(0, index);
    }

    /**
     * 解法3:垂直扫描法：按列扫描，先验证所有字符串的第一个元素
     * 纵向扫描时，从前往后遍历所有字符串的每一列，比较相同列上的字符是否相同，如果相同则继续对下一列进行比较，
     * 如果不相同则当前列不再属于公共前缀，当前列之前的部分为最长公共前缀。
     * 纵向比较值
     * @param strs
     * @return
     */
    public String longestCommonPrefix03(String[] strs){
        if (strs == null || strs.length == 0) {
            return "";
        }
        int length = strs[0].length();
        int count = strs.length;
        for (int i = 0; i < length; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < count; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }


    /**
     * 解法4:
     * //分治算法，在水平扫描法的基础上改进
     * @param strs
     * @return
     */
    public static String longestCommonPrefix04(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";

        return longestCommonPrefix04(strs, 0, strs.length - 1);
    }

    public static String longestCommonPrefix04(String[] strs, int begin, int end) {
        if(begin == end) {
            return strs[begin];
        }
        else {
            int mid = (begin + end) >> 1;
            String str1 = longestCommonPrefix04(strs, begin, mid);
            String str2 = longestCommonPrefix04(strs, mid + 1, end);
            if(str1 == "" || str2 == "") return "";

            int idx = -1;
            while(idx < str1.length() - 1 && idx < str2.length() - 1) {
                if(str1.charAt(idx + 1) == str2.charAt(idx + 1)) {
                    idx++;
                }else {
                    break;
                }
            }
            if(idx == -1) return "";
            return strs[begin].substring(0, idx + 1);
        }
    }

    /**
     * 解法5:二分查找法
     * 显然,最长公共前缀的长度不会超过字符串数组中的最短字符串的长度。用minLength表示字符串数组中的最短字符串的长度,则可以在[0,minLength]的范围内通过二分查找法,
     * 得到最长公共前缀的长度,每次取查找范围的中间值mid,判断每个字符串的长度为mid的前缀是否相同,如果相同则最长公共前缀的长度一定大于或等于mid，如果不相同则最长公共浅醉
     * 的长度一定小于mid,通过上述方式查找范围缩小一半,直到的得到最长公共前缀的长度
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefix05(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int minLength = Integer.MAX_VALUE;
        for (String str : strs) {
            minLength = Math.min(minLength, str.length());
        }
        int low = 0, high = minLength;
        while (low < high) {
            int mid = (high - low + 1) / 2 + low;
            if (isCommonPrefix(strs, mid)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return strs[0].substring(0, low);
    }

    public boolean isCommonPrefix(String[] strs, int length) {
        String str0 = strs[0].substring(0, length);
        int count = strs.length;
        for (int i = 1; i < count; i++) {
            String str = strs[i];
            for (int j = 0; j < length; j++) {
                if (str0.charAt(j) != str.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }



    @Test
    public void test01(){
        String[] str = new String[]{"abca","abc","abca","abc","abcc"};
        System.out.println(longestCommonPrefix01(str));
    }

    @Test
    public void test03(){
        String[] str = new String[]{"abca","abc","abca","abc","abcc"};
        System.out.println(longestCommonPrefix03(str));
    }

}
