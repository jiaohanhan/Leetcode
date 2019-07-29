package sword2offer;

import java.util.Stack;

/**
 * 二叉搜索树与双向链表
 *
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表，要求不能创建任何新的结点，只能调整树中结点指针的指向
 *
 * 思路：按照右中左的顺序，中序遍历对结点的访问顺序和转换完链表的从左到右的顺序是一样的。
 *  所以在中序遍历时完成相邻两个结点的互指即可。
 *  pre.right = cur; cut.left = pre;
 */
public class NO_27 {
    static class TreeNode{
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val){this.val = val;}
    }

    TreeNode pre = null;
    private TreeNode convert(TreeNode pRootOfTree){
        if(pRootOfTree == null) return pRootOfTree;
        convert(pRootOfTree.right);
        if(pre == null) pre = pRootOfTree;
        else {
            pre.left = pRootOfTree;
            pRootOfTree.right = pre;
            pre = pRootOfTree;
        }
        convert(pRootOfTree.left);
        return pre;
    }

    // 非递归
    private TreeNode convert_(TreeNode pRootOfTree){
        if(pRootOfTree == null) return pRootOfTree;
        TreeNode listHeader = null;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (pRootOfTree != null || !stack.isEmpty()) {
            if (pRootOfTree != null){
                stack.push(pRootOfTree);
                pRootOfTree = pRootOfTree.right;
            } else {
                pRootOfTree = stack.pop();
                if (listHeader == null) {
                    listHeader = pRootOfTree;
                } else {
                    listHeader.left = pRootOfTree;
                    pRootOfTree.right = listHeader;
                    listHeader = pRootOfTree;
                }
                pRootOfTree = pRootOfTree.left;
            }
        }
        return listHeader;
    }

}


