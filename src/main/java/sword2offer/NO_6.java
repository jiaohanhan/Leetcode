package sword2offer;

/**
 * 题目描述：输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 *      假设输入的前序遍历和中序遍历的结果中都不含重复的数字。例如输入
 *      前序遍历序列{1，2，4，7，3，5，6，8}和中序遍历序列{4，7，2，1
 *      ，5，3，8，6}，则重建出如下图所示的二叉树并输出它的头结点。
 *
 *          1
 *      2       3
 *    4      5     6
 *       7       8
 *
 *
 * 解题思路：前序遍历的第一个数字就是根结点的值。在中序遍历中根结点左侧的
 *      都是左子树的结点，在根结点右侧都是右子树。
 *
 *
 */
public class NO_6 {
    public static void main(String[] args) {
        String preOrder = "12473568";
        String midOrder = "47215386";
        BiTree tree = new BiTree(preOrder, midOrder, preOrder.length());
        tree.postRootTraverse(tree.root);
    }

}

class BiTree{
    TreeNode root;

    public BiTree(String preOrder,String midOrder, int count){
        if(count <= 0)
            return;

        //找到根结点所在位置
        int i = 0;
        for (; i < count; i++) {
            if (midOrder.charAt(i) == preOrder.charAt(0))  break;
        }

        root = new TreeNode(preOrder.charAt(0));
        root.setLChild(new BiTree(preOrder.substring(1, i+1),
                midOrder.substring(0,i), i).root);
        root.setRChild(new BiTree(preOrder.substring(i+1),
                midOrder.substring(i+1), count-i-1).root);
    }

    public void postRootTraverse(TreeNode root){
        if(root != null){
            postRootTraverse(root.getLChild());
            postRootTraverse(root.getRChild());
            System.out.print(root.getData());
        }
    }
}

class TreeNode {

    private char data;
    private TreeNode LChild;
    private TreeNode RChild;

    public TreeNode(char data){
        super();
        this.data = data;
    }

    public TreeNode(char data, TreeNode LChild, TreeNode RChild) {
        super();
        this.data = data;
        this.LChild = LChild;
        this.RChild = RChild;
    }
    public char getData() {
        return data;
    }
    public void setData(char data) {
        this.data = data;
    }
    public TreeNode getLChild() {
        return LChild;
    }
    public void setLChild(TreeNode LChild) {
        this.LChild = LChild;
    }
    public TreeNode getRChild() {
        return RChild;
    }
    public void setRChild(TreeNode RChild) {
        this.RChild = RChild;
    }
}

