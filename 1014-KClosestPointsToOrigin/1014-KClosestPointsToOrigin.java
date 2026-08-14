// Last updated: 8/14/2026, 8:27:18 PM
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        if (points.length < k) {
            return points;
        }

        var maxHeap = new PriorityQueue<>(Comparator.comparingInt((int[] a) -> a[0] * a[0] + a[1] * a[1]).reversed());
        
        for (int[] point : points) {
            maxHeap.add(point);

            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        var result = new int[k][];
        for (int i = 0; i < k; i++) {
            result[i] = maxHeap.poll();
        }

        return result;
    }
}