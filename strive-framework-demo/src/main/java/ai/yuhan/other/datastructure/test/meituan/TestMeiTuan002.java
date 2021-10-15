package ai.yuhan.other.datastructure.test.meituan;

import java.io.*;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @description: 小美是美团仓库的管理员，她会根据单据的要求按顺序取出仓库中的货物，每取出一件货物后会把剩余货物重新堆放，使得自己方便查找。已知货物入库的时候是按顺序堆放在一起的。
 * 如果小美取出其中一件货物，则会把货物所在的一堆物品以取出的货物为界分成两堆，这样可以保证货物局部的顺序不变。
 * 已知货物最初是按 1~n 的顺序堆放的，每件货物的重量为 w[i] ,小美会根据单据依次不放回的取出货物。请问根据上述操作，小美每取出一件货物之后，重量和最大的一堆货物重量是多少？
 * 格式：
 * 输入：
 * - 输入第一行包含一个正整数 n ，表示货物的数量。
 * - 输入第二行包含 n 个正整数，表示 1~n 号货物的重量 w[i] 。
 * - 输入第三行有 n 个数，表示小美按顺序取出的货物的编号，也就是一个 1~n 的全排列。
 * 输出：
 * - 输出包含 n 行，每行一个整数，表示每取出一件货物以后，对于重量和最大的一堆货物，其重量和为多少。
 * 示例：
 * 输入：
 * 5
 * 3 2 4 4 5
 * 4 3 5 2 1
 * 输出：
 * 9
 * 5
 * 5
 * 3
 * 0
 * 解释：
 * 原本的状态是 {{3,2,4,4,5}} ，取出 4 号货物后，得到 {{3,2,4},{5}} ，第一堆货物的和是 9 ，然后取出 3
 * @author: bingcun.chen
 * @Date: 2021/8/23 14:18
 * @Version 1.0
 */
public class TestMeiTuan002 {

//    public static void main(String[] args) throws IOException {
////        Scanner scanner = new Scanner(System.in);
////        Integer size = scanner.nextInt();
////        String[] weight = new String[size];
////        String[] number = new String[size];
////        for (int i = 0; i < 2; i++) {
////            Scanner scanner01 = new Scanner(System.in);
////            String next = scanner01.nextLine();
////            if (i == 0) {
////                weight = next.split(" ");
////            } else {
////                number = next.split(" ");
////            }
////        }
//
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int size = Integer.parseInt(br.readLine());
//        String[] weight = br.readLine().split(" ");
//        String[] number = br.readLine().split(" ");
//        br.close();
//
//        for (int i = 0; i < number.length; i++) {
//            Integer weightSize = Integer.parseInt(number[i]);
//
//            Integer index = --weightSize;
//            Integer left = index;
//            Integer right = index;
//
//            Integer sLeft = 0;
//            while (left > 0) {
//                weight[index] = "0";
//                left--;
//                sLeft += Integer.parseInt(weight[left]);
//
//            }
//
//            Integer sRight = 0;
//            while (right < size - 1) {
//                weight[index] = "0";
//                right++;
//                sRight += Integer.parseInt(weight[right]);
//            }
//
//            System.out.println(Math.max(sLeft, sRight));
//        }
//    }


    static TreeMap<Integer, Integer> map = new TreeMap<>();
    static TreeSet<Integer> bound = new TreeSet<>();
    static int[] prefix = new int[50050];

    public static void main(String[] args) throws Exception {
        // 加速 IO
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split(" ");
        String[] query = br.readLine().split(" ");
        br.close();

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + Integer.parseInt(arr[i]);
        }

        bound.add(0);
        bound.add(n + 1);
        for (int i = 0; i < n; i++) {
            int pos = Integer.parseInt(query[i]);
            Integer left = bound.lower(pos);
            Integer right = bound.higher(pos);
            // 消除警告
            if (left == null || right == null) {
                continue;
            }
            int seg_sum = prefix[right - 1] - prefix[left];
            Integer val = map.get(seg_sum);
            if (val != null) {
                if (val == 1) {
                    map.remove(seg_sum);
                } else {
                    map.put(seg_sum, val - 1);
                }
            }
            int left_sum = prefix[pos - 1] - prefix[left];
            int right_sum = prefix[right - 1] - prefix[pos];
            bound.add(pos);
            map.put(left_sum, map.getOrDefault(left_sum, 0) + 1);
            map.put(right_sum, map.getOrDefault(right_sum, 0) + 1);
            bw.write(map.lastKey() + "\n");
            // StringBuilder 可以加速字符串拼接
            // bw.write(new StringBuilder().append(map.lastKey())
            //          .append('\n').toString());
        }
        bw.close();
    }




}
