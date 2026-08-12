// Last updated: 8/13/2026, 12:08:11 AM
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
12    private int count;
13
14    public ListNode removeNthFromEnd(ListNode head, int n) {
15        count = 0;
16        return removeNth(head, n);
17    }
18
19    private ListNode removeNth(ListNode node, int n) {
20        if (node == null) {
21            return null;
22        }
23
24        node.next = removeNth(node.next, n);
25
26        count++;
27
28        if (count == n) {
29            return node.next;
30        }
31
32        return node;
33    }
34}