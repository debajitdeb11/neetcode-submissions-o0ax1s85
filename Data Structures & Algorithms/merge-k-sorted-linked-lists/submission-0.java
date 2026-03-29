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
    public ListNode mergeKLists(ListNode[] lists) {
        
        // check if the list is empty
        if (lists.length == 0) {
            return null;
        }

        ListNode left = lists[0];


        for(int i = 1; i < lists.length; i++) {
            ListNode res = new ListNode(0, left);
            ListNode head = res;

            ListNode right = lists[i];

            while (left != null && right != null) {
                if (left.val <= right.val) {
                    res.next = left;
                    left = left.next;
                } else {
                    res.next = right;
                    right = right.next;
                }

                System.out.println(res.val);
                res = res.next;
            }

            res.next = (left != null) ? left : right;
            left = head.next;
        }

        return left;

    }
}
