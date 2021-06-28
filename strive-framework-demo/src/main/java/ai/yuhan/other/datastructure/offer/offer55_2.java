package ai.yuhan.other.datastructure.offer;

import sun.reflect.generics.tree.Tree;

/**
 * @description: 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 * @author: bingcun.chen
 * @Date: 2021/6/28 15:37
 * @Version 1.0
 */
public class offer55_2 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 判断一颗树是否是平衡二叉树
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }else {
            return Math.abs(treeNodeHigher(root.left) - treeNodeHigher(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
        }
    }
    public int treeNodeHigher(TreeNode root){
        if(root == null){
            return 0;
        }else {
            return Math.max(treeNodeHigher(root.left),treeNodeHigher(root.right)) + 1;
        }
    }
}
