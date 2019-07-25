package sword2offer;
/**
 * 题目描述：二叉树的镜像
 *      请完成一个函数，输入一个二叉树，该函数输出它的镜像
 *
 * 解题思路：先先序遍历这棵树的每个结点，如果遍历到的结点有子结点，就交换
 *      它的两个子结点，当交换完所有非叶子结点的左右结点的时候，即结果。
 */
public class NO_19 {
    public static void main(String[] args){
        BTNode node1 = new BTNode(8);
        BTNode node2 = new BTNode(6);
        BTNode node3 = new BTNode(10);
        BTNode node4 = new BTNode(5);
        BTNode node5 = new BTNode(7);
        BTNode node6 = new BTNode(9);
        BTNode node7 = new BTNode(11);
        node1.setLChild(node2);
        node1.setRChild(node3);
        node2.setLChild(node4);
        node2.setRChild(node5);
        node3.setLChild(node6);
        node3.setRChild(node7);
        mirror(node1);
        print(node1);
    }
    public static void mirror(BTNode root){
        if(root == null)
            return;
        if(root.getLChild() == null && root.getRChild() == null)
            return;

        BTNode temp = root.getLChild();
        root.setLChild(root.getRChild());
        root.setRChild(temp);
        mirror(root.getLChild());
        mirror(root.getRChild());

    }

    private static void print(BTNode root){
        if(root != null){
            System.out.println(root.getData());
            print(root.getLChild());
            print(root.getRChild());
        }
    }
}

class BTNode{
    private int data;
    private BTNode LChild;
    private BTNode RChild;

    public BTNode(int data) {
        super();
        this.data = data;
    }
    public BTNode getLChild() {
        return LChild;
    }
    public void setLChild(BTNode lChild) {
        LChild = lChild;
    }
    public BTNode getRChild() {
        return RChild;
    }
    public void setRChild(BTNode rChild) {
        RChild = rChild;
    }

    public int getData() {
        return data;
    }
    public void setData(int data) {
        this.data = data;
    }

}
