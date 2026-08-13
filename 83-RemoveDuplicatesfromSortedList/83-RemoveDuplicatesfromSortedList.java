// Last updated: 8/13/2026, 3:50:22 PM
1/**
2 * Definition for singly-linked list.
3 * public class ListNode {
4 *     int val;
5 *     ListNode next;
6 *     ListNode() {}
7 *     ListNode(int val) { this.val = val; }
8 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
9 * }
10 */
11class Solution {
12
13    public ListNode deleteDuplicates(ListNode head) {
14        if (head == null || head.next == null) return head;
15
16        var curr = head;
17        while (curr.next != null) {
18            if (curr.val == curr.next.val) {
19                curr.next = curr.next.next;
20            } else {
21                curr = curr.next;
22            }
23        }
24
25        return head;
26    }
27}