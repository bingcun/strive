package ai.yuhan.other.datastructure.match;

import org.junit.Test;

/**
 * @description:
 * @author: bingcun.chen
 * @Date: 2021/6/15 19:33
 * @Version 1.0
 */
public class BigDataSum {

    @Test
    public void test(){
        String num1 = "123";
        String num2 = "234";

//        int i = num1.length() - 1,j = num2.length() - 1;
//        int x = num1.charAt(i) - '0';
//        int y = num2.charAt(j) - '0';
//        int sum = x + y;

        System.out.println(sumStr(num1,num2));
//        System.out.println(Integer.parseInt(num1) * Integer.parseInt(num2));


    }

    /**
     * 两数相加
     * @param nums1
     * @param nums2
     * @return
     */
    public String sumStr(String nums1,String nums2){
        StringBuffer sb = new StringBuffer();
        int i = nums1.length() - 1,j = nums2.length() - 1,carry = 0;
        while (i >= 0 || j >= 0 || carry != 0){
            int x = i < 0 ? 0 : nums1.charAt(i--) - '0';
            int y = j < 0 ? 0 : nums2.charAt(j--) - '0';
            int sum = x + y +carry;
            sb.append(sum % 10);
            carry = sum / 10;
        }
        return sb.reverse().toString();
    }

    /**
     * 两数相乘
     * @param nums1
     * @param nums2
     * @return
     */
    public String bigDataSub(String nums1,String nums2){
        StringBuffer sb = new StringBuffer();
        String[] str = new String[2];
        int i = nums1.length() - 1,j = nums2.length() -1,carry = 0;
        int temp = 0;
        for(;i >= 0;i--){
            for(;j>=0;j--){
                int x = nums1.charAt(i) - '0';
                int y = nums2.charAt(j) - '0';

                int sum = x * y + carry;
                sb.append(sum % 10);
                carry = sum / 10;
            }
           str[temp++] = sb.reverse().toString();
        }
        return sb.reverse().toString();
    }

}
