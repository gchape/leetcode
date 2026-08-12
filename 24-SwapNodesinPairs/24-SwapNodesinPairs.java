// Last updated: 8/12/2026, 11:42:12 PM
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
12
13    public ListNode swapPairs(ListNode head) {
14        if (head == null || head.next == null)
15            return head;
16
17        var prev = head;
18        head = prev.next;
19        ListNode curr, connector = null;
20
21        while (prev != null && prev.next != null) {
22            curr = prev.next;
23            var next = curr.next;
24
25            curr.next = prev;
26            prev.next = null;
27
28            if (connector != null) {
29                connector.next = curr;
30            }
31
32            connector = prev;
33            prev = next;
34        }
35
36        if (prev != null) {
37            connector.next = prev;
38        }
39
40        return head;
41    }
42}