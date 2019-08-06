package sword2offer;

/**
 * 二叉树的下一个节点
 * 题目描述：给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并返回
 */
public class NO_56 {

    public TreeLinkNode getNext(TreeLinkNode pNode) {
        if (pNode.right != null) {
            TreeLinkNode node = pNode.right;
            while (node.left != null) {
                // 如果有右子树，则查找右子树的最左结点
                node = node.left;
            }
            return node;
        } else {
            while (pNode.next != null) {
                TreeLinkNode parent = pNode.next;
                // 没有右子树，则找第一个当前节点是父节点左孩子的节点
                if (parent.left == pNode) {
                    return parent;
                }
                pNode = pNode.next;
            }
        }
        return null;
    }

    static class TreeLinkNode{
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;
        public TreeLinkNode(int val){
            this.val = val;}
    }
}
