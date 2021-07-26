package ai.yuhan.other.datastructure.offer;

import ai.yuhan.other.multithreading.thread.SemaphoreDemo;
import io.lettuce.core.output.StatusOutput;
import org.junit.Test;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 68 - I. 二叉搜索树的最近公共祖先
 * @author: bingcun.chen
 * @Date: 2021/7/10 16:46
 * @Version 1.0
 */
public class offer68_1 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pNodePath = getPath(root,p);
        List<TreeNode> qNodePath = getPath(root,q);

        TreeNode ancestor = null;
        for(int i=0;i<pNodePath.size() && i<qNodePath.size();i++){
            if(pNodePath.get(i) == qNodePath.get(i)){
                ancestor = pNodePath.get(i);
            }else {
                break;
            }

        }
        return ancestor;
    }

    private List<TreeNode> getPath(TreeNode root, TreeNode target) {
        List<TreeNode> list = new ArrayList<>();
        TreeNode node = root;
        while (node != target){
            list.add(node);
            if(target.val < node.val){
                node = node.left;
            }else {
                node = node.right;
            }
        }
        list.add(node);
        return list;
    }

    @Test
    public void test01(){
        TreeNode treeNode01 = new TreeNode(6);
        TreeNode treeNode02 = new TreeNode(2);
        TreeNode treeNode03 = new TreeNode(8);
        TreeNode treeNode04 = new TreeNode(0);
        TreeNode treeNode05 = new TreeNode(4);
        TreeNode treeNode06 = new TreeNode(7);
        TreeNode treeNode07 = new TreeNode(9);
        TreeNode treeNode08 = new TreeNode(3);
        TreeNode treeNode09 = new TreeNode(5);

        treeNode01.left = treeNode02;
        treeNode01.right = treeNode03;

        treeNode02.left = treeNode04;
        treeNode02.right = treeNode05;

        treeNode03.left = treeNode06;
        treeNode03.right = treeNode07;

        treeNode06.left = treeNode08;
        treeNode06.right = treeNode09;

        TreeNode treeNode = lowestCommonAncestor(treeNode01, treeNode02, treeNode03);
        System.out.println("sss");

    }


}
