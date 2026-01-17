package leetcode;

public class Reverse_linkedList_206 {
    public static void main(String[] args) {

    }

    public ListNode reverseList(ListNode head) {
        if (head == null)
            return null;

        ListNode previous = null;
        ListNode current = head;
        while (current != null) {
            ListNode nxt = current.next;;
            current.next = previous;
            previous = current;
            current = nxt;
            nxt = nxt.next;
        }
        return previous;
    }
}
