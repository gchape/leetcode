// Last updated: 8/10/2026, 11:57:11 PM
1class MyQueue {
2
3    private final Deque<Integer> toRemove = new ArrayDeque<>();
4    private final Deque<Integer> toAdd = new ArrayDeque<>();
5
6    public MyQueue() {
7    }
8
9    public void push(int x) {
10        toAdd.push(x);
11    }
12
13    public int pop() {
14        if (toRemove.isEmpty()) {
15            while (!toAdd.isEmpty()) {
16                toRemove.push(toAdd.pop());
17            }
18        }
19        return toRemove.pop();
20    }
21
22    public int peek() {
23        if (toRemove.isEmpty()) {
24            while (!toAdd.isEmpty()) {
25                toRemove.push(toAdd.pop());
26            }
27        }
28        return toRemove.peek();
29    }
30
31    public boolean empty() {
32        return toRemove.isEmpty() && toAdd.isEmpty();
33    }
34}
35
36/**
37 * Your MyQueue object will be instantiated and called as such:
38 * MyQueue obj = new MyQueue();
39 * obj.push(x);
40 * int param_2 = obj.pop();
41 * int param_3 = obj.peek();
42 * boolean param_4 = obj.empty();
43 */