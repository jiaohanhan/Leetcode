package sword2offer;

import java.util.Stack;

/**
 * 对称二叉树
 * 题目描述：判断一棵树二叉树是不是对称的
 */
public class NO_57 {

    public boolean isSymmetrical(TreeNode root) {
        if (root == null) return true;
        else return isSymmetrical(root.left, root.right);
    }

    // 递归
    private boolean isSymmetrical(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null) return false;
        if (right == null) return false;
        if (left.val != right.val) return false;
        return isSymmetrical(left.left, right.right) && isSymmetrical(left.right, right.left);
    }

    public boolean isSymmetrical2(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root.left);
        stack.push(root.right);
        while (!stack.isEmpty()) {
            TreeNode right = stack.pop();
            TreeNode left = stack.pop();
            if (left == null && right == null) continue;;
            if (left == null || right == null) return false;
            if (right.val != left.val) return false;
            stack.push(left.left);
            stack.push(right.right);
            stack.push(left.right);
            stack.push(right.left);
        }
        return true;
    }


    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }
    }
}
