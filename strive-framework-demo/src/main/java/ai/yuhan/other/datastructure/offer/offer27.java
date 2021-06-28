package ai.yuhan.other.datastructure.offer;

import org.junit.Test;

/**
 * @description:
 * @author: bingcun.chen
 * @Date: 2021/6/27 13:31
 * @Version 1.0
 */
public class offer27 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public TreeNode mirrorTree(TreeNode root) {
        if(root == null){
            return null;
        }

        TreeNode left = mirrorTree(root.left);
        TreeNode right = mirrorTree(root.right);

        root.left = right;
        root.right = left;

        return root;
    }

    @Test
    public void test(){
        TreeNode treeNode01 = new TreeNode(4);
        TreeNode treeNode02 = new TreeNode(2);
        TreeNode treeNode03 = new TreeNode(7);
        TreeNode treeNode04 = new TreeNode(1);
        TreeNode treeNode05 = new TreeNode(3);
        TreeNode treeNode06 = new TreeNode(6);
        TreeNode treeNode07 = new TreeNode(9);

        treeNode01.left = treeNode02;
        treeNode01.right = treeNode03;
        treeNode02.left = treeNode04;
        treeNode02.right = treeNode05;
        treeNode03.left = treeNode06;
        treeNode03.right = treeNode07;


        System.out.println(mirrorTree(treeNode01));
        System.out.println(1111);
    }

}
