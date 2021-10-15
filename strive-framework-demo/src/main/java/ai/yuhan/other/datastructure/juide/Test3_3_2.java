package ai.yuhan.other.datastructure.juide;

import org.apache.logging.log4j.util.Strings;
import org.junit.Test;

import java.util.Arrays;

/**
 * @description:
 * @author: bingcun.chen
 * @Date: 2021/8/18 17:06
 * @Version 1.0
 */
public class Test3_3_2 {


    /**
     * 输入: ["flower","flow","flight"]
     * 输出: "fl"
     * 最长公共前缀
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs){

        if(checkStrCommon(strs)){
            return "";
        }

        Arrays.sort(strs);

        String first = strs[0];
        String last = strs[strs.length - 1];

        int length = Math.min(first.length(),last.length());
        StringBuffer sb = new StringBuffer();

        for(int i=0;i<length;i++){
            if(first.charAt(i) == last.charAt(i)){
                sb.append(first.charAt(i));
            }else {
                return sb.toString();
            }
        }
        return sb.toString();
    }

    /**
     * 校验传入的数据中是否存在null
     * @param strs
     * @return
     */
    boolean checkStrCommon(String[] strs) {
        boolean flag = false;
        for (int i=0; i < strs.length;i++) {
            if(null == strs[i] && strs.length==0){
                return true;
            }
        }
        return flag;
    }

    @Test
    public void test(){
        String[] strs = new String[]{"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
    }

}
