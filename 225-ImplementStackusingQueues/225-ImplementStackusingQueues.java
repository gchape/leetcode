// Last updated: 8/11/2026, 12:36:16 AM
1class MyStack {
2    Queue<Integer> q;
3
4    public MyStack() {
5        q = new LinkedList<>();
6    }
7
8    public void push(int x) {
9        q.add(x);
10
11        for (int i = 0; i < q.size() - 1; i++) {
12            q.add(q.remove());
13        }
14    }
15
16    public int pop() {
17        return q.remove();
18    }
19
20    public int top() {
21        return q.peek();
22    }
23
24    public boolean empty() {
25        return q.isEmpty();
26    }
27}