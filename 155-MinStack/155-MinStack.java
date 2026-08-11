// Last updated: 8/11/2026, 6:32:49 PM
1import java.util.Map;
2import java.util.Stack;
3
4class MinStack {
5
6    private final Stack<Map.Entry<Integer, Integer>> minStack;
7
8    private int min = Integer.MAX_VALUE;
9
10    public MinStack() {
11        this.minStack = new Stack<>();
12    }
13
14    public void push(int value) {
15        min = Math.min(min, value);
16        minStack.push(Map.entry(value, min));
17    }
18
19    public void pop() {
20        minStack.pop();
21
22        if (!minStack.isEmpty()) {
23            min = minStack.peek().getValue();
24        } else {
25            min = Integer.MAX_VALUE;
26        }
27    }
28
29    public int top() {
30        return minStack.peek().getKey();
31    }
32
33    public int getMin() {
34        return minStack.peek().getValue();
35    }
36}