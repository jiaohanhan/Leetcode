package sword2offer;

import java.util.*;

/**
 * 按照之字型打印二叉树
 */
public class NO_58 {

    public List<List<Integer>> print(TreeNode root) {
        List<List<Integer>> res = new ArrayList();
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        boolean flag = false; // 转向
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<Integer>();
            int size = queue.size();
            while (size-- > 0) {
                TreeNode node = queue.poll();
                if (node == null) continue;
                list.add(node.val);
                queue.add(node.left);
                queue.add(node.right);
            }
            if (flag) Collections.reverse(list);
            flag = !flag;
            if (list.size() != 0) {
                res.add(list);
            }
        }
        return res;
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
