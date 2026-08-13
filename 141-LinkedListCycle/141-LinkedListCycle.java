// Last updated: 8/13/2026, 3:31:04 PM
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
17        while (head.next != null) {
18            if (nodes.containsKey(head)) {
19                return true;
20            } else {
21                nodes.put(head, true);
22            }
23            head = head.next;
24        }
25        return false;
26    }
27}