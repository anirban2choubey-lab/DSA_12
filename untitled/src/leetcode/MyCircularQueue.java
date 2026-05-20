package leetcode;

public class MyCircularQueue {
    int[] data;
    int head = 0, tail = -1, size = 0;
    int length;

    public MyCircularQueue(int k) {
        this.data = new int[k];
        this.length = k;
    }

    public boolean enQueue(int value) {
        if (isFull())
            return false;
        tail = (tail % length) + 1;
        data[tail] = value;
        size++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty())
            return false;
        head = (head % length) + 1;
        size--;
        return true;
    }

    public int Front() {
        if (isEmpty())
            return -1;
        return data[tail];
    }

    public int Rear() {
        if (isEmpty())
            return -1;
        return data[head];
    }

    public boolean isEmpty() {
        return size == length;
    }

    public boolean isFull() {
        return size == length;
    }
}
