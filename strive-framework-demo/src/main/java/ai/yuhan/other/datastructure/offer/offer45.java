package ai.yuhan.other.datastructure.offer;

import org.junit.Test;

import java.util.Arrays;

/**
 * @description:
 * @author: bingcun.chen
 * @Date: 2021/5/29 17:57
 * @Version 1.0
 */
public class offer45 {
    /**
     * 自定义排序 + 快排
     * @param nums
     * @return
     */
    public String minNumber(int[] nums) {
        String[] array = new String[nums.length];

        for (int i = 0; i < nums.length; i++) {
            array[i] = String.valueOf(nums[i]);
        }

        quick(array,0,array.length -1);

        StringBuilder sb = new StringBuilder();
        for(String ss : array){
            sb.append(ss);
        }
        return sb.toString();
    }

    private void quick(String[] array, int low, int high) {
        if(low >= high)return;
        int i = low;
        int j = high;
        String point = array[i];

        while (i < j){
            while (i < j && (array[j] + array[low]).compareTo(array[low] + array[j]) >= 0)j--;
            while (i < j && (array[i] + array[low]).compareTo(array[low] + array[i]) <= 0)i++;

            point = array[i];
            array[i] = array[j];
            array[j] = point;
        }

        array[i] = array[low];
        array[low] = point;

        quick(array,low,i -1);
        quick(array,i + 1 ,high);
    }

    /**
     * 自定义排序 + 数组排序
     * @param nums
     * @return
     */
    public String minNumber01(int[] nums){
        String[] array = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            array[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(array,(x,y)->(x+y).compareTo((y+x)));
        StringBuilder sb = new StringBuilder();
        for(String str:array){
            sb.append(str);
        }

        return sb.toString();
    }

    @Test
    public void test(){
        int[] nums = new int[]{1,5,2,3,60,22};
        System.out.println(minNumber(nums));
        System.out.println(minNumber01(nums));
    }
}
