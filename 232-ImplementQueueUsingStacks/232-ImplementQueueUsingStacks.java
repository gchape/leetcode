// Last updated: 8/12/2026, 5:54:02 PM
class MyQueue {

    private final Deque<Integer> toRemove = new ArrayDeque<>();
    private final Deque<Integer> toAdd = new ArrayDeque<>();

    public MyQueue() {
    }

    public void push(int x) {
        toAdd.push(x);
    }

    public int pop() {
        if (toRemove.isEmpty()) {
            while (!toAdd.isEmpty()) {
                toRemove.push(toAdd.pop());
            }
        }
        return toRemove.pop();
    }

    public int peek() {
        if (toRemove.isEmpty()) {
            while (!toAdd.isEmpty()) {
                toRemove.push(toAdd.pop());
            }
        }
        return toRemove.peek();
    }

    public boolean empty() {
        return toRemove.isEmpty() && toAdd.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */