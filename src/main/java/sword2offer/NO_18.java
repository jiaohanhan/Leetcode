package sword2offer;

/**
 * 题目描述：树的子结构
 *      输入两颗二叉树A和B，判断B是不是A的子结构。
 */
public class NO_18 {
    public static void main(String[] args){
        //第一棵树
        BinaryTreeNode node1 = new BinaryTreeNode(8);
        BinaryTreeNode node2 = new BinaryTreeNode(8);
        BinaryTreeNode node3 = new BinaryTreeNode(7);
        BinaryTreeNode node4 = new BinaryTreeNode(9);
        BinaryTreeNode node5 = new BinaryTreeNode(2);
        BinaryTreeNode node6 = new BinaryTreeNode(4);
        BinaryTreeNode node7 = new BinaryTreeNode(7);
        node1.setLChild(node2);
        node1.setRChild(node3);
        node2.setLChild(node4);
        node2.setRChild(node5);
        node5.setLChild(node6);
        node5.setRChild(node7);

        //第二棵树
        BinaryTreeNode node_1 = new BinaryTreeNode(8);
        BinaryTreeNode node_2 = new BinaryTreeNode(9);
        BinaryTreeNode node_3 = new BinaryTreeNode(2);
        node_1.setLChild(node_2);
        node_1.setRChild(node_3);
        System.out.println(hasSubTree(node1, node_1));
    }

    public static boolean hasSubTree(BinaryTreeNode root1,BinaryTreeNode root2){
        boolean result = false;
        if(root1 != null && root2 != null){
            if(root1.getData() == root2.getData()){
                result = doseTree1HaveTree2(root1,root2);
                if(!result){
                    result = hasSubTree(root1.getLChild(), root2);
                }
                if(!result){
                    result = hasSubTree(root1.getRChild(), root2);
                }
            }
        }
        return result;
    }

    private static boolean doseTree1HaveTree2(BinaryTreeNode root1, BinaryTreeNode root2) {
        if(root2 == null)
            return true;
        if(root1 == null)
            return false;
        if(root1.getData() != root2.getData())
            return false;


        return doseTree1HaveTree2(root1.getLChild(), root2.getLChild())
                && doseTree1HaveTree2(root1.getRChild(), root2.getRChild());
    }

    static class BinaryTreeNode{
        private int data;
        private BinaryTreeNode LChild;
        private BinaryTreeNode RChild;


        public BinaryTreeNode(int data) {
            super();
            this.data = data;
        }
        public int getData() {
            return data;
        }
        public void setData(int data) {
            this.data = data;
        }
        public BinaryTreeNode getLChild() {
            return LChild;
        }
        public void setLChild(BinaryTreeNode lChild) {
            LChild = lChild;
        }
        public BinaryTreeNode getRChild() {
            return RChild;
        }
        public void setRChild(BinaryTreeNode rChild) {
            RChild = rChild;
        }

    }

}



