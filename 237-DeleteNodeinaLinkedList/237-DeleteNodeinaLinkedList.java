// Last updated: 8/13/2026, 2:46:42 PM
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
12        while (node.next != null) {
13            node.val = node.next.val;
14
15            if (node.next.next == null) {
16                node.next = null;
17            } else {
18                node = node.next;
19            }
20        }
21    }
22}