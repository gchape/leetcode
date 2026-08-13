// Last updated: 8/13/2026, 3:30:34 PM
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
14        if (head == null) return false;
15
16        var nodes = new IdentityHashMap<ListNode, Boolean>();
17
18        while (head.next != null) {
19            if (nodes.containsKey(head)) {
20                return true;
21            } else {
22                nodes.put(head, true);
23            }
24            head = head.next;
25        }
26
27        return false;
28    }
29}