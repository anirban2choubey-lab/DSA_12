package leetcode;

public class ReOrderList {
    public void reorderList(ListNode head) {
        ListNode slow = head, fast = head;
        //checking the middle node
        while (fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        //
        ListNode right = slow;
        ListNode prev = new ListNode();
        while (right != null) {
            ListNode temp = right.next;
            right.next = prev;
            prev = right;
            right = temp;
        }
        ListNode dummy = new ListNode();
        //dummy.next = head;
        ListNode res = dummy;
        while (dummy != slow) {
            dummy.next = head;
            head = head.next;
            dummy = dummy.next;
            dummy.next = prev.next;
            dummy = dummy.next;
        }
        //return res.next;
    }
}
