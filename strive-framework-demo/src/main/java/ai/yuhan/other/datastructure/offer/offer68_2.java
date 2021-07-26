package ai.yuhan.other.datastructure.offer;

import org.junit.Test;

/**
 * @description: 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * 例如，给定如下二叉树: root =[3,5,1,6,2,0,8,null,null,7,4]
 * @author: bingcun.chen
 * @Date: 2021/6/29 11:00
 * @Version 1.0
 */
public class offer68_2 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            // p q 一个在左，一个在右
            return root;
        }
        if (left != null) {
            // p q 都在左子树
            return left;
        }
        if (right != null) {
            // p q 都在右子树
            return right;
        }
        return null;
    }

    @Test
    public void test01(){
        TreeNode treeNode01 = new TreeNode(3);
        TreeNode treeNode02 = new TreeNode(5);
        TreeNode treeNode03 = new TreeNode(1);
        TreeNode treeNode04 = new TreeNode(6);
        TreeNode treeNode05 = new TreeNode(2);
        TreeNode treeNode06 = new TreeNode(0);
        TreeNode treeNode07 = new TreeNode(8);
        TreeNode treeNode08 = new TreeNode(7);
        TreeNode treeNode09 = new TreeNode(4);

        treeNode01.left = treeNode02;
        treeNode01.right = treeNode03;

        treeNode02.left = treeNode04;
        treeNode02.right = treeNode05;

        treeNode03.left = treeNode06;
        treeNode03.right = treeNode07;

        treeNode05.left = treeNode08;
        treeNode05.right = treeNode09;

        TreeNode treeNode = lowestCommonAncestor(treeNode01, treeNode04, treeNode07);
        System.out.println("sss");

    }
}
