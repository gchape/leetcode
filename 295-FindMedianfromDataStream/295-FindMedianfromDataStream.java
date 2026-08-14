// Last updated: 8/14/2026, 4:34:40 PM
1public class MedianFinder {
2
3    private final PriorityQueue<Integer> lower = new PriorityQueue<>(Comparator.reverseOrder()); // max-heap
4    private final PriorityQueue<Integer> upper = new PriorityQueue<>();                          // min-heap
5
6    public void addNum(int num) {
7        // Route the number into the correct half.
8        if (lower.isEmpty() || num <= lower.peek()) {
9            lower.add(num);
10        } else {
11            upper.add(num);
12        }
13
14        // Rebalance so sizes never differ by more than 1,
15        // with lower allowed at most one extra element.
16        if (lower.size() > upper.size() + 1) {
17            upper.add(lower.poll());
18        } else if (upper.size() > lower.size()) {
19            lower.add(upper.poll());
20        }
21    }
22
23    public double findMedian() {
24        if (lower.isEmpty()) {
25            throw new IllegalStateException("findMedian() called before any addNum()");
26        }
27        return lower.size() == upper.size()
28                ? (lower.peek() + upper.peek()) / 2.0
29                : lower.peek();
30    }
31}
32/**
33 * Your MedianFinder object will be instantiated and called as such:
34 * MedianFinder obj = new MedianFinder();
35 * obj.addNum(num);
36 * double param_2 = obj.findMedian();
37 */