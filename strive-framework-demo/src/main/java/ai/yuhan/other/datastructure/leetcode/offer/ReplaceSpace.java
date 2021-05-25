package ai.yuhan.other.datastructure.leetcode.offer;

/**
 * @Author: bingcun.chen
 * @Date: 2021/3/20 16:14
 * @Version: 1.0
 * @Email: 820306546@qq.com
 */
public class ReplaceSpace {
    public static String replaceSpace (String s) {
        // write code here
        int len = s.length();
        char[] chars = new char[3 * len];

        int size = 0;
        for(int i=0;i<len;i++){
            char c = s.charAt(i);
            if(c == ' '){
                chars[size++] = '%';
                chars[size++] = '2';
                chars[size++] = '0';
            }else {
                chars[size++] = c;
            }
        }
        String news = new String(chars,0,size);
        return news;
    }

    public static void main(String[] args) {
        String ss = "We Are Happy";
        System.out.println(replaceSpace(ss));
    }

}
