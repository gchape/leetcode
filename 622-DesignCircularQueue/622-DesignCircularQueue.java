// Last updated: 8/15/2026, 3:00:01 PM
1class MyCircularQueue {
2
3    private final int[] queue;
4    
5    private int head = 0;
6    private int size = 0;
7
8    public MyCircularQueue(int k) {
9        queue = new int[k];
10    }
11
12    public boolean enQueue(int value) {
13        if (isFull()) {
14            return false;
15        }
16
17        int tail = (head + size) % queue.length;
18        queue[tail] = value;
19        size++;
20
21        return true;
22    }
23
24    public boolean deQueue() {
25        if (isEmpty()) {
26            return false;
27        }
28
29        head = (head + 1) % queue.length;
30        size--;
31
32        return true;
33    }
34
35    public int Front() {
36        if (isEmpty()) {
37            return -1;
38        }
39
40        return queue[head];
41    }
42
43    public int Rear() {
44        if (isEmpty()) {
45            return -1;
46        }
47
48        int tail = (head + size - 1) % queue.length;
49        return queue[tail];
50    }
51
52    public boolean isEmpty() {
53        return size == 0;
54    }
55
56    public boolean isFull() {
57        return size == queue.length;
58    }
59}