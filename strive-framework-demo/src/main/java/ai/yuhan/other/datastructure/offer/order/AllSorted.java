package ai.yuhan.other.datastructure.offer.order;

import ai.yuhan.demo.test.A;
import org.junit.Test;

import java.sql.SQLOutput;
import java.util.Arrays;

/**
 * @description:
 * @author: bingcun.chen
 * @Date: 2021/5/29 20:50
 * @Version 1.0
 */
public class AllSorted {

    /**
     * 冒泡排序
     * @param array
     * @return
     */
    public int[] bubbleSorted(int[] array){
        for (int i = 0; i < array.length; i++) {
            for(int j = i + 1;j<array.length;j++){
                if(array[i] > array[j]){
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }

    /**
     * 快速排序--先局部排序 + 分治法
     * @param array
     * @return
     */
    public int[] quicklySorted(int[] array){
        quickSorted(array,0,array.length -1);
        return array;
    }

    private void quickSorted(int[] array, int low, int high) {
       if(low >= high)return;
        int i = low,j = high,pos = array[i];
        while (i < j){
            while (i < j && array[j] >= pos){
                j--;
            }
            if(i < j){
                array[i++] = array[j];
            }
            while (i < j && array[i] < pos){
                i++;
            }
            if(i < j){
                array[j--] = array[i];
            }
        }
        array[i] = pos;
        quickSorted(array,low,i - 1);
        quickSorted(array,i + 1,high);
    }

    /**
     * 插入算法
     * @param array
     * @return
     */
    public int[] insertSorted(int[] array){

        for(int i=0;i<array.length - 1;i++){
            int current = array[i+1];
            int pre = i;

            while (pre >= 0 && array[pre] > current){
                array[pre + 1] = array[pre];
                pre--;
            }

            array[pre + 1] = current;
        }
        return array;
    }



    @Test
    public void test(){
        //定义数组
        int[] arr = new int[]{11,2,33,4,5,6,3,222,33};

        //冒泡排序
//        int[] ints = bubbleSorted(arr);
//        System.out.println(Arrays.toString(ints));

        //快速排序
//        int[] ins1 = quicklySorted(arr);
//        System.out.println(Arrays.toString(ins1));

        //插入排序
//        int[] ints2 = insertSorted(arr);
//        System.out.println(Arrays.toString(ints2));
    }


    public void heapify(int[] tree,int n,int i){
        //定义递归出口
        if(i>=n)return ;
        //寻找树的深度为n - 1的两个叶子节点
        int c1 = 2 * i + 1;
        int c2 = 2 * i + 2;
        int max = i;
        //判断界限,如果叶子节点1的值已经越界,不参与比较
        if(c1 < n && tree[c1] > tree[max]){
            max = c1;
        }
        if(c2 < n && tree[c2] > tree[max]){
            max = c2;
        }
        if(max != i){
            swap(tree,max,i);
            heapify(tree,n,max);
        }
    }

    private void swap(int[] tree, int i, int j) {
        int temp = tree[i];
        tree[i] = tree[j];
        tree[j] = temp;
    }

    private void build_heap(int[] tree,int n){
        int last_node = n - 1;
        int parent = (last_node - 1)/2;
        int i;
        for(i = parent;i>=0;i--){
            heapify(tree,n,i);
        }
    }

    private void heap_sort(int[] tree,int n){
        build_heap(tree,n);
        int i;
        for(i= n-1;i>=0;i--){
            swap(tree,i,0);
            heapify(tree,i,0);
        }

    }

    @Test
    public void test01(){
        int[] array = new int[]{4,10,3,5,1,2};
        int n = 6;
        heap_sort(array,n);
        System.out.println(Arrays.toString(array));
    }

}
