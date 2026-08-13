// Last updated: 8/13/2026, 3:34:19 PM
1/**
2 * Definition for singly-linked list.
3 * class ListNode {
4 *     int val;
5 *     ListNode next;
6 *     ListNode(int x) {
7 *         val = x;
8 *         next = null;
9 *     }
10 * }
11 */
12public class Solution {
13    public boolean hasCycle(ListNode head) {
14        Set<ListNode> seen = new HashSet<>();
15
16        while (head != null) {
17            if (!seen.add(head)) {
18                return true;
19            }
20
21            head = head.next;
22        }
23
24        return false;
25    }
26}