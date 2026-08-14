// Last updated: 8/14/2026, 8:29:21 PM
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
    private int count;

    public ListNode removeNthFromEnd(ListNode head, int n) {
        count = 0;
        return removeNth(head, n);
    }

    private ListNode removeNth(ListNode node, int n) {
        if (node == null) {
            return null;
        }

        node.next = removeNth(node.next, n);

        count++;

        if (count == n) {
            return node.next;
        }

        return node;
    }
}