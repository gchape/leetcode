// Last updated: 8/14/2026, 8:27:14 PM
class Solution {
    public int lastStoneWeight(int[] stones) {
        if (stones == null || stones.length == 0) {
            return 0;
        }

        var pq = new PriorityQueue<Integer>(Comparator.reverseOrder());

        for (var stone : stones) {
            pq.offer(stone);
        }

        while (pq.size() > 1) {
            int first = pq.poll();
            int second = pq.poll();

            if (first != second) {
                pq.offer(first - second);
            }
        }

        return pq.isEmpty() ? 0 : pq.poll();
    }
}