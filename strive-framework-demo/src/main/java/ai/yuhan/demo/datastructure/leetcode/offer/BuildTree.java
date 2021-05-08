package ai.yuhan.demo.datastructure.leetcode.offer;
/**
 * @Author: bingcun.chen
 * @Date: 2021/3/20 18:23
 * @Version: 1.0
 * @Email: 820306546@qq.com
 */
public class BuildTree {

    public static void main(String[] args) {
        int[] preorder = {1,2,3,4,5,6,7};
        int[] inorder = {3,2,4,1,6,5,7};
        TreeNode treeNode = reConstructBinaryTree(preorder, inorder);
        System.out.println(123);

    }
    static int preindex = 0;
    static int inindex = 0;

    public static TreeNode reConstructBinaryTree(int [] preorder,int [] inorder) {
        return dfs(preorder,inorder,null);
    }

    private static TreeNode dfs(int[] preorder, int[] inorder, TreeNode finish) {
        if(preindex == preorder.length || (finish != null && inorder[inindex] == finish.val)){
            return null;
        }

        TreeNode root = new TreeNode(preorder[preindex++]);

        root.left = dfs(preorder,inorder,root);

        inindex ++;

        root.right = dfs(preorder,inorder,finish);
        return root;
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }


}

