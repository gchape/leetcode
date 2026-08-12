// Last updated: 8/12/2026, 8:17:38 PM
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
17        ListNode insert = list1;
18        ListNode curr = list2;
19        ListNode prev = null;
20        
21        ListNode head = list2;
22
23        while (curr != null && insert != null) {
24            if (curr.val < insert.val) {
25                prev = curr;
26                curr = curr.next;
27            } else {
28                if (prev == null) {
29                    head = insert;
30                    prev = insert;
31                    insert = insert.next;
32                    prev.next = curr;
33                } else {
34                    ListNode next = insert.next;
35
36                    prev.next = insert;
37                    insert.next = curr;
38
39                    prev = insert;
40                    insert = next;
41                }
42            }
43        }
44
45        if (insert != null) {
46            prev.next = insert;
47        }
48
49        return head;
50    }
51}