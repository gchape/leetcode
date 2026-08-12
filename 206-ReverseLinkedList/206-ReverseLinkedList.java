// Last updated: 8/12/2026, 6:11:57 PM
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
12    private ListNode tail;
13
14    public ListNode reverseList(ListNode head) {
15        if (head == null || head.next == null) return head;
16
17        head = reverse(head);
18        head.next = null;
19
20        return tail;
21    }
22
23    private ListNode reverse(ListNode head) {
24        if (head.next == null) {
25            tail = head;
26            return head;
27        }
28
29        var prev = reverse(head.next);
30        prev.next = head;
31
32        return head;
33    }
34}