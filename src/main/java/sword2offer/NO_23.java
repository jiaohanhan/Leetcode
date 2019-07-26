package sword2offer;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 题目描述：从上往下打印二叉树
 *      从上往下打印出二叉树的每个结点，同一层的结点按照从左到由的顺序打印。
 *
 * 解题思路：就是实现层次遍历
 *
 */
public class NO_23 {
    public static void main(String[] args) {
        MBtNode node1 = new MBtNode(8);
        MBtNode node2 = new MBtNode(6);
        MBtNode node3 = new MBtNode(10);
        MBtNode node4 = new MBtNode(5);
        MBtNode node5 = new MBtNode(7);
        MBtNode node6 = new MBtNode(9);
        MBtNode node7 = new MBtNode(11);
        node1.setLChild(node2);
        node1.setRChild(node3);
        node2.setLChild(node4);
        node2.setRChild(node5);
        node3.setLChild(node6);
        node3.setRChild(node7);

        printFromTopToBottom(node1);
    }

    private static void printFromTopToBottom(MBtNode root){
        if(root == null)
            return;
        Queue<MBtNode> queue = new LinkedList();
        queue.add(root);
        while(!queue.isEmpty()){
            MBtNode node = queue.poll();
            System.out.println(node.getData());
            if(node.getLChild() != null)
                queue.add(node.getLChild());
            if(node.getRChild() != null)
                queue.add(node.getRChild());
        }
    }

}
class MBtNode{
    private int data;
    private MBtNode LChild;
    private MBtNode RChild;
    public MBtNode(int data) {
        super();
        this.data = data;
    }
    public int getData() {
        return data;
    }
    public void setData(int data) {
        this.data = data;
    }
    public MBtNode getLChild() {
        return LChild;
    }
    public void setLChild(MBtNode lChild) {
        LChild = lChild;
    }
    public MBtNode getRChild() {
        return RChild;
    }
    public void setRChild(MBtNode rChild) {
        RChild = rChild;
    }

}

