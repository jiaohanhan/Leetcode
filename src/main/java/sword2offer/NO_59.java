package sword2offer;

/**
 * 二叉搜索树的第k个节点
 * 题目描述：给定一棵二叉搜索树，请找出其中的第k小的结点
 */
public class NO_59 {

    private TreeNode ret;
    private int cnt = 0;

    TreeNode kthNode(TreeNode root, int k) {
        inorder(root, k);
        return ret;
    }

    private void inorder(TreeNode root, int k) {
        if (root == null || cnt > k) {
            return;
        }
        inorder(root.left, k);
        cnt++;
        if (cnt == k) ret = root;
        inorder(root.right, k);
    }


    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.val = val;
        }
    }
}
