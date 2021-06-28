package ai.yuhan.other.datastructure.offer;

import org.junit.Test;
import sun.reflect.generics.tree.Tree;

/**
 * @description:
 * @author: bingcun.chen
 * @Date: 2021/6/27 13:31
 * @Version 1.0
 */
public class offer28 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        return root == null ? true : buildTreeNode(root.left, root.right);
    }

    private boolean buildTreeNode(TreeNode L,TreeNode R) {
        if(L == null && R ==null){
            return true;
        }
        if(L == null || R == null || L.val != R.val){
            return false;
        }
        return buildTreeNode(L.left,R.right) && buildTreeNode(L.right,R.left);
    }



}
