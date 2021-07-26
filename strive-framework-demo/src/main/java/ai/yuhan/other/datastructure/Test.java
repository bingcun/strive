package ai.yuhan.other.datastructure;

import lombok.Data;

import java.util.*;

/**
 * @description:
 * @author: bingcun.chen
 * @Date: 2021/5/22 19:13
 * @Version 1.0
 */
public class Test {

    @Data
    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
            next = null;
        }

        public ListNode() {
        }
    }


    /**
     * offer58-2
     *
     * @param s
     * @param n
     * @return
     */
    public String reverseLeftWords(String s, int n) {
        if (n == s.length()) return s;
        String str01 = s.substring(0, n);
        String str02 = s.substring(n, s.length());
        return str02 + str01;
    }

    @org.junit.Test
    public void testLeftWords() {
        String ss = "123456";
        reverseLeftWords(ss, 2);

    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * offer55-1
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    @org.junit.Test
    public void testMaxDepth() {
        TreeNode tree01 = new TreeNode(3);
        TreeNode tree02 = new TreeNode(9);
        TreeNode tree03 = new TreeNode(20);
        TreeNode tree04 = new TreeNode(15);
        TreeNode tree05 = new TreeNode(7);

        tree01.left = tree02;
        tree01.right = tree03;

        tree03.left = tree04;
        tree03.right = tree05;


        System.out.println(maxDepth(tree01));
    }

    /**
     * 柠檬水找零-860
     * 输入：[5,5,5,10,20]
     * 输出：true
     * <p>
     * 输入：[5,5,10]
     * 输出：true
     * <p>
     * 输入：[10,10]
     * 输出：false
     * <p>
     * 输入：[5,5,10,10,20]
     * 输出：false
     *
     * @param bills
     * @return
     */
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                five++;
            } else if (bills[i] == 10) {
                if (five > 0) {
                    five--;
                    ten++;
                } else {
                    return false;
                }
            } else {
                if (five > 0 && ten > 0) {
                    five--;
                    ten--;
                } else if (five >= 3) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * offer-976
     *
     * @param nums
     * @return
     */
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);

        for (int i = nums.length - 1; i >= 2; i--) {
            if (nums[i - 2] + nums[i - 2] > nums[i]) {
                return nums[i] + nums[i - 1] + nums[i - 2];
            }
        }
        return 0;
    }

    /**
     * 石头游戏
     *
     * @param piles
     * @return
     */
    public boolean stoneGame(int[] piles) {
        //dp其实就是存储了递归过程中的数值
        //dps[i][j]代表从i到j所能获得的最大的绝对分数
        //（比如为1就说明亚历克斯从i到j可以赢李1分）
        //如何计算dps[i][j]呢:max(piles[i]-dp[i+1][j],piles[j]-dp[i][j-1]);
        //这里减去dps数组是因为李也要找到最大的
        //最后dps=[5 2 4 1]
        //        [0 3 1 4]
        //        [0 0 4 1]
        //        [0 0 0 5]
        int n = piles.length;
        int[][] dps = new int[n][n];
        //dps[i][i]存储当前i的石子数
        for (int i = 0; i < n; i++)
            dps[i][i] = piles[i];
        //d=1,其实代表，先算两个子的时候
        for (int d = 1; d < n; d++) {
            //有多少组要比较
            for (int j = 0; j < n - d; j++) {
                //比较j到d+j
                dps[j][d + j] = Math.max(piles[j] - dps[j + 1][d + j], piles[d + j] - dps[j][d + j - 1]);
            }
        }
        return dps[0][n - 1] > 0;
    }

    /**
     * 判断字符串2是否在第一字符串中存在
     * 方法1:indexof
     *
     * @param str1
     * @param str2
     * @return
     */
    public int strSearch(String str1, String str2) {
        return str1.indexOf(str2);
    }

    /**
     * 暴力匹配
     *
     * @param str1
     * @param str2
     * @return
     */
    public int strSearch02(String str1, String str2) {
        for (int i = 0; i < str1.length(); i++) {
            int temp = i;
            for (int j = 0; j < str2.length(); j++) {
                if (temp >= str1.length()) return -1;
                if (str1.charAt(temp) == str2.charAt(j) && j == str2.length() - 1) {
                    return i;
                } else if (str1.charAt(temp) == str2.charAt(j)) {
                    temp++;
                } else {
                    break;
                }
            }
        }
        return -1;
    }

    /**
     * hash算法匹配字符串
     *
     * @param str1
     * @param str2
     * @return
     */
    public int strSearch03(String str1, String str2) {
        int str2Code = parsingStr(str2);
        for (int i = 0; i < str1.length(); i++) {
            int result = i + str2.length();
            if (result > str1.length()) return 0;

            String str1Sub = str1.substring(i, result);
            int str1SubCode = parsingStr(str1Sub);

            if (str2Code == str1SubCode) {
                //匹配子串防止hash冲突
                int temp = i;
                for (int j = 0; j < str2.length(); j++) {
                    if (str2.charAt(j) == str1.charAt(temp) && j == str2.length() - 1) {
                        return j;
                    } else if (str2.charAt(j) == str1.charAt(temp)) {
                        temp++;
                    } else {
                        break;
                    }
                }
            }

        }

        return -1;
    }

    private int parsingStr(String str1) {
        int sum = 0;
        char[] chars = str1.toCharArray();
        int code;
        for (char cs : chars) {
            int ss = matchCodeForStr(cs);
            sum += ss;
        }
        return sum;
    }

    private int matchCodeForStr(char cs) {
        int code;
        switch (cs) {
            case 'A':
                code = 1;
                break;
            case 'B':
                code = 2;
                break;
            case 'C':
                code = 3;
                break;
            case 'D':
                code = 4;
                break;
            default:
                code = -1;
        }
        return code;
    }


    @org.junit.Test
    public void testStr01() {
        String ss = "BCABCADABCABCD";
        String ss2 = "ABC";

        System.out.println(strSearch(ss, ss2));

        System.out.println(strSearch02(ss, ss2));

        System.out.println(strSearch03(ss, ss2));


    }

    @org.junit.Test
    public void testLemon() {
        int[] lemon = new int[]{5, 5, 10};
        System.out.println(lemonadeChange(lemon));
    }

    /**
     * 输入: head = [4,5,1,9], val = 5
     * 输出: [4,1,9]
     * 解释: 给定你链表中值为的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
     *
     * @param head
     * @param val
     * @return
     */
    public ListNode deleteNode(ListNode head, int val) {
        if (head.val == val) return head.next;
        ListNode pre = head, cur = head.next;
        while (cur != null && cur.val != val) {
            pre = cur;
            cur = cur.next;
        }
        if (cur != null) pre.next = cur.next;
        return head;
    }

    public ListNode deleteNode02(ListNode head,int val){
        ListNode pre = head,cur = head.next;
        if(head.val == val)return head.next;

        while (cur!=null && cur.val != val){
            pre = cur;
            cur = cur.next;
        }

        if(cur != null)pre.next = cur.next;

        return head;
    }


    @org.junit.Test
    public void testDeleteNode(){
        ListNode listNode01 = new ListNode(4);
        ListNode listNode02 = new ListNode(5);
        ListNode listNode03 = new ListNode(1);
        ListNode listNode04 = new ListNode(9);

        listNode01.next = listNode02;
        listNode02.next = listNode03;
        listNode03.next = listNode04;


        deleteNode02(listNode01,1);
    }

    @org.junit.Test
    public void test0222(){
        recursionData();
//        testOutOfHeapMemory();
    }
    private void recursionData(){
        List<StringBuffer> list = new ArrayList<>();
        while (true){
            StringBuffer sb = new StringBuffer();
            for(int i =0;i<10000;i++){
                sb.append(i);
            }
            list.add(sb);
        }
    }

    @org.junit.Test
    public void test01111(){
        int[] ass = new int[]{1,8,6,2,5,4,8,3,7};

        System.out.println(maxArea(ass));
    }

    public int maxArea(int[] height) {

        int i = 0,j = height.length - 1;
        int res = 0;

        while (i < j){
            int area = (j - i) * Math.min(height[i],height[j]);
            res = Math.max(res,area);
            if(height[i] < height[j]){
                i++;
            }else {
                j--;
            }
        }

        return res;
    }



}
