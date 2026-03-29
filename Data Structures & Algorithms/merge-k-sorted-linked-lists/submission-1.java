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
        if (lists.length == 0) {
            return null;
        }

        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> (a.val - b.val));

        for (int i = 0; i < lists.length; i++) {
            ListNode temp = lists[i];

            while(temp != null) {
                pq.add(temp);
                temp = temp.next;
            }
        }

        ListNode res = new ListNode(-1);
        ListNode head = res;

        while(!pq.isEmpty()) {
            res.next = pq.remove();
            res = res.next;
        }

        return head.next;

    }
}
