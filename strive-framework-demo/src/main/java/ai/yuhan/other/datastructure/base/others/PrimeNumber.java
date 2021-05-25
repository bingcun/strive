package ai.yuhan.other.datastructure.base.others;

/**
 * @Author: bingcun.chen
 * @Date: 2021/3/14 23:44
 * @Version: 1.0
 * @Email: 820306546@qq.com
 */
public class PrimeNumber {

    public static void main(String[] args) {
        int count = 0;
        for(int i=2;i<100;i++){
            boolean flag = true;
            for(int j=2;j<i;j++){
                if(i%j==0){
                    flag = false;
                    break;
                }
            }
            if(flag){
                System.out.print(i+",");
                count++;
            }
        }
        System.out.println("质数总数为:"+count);
    }

}
