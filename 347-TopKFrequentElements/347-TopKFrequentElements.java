// Last updated: 8/14/2026, 8:03:16 PM
1class Solution {
2    public int[] topKFrequent(int[] nums, int k) {
3        if (nums.length == 0 || k <= 0 || k > nums.length) {
4            return new int[0];
5        }
6
7        // 1. Count frequencies
8        Map<Integer, Integer> frequencies = new HashMap<>();
9
10        for (int num : nums) {
11            frequencies.merge(num, 1, Integer::sum);
12        }
13
14        // 2. Put numbers into buckets by frequency
15        List<Integer>[] buckets = new List[nums.length + 1];
16
17        for (var entry : frequencies.entrySet()) {
18            int frequency = entry.getValue();
19
20            if (buckets[frequency] == null) {
21                buckets[frequency] = new ArrayList<>();
22            }
23
24            buckets[frequency].add(entry.getKey());
25        }
26
27        // 3. Take numbers from highest frequency to lowest
28        int[] result = new int[k];
29        int index = 0;
30
31        for (int freq = buckets.length - 1; freq > 0 && index < k; freq--) {
32            if (buckets[freq] == null) {
33                continue;
34            }
35
36            for (int num : buckets[freq]) {
37                result[index++] = num;
38
39                if (index == k) {
40                    break;
41                }
42            }
43        }
44
45        return result;
46    }
47}