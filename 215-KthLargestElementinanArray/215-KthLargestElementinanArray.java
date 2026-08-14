// Last updated: 8/14/2026, 5:37:06 PM
1class Solution {
2    public int findKthLargest(int[] nums, int k) {
3        if (nums == null || nums.length == 0 || k > nums.length) {
4            return -1;
5        }
6
7        var maxHeap = new PriorityQueue<Integer>(Comparator.reverseOrder());
8        for (var c : nums) {
9            maxHeap.offer(c);
10        }
11
12        int kthMax = Integer.MAX_VALUE;
13        while (k-- > 0) {
14            kthMax = Math.min(kthMax, maxHeap.poll());
15        }
16
17        return kthMax;
18    }
19}