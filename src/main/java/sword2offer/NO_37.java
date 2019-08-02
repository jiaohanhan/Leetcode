package sword2offer;

import java.util.Stack;

/**
 * 两个链表的第一个公共节点
 * 输入两个链表，找出它们的第一个公共结点
 */
public class NO_37 {
    /**
     * 放入堆栈中，从尾部开始遍历，直到遍历到最后一个重合节点
     * 时间 O(m+n)   空间 O(m+n)
     */
    public ListNode findFirstCommonNode(ListNode pHead1, ListNode pHead2){
        Stack<ListNode> s1 = new Stack<ListNode>();
        Stack<ListNode> s2 = new Stack<ListNode>();
        while(pHead1 != null){
            s1.push(pHead1);
            pHead1 = pHead1.next;
        }
        while(pHead2 != null){
            s2.push(pHead2);
            pHead2 = pHead2.next;
        }
        ListNode foundNode = null;
        while (!s1.isEmpty() && !s2.isEmpty()) {
            ListNode node = s1.pop();
            if(node == s2.pop()) foundNode = node;
            else return foundNode;
        }
        return foundNode;
    }

    /**
     * 快慢指针
     * 先遍历每一个链表，然后就知道长链表比短链表长多少，然后让长链表指针先走长度差，短的再出发，
     */
    public ListNode findFirstCommonNode2(ListNode pHead1, ListNode pHead2){
        if (pHead1 == null || pHead2 == null) return null;
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        int len1 = genLength(p1);
        int len2 = genLength(p2);
        if (len1 > len2) {
            int diffLen = len1 - len2;
            while(diffLen-- > 0) p1 = p1.next;
        }
        if (len2 > len1) {
            int diffLen = len2 - len1;
            while(diffLen-- > 0) p2 = p2.next;
        }
        // 慢指针开始一起走
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }

    private int genLength(ListNode p) {
        int len = 0;
        ListNode cur = p;
        while(cur != null){
            ++len;
            cur = cur.next;
        }
        return len;
    }


    class ListNode{
        int val;
        ListNode next = null;
        ListNode(int val){
            this.val = val;
        }
    }
}
