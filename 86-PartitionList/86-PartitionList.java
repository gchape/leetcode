// Last updated: 8/13/2026, 4:38:26 PM
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
12    public ListNode partition(ListNode head, int x) {
13        ListNode smaller = new ListNode(0);
14        ListNode biggerEqual = new ListNode(0);
15
16        ListNode smallTail = smaller;
17        ListNode bigTail = biggerEqual;
18
19        while (head != null) {
20            if (head.val < x) {
21                smallTail.next = head;
22                smallTail = smallTail.next;
23            } else {
24                bigTail.next = head;
25                bigTail = bigTail.next;
26            }
27
28            head = head.next;
29        }
30
31        bigTail.next = null;
32        smallTail.next = biggerEqual.next;
33
34        return smaller.next;
35    }
36}