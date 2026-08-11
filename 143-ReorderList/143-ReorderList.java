// Last updated: 8/11/2026, 7:19:55 PM
1class Solution {
2    public void reorderList(ListNode head) {
3        if (head == null || head.next == null) return;
4
5        // 1. Find middle
6        ListNode slow = head;
7        ListNode fast = head;
8
9        while (fast.next != null && fast.next.next != null) {
10            slow = slow.next;
11            fast = fast.next.next;
12        }
13
14        // 2. Split and reverse second half
15        ListNode second = slow.next;
16        slow.next = null;
17
18        ListNode prev = null;
19        while (second != null) {
20            ListNode next = second.next;
21            second.next = prev;
22            prev = second;
23            second = next;
24        }
25
26        // prev is now the head of reversed second half
27        second = prev;
28
29        // 3. Merge
30        ListNode first = head;
31
32        while (second != null) {
33            ListNode firstNext = first.next;
34            ListNode secondNext = second.next;
35
36            first.next = second;
37            second.next = firstNext;
38
39            first = firstNext;
40            second = secondNext;
41        }
42    }
43}