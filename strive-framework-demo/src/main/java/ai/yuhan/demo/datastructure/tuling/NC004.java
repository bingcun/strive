package ai.yuhan.demo.datastructure.tuling;

import org.junit.Test;

/**
 * @description:
 * 一个有序数组 nums ，原地删除重复出现的元素，使每个元素只出现一次 ，返回删除后数组的新长
 * 度,不要使用额外的数组空间，必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 * @author: bingcun.chen
 * @Date: 2021/5/18 17:28
 * @Version 1.0
 */
public class NC004 {

    /**
     * 快慢指针原地删除重复的元素
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if(nums.length==0)return 0;
        int i = 0;
        //1.迭代数组中的元素。
        //2.快指针依次往后走。
        //3.判断慢指针和快指针对应的值是否相等
        //4.自增慢指针 交换数据
        for(int j=1;j<nums.length;j++){
            if(nums[j] != nums[i]){
                i++;
                nums[i] = nums[j];
            }
        }
        return i+1;
    }

    @Test
    public void test01(){
        int[] sums = new int[]{1,1,2,4,4,6};
        System.out.println(removeDuplicates(sums));
    }


}
