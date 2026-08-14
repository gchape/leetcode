// Last updated: 8/14/2026, 8:29:14 PM
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

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;

        var prev = head;
        head = prev.next;

        ListNode curr;
        ListNode tail = null;
        while (prev != null && prev.next != null) {
            curr = prev.next;
            var next = curr.next;

            curr.next = prev;
            prev.next = null;

            if (tail != null) {
                tail.next = curr;
            }

            tail = prev;
            prev = next;
        }

        if (prev != null) {
            tail.next = prev;
        }

        return head;
    }
}