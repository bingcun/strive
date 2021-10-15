package ai.yuhan.other.datastructure.test.meituan;

import java.util.Scanner;

/**
 * @description:
 * @author: bingcun.chen
 * @Date: 2021/8/23 12:25
 * @Version 1.0
 */
public class TestMeiTuan {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer next = scanner.nextInt();

        for (int i = 0;i<next;i++){
            String text = scanner.next();
            String str = checkUserNameOk(text);
            System.out.println(str);
        }
    }

    private static String checkUserNameOk(String text) {
        int numTotal = 0,strTotal = 0;
        for(int i = 0;i < text.length();i++){
            if(i == 0){
                if(!Character.isLetter(text.charAt(i))){
                    return "Wrong";
                }
            }

            if(!Character.isLetterOrDigit(text.charAt(i))){
                return "Wrong";
            }

            if(Character.isDigit(text.charAt(i))){
                numTotal++;
            }

            if(Character.isLetter(text.charAt(i))){
                strTotal++;
            }
        }

        if(numTotal > 0 && strTotal > 0){
            return "Accept";
        }else {
            return "Wrong";
        }
    }


}
