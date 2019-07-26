package sword2offer;
import java.util.Stack;

/**
 * 题目描述：二叉树中和为某一值的路径
 *      输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 *      从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 *
 * 解题思路：对二叉树进行前序遍历，访问到某一个结点的时候，就把该结点添加到路径上
 *      并累加该结点的值。如果该结点为叶子结点并且刚好等于输入的整数，则当前路径符
 *      合要求。如果当前结点不是叶子结点，则继续访问它的孩子结点，当结点访问结束之后
 *      递归函数会自动回到它的父节点。因此我们在函数退出之前要在路径上删除当前结点并
 *      减去当前结点的值，以确保返回父结点时路径刚好是从根结点到父节点的路径。其实也
 *      就是一个栈。
 *
 */
public class NO_25 {

    public static void main(String[] args) {
        BT_Node root = new BT_Node(10);
        BT_Node node1 = new BT_Node(5);
        BT_Node node2 = new BT_Node(4);
        BT_Node node3 = new BT_Node(7);
        BT_Node node4 = new BT_Node(12);
        root.setLChild(node1);
        root.setRChild(node4);
        node1.setLChild(node2);
        node1.setRChild(node3);
        findPath(root, 22);

    }

    private static void findPath(BT_Node root, int i) {
        if (root == null)
            return;
        Stack<Integer> stack = new Stack();
        int currentSum = 0;
        findPath(root, i, stack, currentSum);
    }

    private static void findPath(BT_Node root, int i, Stack<Integer> stack, int currentSum) {
        currentSum += root.getData();
        stack.push(root.getData());
        if (root.getLChild() == null && root.getRChild() == null) {
            if (currentSum == i) {
                System.out.print("找到路径: ");
                for (int path : stack) {
                    System.out.print(path + " ");
                }
                System.out.println();
            }
        }
        if (root.getLChild() != null) {
            findPath(root.getLChild(), i, stack, currentSum);
        }
        if (root.getRChild() != null) {
            findPath(root.getRChild(), i, stack, currentSum);
        }
        stack.pop();

    }

}

class BT_Node {
    private int data;
    private BT_Node LChild;
    private BT_Node RChild;

    public BT_Node(int data) {
        super();
        this.data = data;
    }

    public int getData() {
        return data;
    }
    public void setData(int data) {
        this.data = data;
    }
    public BT_Node getLChild() {
        return LChild;
    }
    public void setLChild(BT_Node lChild) {
        LChild = lChild;
    }
    public BT_Node getRChild() {
        return RChild;
    }
    public void setRChild(BT_Node rChild) {
        RChild = rChild;
    }
}

