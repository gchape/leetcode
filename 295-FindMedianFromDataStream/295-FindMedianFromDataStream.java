// Last updated: 8/14/2026, 8:27:46 PM
public class MedianFinder {

    private final PriorityQueue<Integer> lower = new PriorityQueue<>(Comparator.reverseOrder()); // max-heap
    private final PriorityQueue<Integer> upper = new PriorityQueue<>();                          // min-heap

    public void addNum(int num) {
        // Route the number into the correct half.
        if (lower.isEmpty() || num <= lower.peek()) {
            lower.add(num);
        } else {
            upper.add(num);
        }

        // Rebalance so sizes never differ by more than 1,
        // with lower allowed at most one extra element.
        if (lower.size() > upper.size() + 1) {
            upper.add(lower.poll());
        } else if (upper.size() > lower.size()) {
            lower.add(upper.poll());
        }
    }

    public double findMedian() {
        if (lower.isEmpty()) {
            throw new IllegalStateException("findMedian() called before any addNum()");
        }
        return lower.size() == upper.size()
                ? (lower.peek() + upper.peek()) / 2.0
                : lower.peek();
    }
}
/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */