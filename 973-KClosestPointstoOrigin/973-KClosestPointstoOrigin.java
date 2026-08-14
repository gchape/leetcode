// Last updated: 8/14/2026, 8:25:34 PM
1class Solution {
2    public int[][] kClosest(int[][] points, int k) {
3        if (points.length < k) {
4            return points;
5        }
6
7        var maxHeap = new PriorityQueue<>(Comparator.comparingInt((int[] a) -> a[0] * a[0] + a[1] * a[1]).reversed());
8        
9        for (int[] point : points) {
10            maxHeap.add(point);
11
12            if (maxHeap.size() > k) {
13                maxHeap.poll();
14            }
15        }
16
17        var result = new int[k][];
18        for (int i = 0; i < k; i++) {
19            result[i] = maxHeap.poll();
20        }
21
22        return result;
23    }
24}