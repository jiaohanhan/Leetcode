package sword2offer;

import java.util.HashSet;
import java.util.Set;

/**
 * 链表中环得入口节点
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则输出null
 */
public class NO_54 {
    public ListNode entryNodeOfLoop(ListNode pHead) {
        ListNode fast = pHead;
        ListNode slow = pHead;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                ListNode p = pHead;
                while (p != slow) {
                     p = p.next;
                     slow = slow.next;
                }
                return p;
            }
        }
        return null;
    }

    // 利用HashSet
    public ListNode entryNodeOfLoop1(ListNode pHead) {
        Set<ListNode> set = new HashSet<ListNode>();
        while (pHead != null) {
            if (!set.add(pHead)) {
                return pHead;
            }
            pHead = pHead.next;
        }
        return null;
    }


    static class ListNode{
        int val;
        ListNode next;
        public ListNode(int val){
            this.val = val;
        }
    }
}
