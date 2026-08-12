// Last updated: 8/12/2026, 10:18:13 PM
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
13    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
14        if (l1 == null)
15            return l2;
16        if (l2 == null)
17            return l1;
18
19        var h1 = l1;
20        var h2 = l2;
21
22        ListNode result = new ListNode(0);
23        var curr = result;
24
25        int sum = 0;
26        while (h1 != null || h2 != null) {
27            if (h1 == null) {
28                sum += h2.val;
29                h2 = h2.next;
30            } else if (h2 == null) {
31                sum += h1.val;
32                h1 = h1.next;
33            } else {
34                sum += h1.val + h2.val;
35                h1 = h1.next;
36                h2 = h2.next;
37            }
38
39            int digit = sum % 10;
40            sum /= 10;
41
42            curr.next = new ListNode(digit);
43            curr = curr.next;
44        }
45
46        if (sum > 0) {
47            curr.next = new ListNode(sum);
48        }
49
50        return result.next;
51    }
52}