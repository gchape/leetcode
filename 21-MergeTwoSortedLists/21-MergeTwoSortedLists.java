// Last updated: 8/13/2026, 2:00:17 PM
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
13    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
14        ListNode dummy = new ListNode(-101);
15        ListNode curr = dummy;
16
17        while (list1 != null && list2 != null) {
18            if (list1.val < list2.val) {
19                curr.next = list1;
20                list1 = list1.next;
21            } else {
22                curr.next = list2;
23                list2 = list2.next;
24            }
25            curr = curr.next;
26        }
27
28        if (list1 != null) {
29            curr.next = list1;
30        } else if (list2 != null) {
31            curr.next = list2;
32        }
33
34        return dummy.next;   
35    }
36}