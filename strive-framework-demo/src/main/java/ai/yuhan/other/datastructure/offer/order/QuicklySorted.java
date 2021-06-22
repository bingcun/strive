package ai.yuhan.other.datastructure.offer.order;

import org.aspectj.lang.annotation.Pointcut;
import org.junit.Test;

import java.util.Arrays;

/**
 * @description:
 * @author: bingcun.chen
 * @Date: 2021/5/29 17:18
 * @Version 1.0
 */
public class QuicklySorted {
    /**
     * 快速排序
     * @param array
     * @return
     */
    public int[] quick(int[] array){
        quick01(array,0,array.length - 1);
        return array;
    }

    private void quick01(int[] array, int low, int high) {
        if (low >= high) return;
        //初始化 i,j,基准数
        int i = low, j = high, pirpoint = array[i];
        //初始化条件
        while (i < j) {
            //从后往前匹配 后面值大于基准值 向前移动j
            while (i < j && array[j] >= pirpoint) {
                j--;
            }
            //i向后移动
            if (i < j) {
                array[i++] = array[j];
            }
            //前面值小于基准值向后移动 找到前面值大于基准值的停下来
            while (i < j && array[i] < pirpoint) {
                i++;
            }
            //j向前移动 交换i与j
            if (i < j) {
                array[j--] = array[i];
            }
        }
        //基准值给i
        array[i] = pirpoint;
        //分治法排序 将一个问题转化两个子问题
        quick01(array, low, i - 1);
        quick01(array, i + 1, high);
    }


    @Test
    public void test(){
        int[] array = new int[]{11,2,33,4,5,6,3,222,33};
        int[] quick = quick(array);
        System.out.println(Arrays.stream(quick).toArray());
    }


}
