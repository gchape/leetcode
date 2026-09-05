// Last updated: 9/5/2026, 9:26:11 PM
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
12    public ListNode reverseList(ListNode head) {
13        if (head == null) return head;
14
15        ListNode next = head.next;
16        head.next = null;
17        
18        while (next != null) {
19            ListNode nextnext = next.next;
20
21            next.next = head;
22            head = next;
23            next = nextnext;
24        }
25        return head;
26    }
27}