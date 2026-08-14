// Last updated: 8/14/2026, 5:18:33 PM
1class Solution {
2    public int lastStoneWeight(int[] stones) {
3        if (stones == null || stones.length == 0) {
4            return 0;
5        }
6
7        var pq = new PriorityQueue<Integer>(Comparator.reverseOrder());
8
9        for (var stone : stones) {
10            pq.offer(stone);
11        }
12
13        while (pq.size() > 1) {
14            int first = pq.poll();
15            int second = pq.poll();
16
17            if (first != second) {
18                pq.offer(first - second);
19            }
20        }
21
22        return pq.isEmpty() ? 0 : pq.poll();
23    }
24}