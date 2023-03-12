package whoscared.yandex.queue_homework;

public class MyQueue {
    private final int size = 200;
    private final int[] elements = new int[size];

    private int start;
    private int end;


    MyQueue() {
        start = 0;
        end = 0;
    }

    void push(int x) {
        elements [end++ % size] = x;
    }

    Integer pop() {
        return start == end ? null : elements [start++ % size];
    }

    Integer front() {
        return start == end ? null : elements[start % size];
    }

    int size() {
        return end - start;
    }

    void clear() {
        end = start;
    }
}
