package sword2offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的深度
 * 题目描述：输入一棵二叉树，求该树的深度
 */
public class NO_39 {
    /**
     * 递归
     */
    private int treeDeepth(TreeNode root){
        if (root == null) return 0;
        int left = treeDeepth(root.left);
        int right = treeDeepth(root.right);
        return left > right ? left + 1 : right + 1;
    }

    /**
     * 非递归
     * 层次遍历
     */
    private int treeDepth(TreeNode root){
        if (root== null) return 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int depth = 0, count = 0, nextCount = 1;
        while (queue.size() > 0) {
            TreeNode top = queue.poll();
            count++;
            if (top.left != null) queue.add(top.left);
            if(top.right != null) queue.add(top.right);
            if(count == nextCount){
                nextCount = queue.size();
                count = 0;
                depth++;
            }
        }
        return depth;
    }


    static class TreeNode{
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val){
            this.val = val;
        }
    }

}
