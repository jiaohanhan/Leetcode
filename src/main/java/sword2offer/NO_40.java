package sword2offer;

/**
 * 平衡二叉树
 * 判断一棵树是不是平衡二叉树
 */
public class NO_40 {
    private boolean isBalanced = true;
    private boolean isBalanced(TreeNode root){
        height(root);
        return isBalanced;
    }

    private int height(TreeNode root) {
        if (root == null) return 0;
        int left = height(root.left);
        int right = height(root.right);
        if (Math.abs(left - right) > 1) {
            isBalanced = false;
        }
        return 1 + Math.max(left, right);
    }

    static class TreeNode{
        int val;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val){
            this.val = val;
        }
    }
}
