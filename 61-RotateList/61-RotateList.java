// Last updated: 8/13/2026, 5:03:07 PM
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
12    public ListNode rotateRight(ListNode head, int k) {
13        if (head == null || head.next == null) return head;
14
15        // Find length and tail
16        int n = 1;
17        ListNode tail = head;
18
19        while (tail.next != null) {
20            tail = tail.next;
21            n++;
22        }
23
24        k %= n;
25        if (k == 0) return head;
26
27        // Make circular
28        tail.next = head;
29
30        // Find new tail
31        int steps = n - k;
32        ListNode newTail = head;
33
34        for (int i = 1; i < steps; i++) {
35            newTail = newTail.next;
36        }
37
38        ListNode newHead = newTail.next;
39
40        // Break circle
41        newTail.next = null;
42
43        return newHead;
44    }
45}