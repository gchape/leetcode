// Last updated: 5/4/2026, 11:53:31 PM
1class Solution {
2    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
3        if (list1 == null) return list2
4        if (list2 == null) return list1
5
6        return if (list1.`val` <= list2.`val`) {
7            list1.next = mergeTwoLists(list1.next, list2)
8            list1
9        } else {
10            list2.next = mergeTwoLists(list1, list2.next)
11            list2
12        }
13    }
14}