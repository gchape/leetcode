// Last updated: 8/12/2026, 7:11:34 PM
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
13    public ListNode removeElements(ListNode head, int val) {
14        if (head == null)
15            return null;
16
17        while (head.val == val) {
18            head = head.next;
19            
20            if (head == null) return null;
21        }
22
23        var curr = head;
24        while (curr.next != null) {
25            if (curr.next.val == val) {
26                curr.next = curr.next.next;
27                continue;
28            }
29            curr = curr.next;
30        }
31
32        return head;
33    }
34}