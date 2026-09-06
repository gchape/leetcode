// Last updated: 9/6/2026, 9:12:19 AM
1class Solution {
2
3    public int[] topKFrequent(int[] nums, int k) {
4        Map<Integer, Integer> occurences = HashMap.newHashMap(nums.length);
5
6        for (var num : nums) {
7            occurences.merge(num, 1, (old_, new_) -> old_ + new_);
8        }
9
10        var minHeap = new PriorityQueue<Map.Entry<Integer, Integer>>(k, Map.Entry.comparingByValue());
11
12        for (var e : occurences.entrySet()) {
13            minHeap.add(e);
14            if (minHeap.size() > k) {
15                minHeap.poll();
16            }
17        }
18
19        int[] result = new int[k];
20
21        for (int i = 0; i < k; i++) {
22            result[i] = minHeap.poll().getKey();
23        }
24
25        return result;
26    }
27}