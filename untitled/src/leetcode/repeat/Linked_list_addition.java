package leetcode.repeat;

import leetcode.ListNode;

public class Linked_list_addition {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode li = new ListNode();
        ListNode res = li;
        int sum = 0, carry = 0;
        while (l1 != null && l2 != null) {
            int temp = l1.val + l2.val + carry;
            sum = temp % 10;
            carry = temp / 10;
            li.next = new ListNode(sum);
            li = li.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int temp = l1.val + carry;
            sum = temp % 10;
            carry = temp / 10;
            l1 = l1.next;
            li.next = new ListNode(sum);
            li = li.next;
            //l2=l2.next;
        }
        while (l2 != null) {
            int temp = l2.val + carry;
            sum = temp % 10;
            carry = temp / 10;
            //l1=l1.next;
            l2 = l2.next;
            li.next = new ListNode(sum);
            li = li.next;
        }
        if (carry > 0)
            li.next = new ListNode(sum);
        li = li.next;
        return res.next;
    }
}
