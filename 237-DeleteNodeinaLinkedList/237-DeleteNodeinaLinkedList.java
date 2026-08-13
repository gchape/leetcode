// Last updated: 8/13/2026, 2:50:56 PM
1/**
2 * Definition for singly-linked list.
3 * public class ListNode {
4 *     int val;
5 *     ListNode next;
6 *     ListNode(int x) { val = x; }
7 * }
8 */
9class Solution {
10
11    public void deleteNode(ListNode node) {
12        node.val = node.next.val;
13        node.next = node.next.next;
14    }
15}