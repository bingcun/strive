package ai.yuhan.other.datastructure.tuling;

import org.junit.Test;

import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: bingcun.chen
 * @Date: 2021/4/30 17:49
 * @Version 1.0
 */
public class CalulationLongestSameStrUtils {

    /**
     * 判断某个字符串出现的次数(计算榜首时间)
     * @param stringList
     * @param str
     * @return
     */
    public static int topStrCount(List<Integer> stringList,Integer str){
        int count = (int)stringList.stream().filter(n -> n.equals(str)).count();
        return count;
    }


    /**
     * 获取某个字符串出现的最大次数(用于计算最长连续榜首次数)
     * @param lists
     * @param str
     * @return
     */
    public static int longestStrTopCount(List<Integer> lists,Integer str){
        //如果不包含某字符串则返回0
        if(!lists.contains(str))return 0;
        int max = 0;
        int size = lists.size();
        for(int i=0;i<size;i++){
            //判断当前最大连续次数是否大于剩余次数,如果大于剩余次数或者当前i大于数组的长度,则没有必要再去循环判断
            if(max >= size-i || i>=size){
                return max;
            }
            //获取当前第i位起的连续字符串
            int StrMaxSizeSub = strMaxSizeSub(lists,str,i,size);
            //当前连续字符串和max进行比较,并赋值给max
            max = max > StrMaxSizeSub ? max :StrMaxSizeSub;
            //对i=i+连续字符(连续字符内没有必要循环)
            i += StrMaxSizeSub > 0 ?StrMaxSizeSub - 1 : 0;
        }
        return max;
    }

    /**
     * 获取从i起的最长连续
     * @param lists
     * @param str
     * @param start
     * @param length
     * @return
     */
    private static int strMaxSizeSub(List<Integer> lists, Integer str, int start, int length) {
        int size =0;
        for(int i = start;i<length;i++){
            //若非N连续次数,则改为!=c即可
            if(lists.get(i) == str){
                size ++;
            }else{
                break;
            }
        }
        return size;
    }

    /**
     * 三项不平衡电压电流时间转换
     * @param date
     * @param dateType
     * @return
     */
    public static boolean checkDateFormat(String date, String dateType) {
        DateTimeFormatter formatter;
        try {
            if (dateType.equals("1")) {
                formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            } else {
                formatter = DateTimeFormatter.ofPattern("yyyy-MM");
            }
            formatter.parse(date);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Test
    public void test01(){
        int[] arr = new int[]{1,1,1,1,0,0,0,1,1,2,1,1,1,1,1,1,1};
        List<Integer> intList= Arrays.stream(arr).boxed().collect(Collectors.toList());
        System.out.println(longestStrTopCount(intList,1));
    }

}