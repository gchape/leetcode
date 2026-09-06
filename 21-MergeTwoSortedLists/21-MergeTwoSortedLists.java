// Last updated: 9/6/2026, 9:29:41 AM
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
14        if (list1 == null) return list2;
15        if (list2 == null) return list1;
16
17        ListNode dummy = new ListNode();
18        ListNode head = dummy;
19
20        while (list1 != null && list2 != null) {
21            if (list1.val <= list2.val) {
22                head.next = new ListNode(list1.val);
23                list1 = list1.next;
24            } else {
25                head.next = new ListNode(list2.val);
26                list2 = list2.next;
27            }
28            head = head.next;
29        }
30
31        if (list1 != null) {
32            while (list1 != null) {
33                head.next = new ListNode(list1.val);
34                list1 = list1.next;
35                head = head.next;
36            }
37        } else if (list2 != null) {
38            while (list2 != null) {
39                head.next = new ListNode(list2.val);
40                list2 = list2.next;
41                head = head.next;
42            }
43        }
44        
45        return dummy.next;
46    }
47}