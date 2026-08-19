// Last updated: 8/19/2026, 9:32:27 AM
class MyCircularQueue {

    private final int[] queue;
    
    private int head = 0;
    private int size = 0;

    public MyCircularQueue(int k) {
        queue = new int[k];
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }

        int tail = (head + size) % queue.length;
        queue[tail] = value;
        size++;

        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }

        head = (head + 1) % queue.length;
        size--;

        return true;
    }

    public int Front() {
        if (isEmpty()) {
            return -1;
        }

        return queue[head];
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        }

        int tail = (head + size - 1) % queue.length;
        return queue[tail];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == queue.length;
    }
}