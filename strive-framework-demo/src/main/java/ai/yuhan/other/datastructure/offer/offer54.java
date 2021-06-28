package ai.yuhan.other.datastructure.offer;

/**
 * @description:
 * @author: bingcun.chen
 * @Date: 2021/6/28 11:06
 * @Version 1.0
 */
public class offer54 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * todo 需要理解
     */
    int res, k;
    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return res;
    }
    void dfs(TreeNode root) {
        if(root == null) return;
        dfs(root.right);
        if(k == 0) return;
        if(--k == 0) res = root.val;
        dfs(root.left);
    }


}
