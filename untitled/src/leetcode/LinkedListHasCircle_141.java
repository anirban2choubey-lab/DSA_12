package leetcode;

public class LinkedListHasCircle_141 {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode slow = new ListNode();
        slow.next = head;
        ListNode fast = head;
        while (slow != fast) {
            slow = slow.next;
            if (fast == null || fast.next == null)
                return false;
            fast = fast.next.next;
        }
        return true;
    }
}
