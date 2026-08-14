// Last updated: 8/14/2026, 8:29:15 PM
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
        var pg = new PriorityQueue<Map.Entry<Integer, ListNode>>(Map.Entry.comparingByKey());

        for (ListNode list : lists) {
            if (list != null) {
                pg.offer(Map.entry(list.val, list));
            }
        }

        ListNode head = new ListNode(Integer.MIN_VALUE);

        ListNode curr = head;
        while (!pg.isEmpty()) {
            var minNode = pg.poll();
            curr.next = minNode.getValue();
            curr = curr.next;

            if (minNode.getValue().next != null) {
                pg.offer(Map.entry(minNode.getValue().next.val, minNode.getValue().next));
            }
        }
        curr.next = null;

        return head.next;
    }
}