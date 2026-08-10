// Last updated: 8/10/2026, 11:32:40 PM
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
20        if (right == null) {
21            return true;
22        }
23
24        if (!check(right.next)) {
25            return false;
26        }
27
28        if (left.val != right.val) {
29            return false;
30        }
31
32        left = left.next;
33        return true;
34    }
35}