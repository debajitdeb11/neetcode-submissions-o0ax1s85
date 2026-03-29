/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        if (n == 1 && head.next == null) {
            return null;
        }

        ListNode res = new ListNode(-1, head);

        ListNode slow = res;
        ListNode fast = head;

        int count = 0;

        while(count < n) {
            fast = fast.next;
            count++;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // remove the link
        slow.next = slow.next.next;

        return res.next;
    }
}
