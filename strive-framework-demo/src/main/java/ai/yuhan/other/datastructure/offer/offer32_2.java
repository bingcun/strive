package ai.yuhan.other.datastructure.offer;

import org.junit.Test;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @description:
 * @author: bingcun.chen
 * @Date: 2021/6/28 9:35
 * @Version 1.0
 */
public class offer32_2 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 广度优先遍历 借助队列
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
        }
        List<List<Integer>> resultList = new ArrayList<>();
        while (!queue.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode poll = queue.poll();
                tmp.add(poll.val);

                if (poll.left != null) {
                    queue.add(poll.left);
                }

                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }
            resultList.add(tmp);
        }
        return resultList;
    }

    @Test
    public void test() {
        TreeNode treeNode = new TreeNode(3);
        TreeNode treeNode01 = new TreeNode(9);
        TreeNode treeNode02 = new TreeNode(20);
        TreeNode treeNode03 = new TreeNode(15);
        TreeNode treeNode04 = new TreeNode(7);

        treeNode.left = treeNode01;
        treeNode.right = treeNode02;
        treeNode01.left = null;
        treeNode01.right = null;

        treeNode02.left = treeNode03;
        treeNode02.right = treeNode04;

        List<List<Integer>> lists = levelOrder(treeNode);

        System.out.println("123456");


    }

}
