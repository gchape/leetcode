// Last updated: 8/10/2026, 11:37:33 PM
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
12    private ListNode left;
13
14    public boolean isPalindrome(ListNode head) {
15        left = head;
16        return check(head);
17    }
18
19    private boolean check(ListNode right) {
20        if (right == null) return true;
21        if (!check(right.next)) return false;
22        if (left.val != right.val) return false;
23
24        left = left.next;
25        return true;
26    }
27}