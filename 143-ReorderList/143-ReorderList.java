// Last updated: 8/12/2026, 5:48:23 PM
1class Solution {
2    private ListNode head;
3    private boolean stop;
4
5    public void reorderList(ListNode head) {
6        if (head == null || head.next == null) {
7            return;
8        }
9
10        this.head = head;
11        this.stop = false;
12
13        reorder(head);
14    }
15
16    private void reorder(ListNode tail) {
17        if (tail == null) {
18            return;
19        }
20
21        reorder(tail.next);
22
23        if (stop) {
24            return;
25        }
26
27        // Middle reached
28        if (head == tail || head.next == tail) {
29            tail.next = null;
30            stop = true;
31            return;
32        }
33
34        ListNode next = head.next;
35
36        head.next = tail;
37        tail.next = next;
38
39        head = next;
40    }
41}