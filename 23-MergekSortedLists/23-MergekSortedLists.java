// Last updated: 8/14/2026, 4:16:58 PM
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
12    public ListNode mergeKLists(ListNode[] lists) {
13        var pg = new PriorityQueue<Map.Entry<Integer, ListNode>>(Map.Entry.comparingByKey());
14
15        for (ListNode list : lists) {
16            if (list != null) {
17                pg.offer(Map.entry(list.val, list));
18            }
19        }
20
21        ListNode head = new ListNode(Integer.MIN_VALUE);
22
23        ListNode curr = head;
24        while (!pg.isEmpty()) {
25            var minNode = pg.poll();
26            curr.next = minNode.getValue();
27            curr = curr.next;
28
29            if (minNode.getValue().next != null) {
30                pg.offer(Map.entry(minNode.getValue().next.val, minNode.getValue().next));
31            }
32        }
33        curr.next = null;
34
35        return head.next;
36    }
37}