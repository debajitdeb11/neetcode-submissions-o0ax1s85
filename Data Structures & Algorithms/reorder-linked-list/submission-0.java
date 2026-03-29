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
    public void reorderList(ListNode head) {
        ListNode list1 = head;

        // 1. find the mid of the node
        ListNode mid = findMid(head);

        // 2. Reverse the 2nd half of the list
        ListNode list2 = reverse(mid);

        while(list2 != null) {
            ListNode l1Next = list1.next;
            ListNode l2Next = list2.next;

            list1.next = list2;
            list2.next = l1Next;

            list1 = l1Next;
            list2 = l2Next;
        }

        if (list1 != null) {
            list1.next = null;
        }

    }

    private ListNode findMid(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode mid = slow.next;
        slow.next = null;

        return mid;
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = null;
        ListNode next = null;

        while (head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        return prev;
    }
}
