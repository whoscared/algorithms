package whoscared.yandex.heap_homework;

public class MyHeapMin {
    private final int size = 100000;
    private final int[] elements = new int[size];
    private int current;

    public MyHeapMin() {
        current = -1;
    }

    public void insert(int x) {
        if (current == -1) {
            elements[++current] = x;
            return;
        }
        elements[++current] = x;
        up();
    }

    public Integer extract() {
        if (current == -1 ) {
            return null;
        }
        int result = elements[0];
        elements[0] = elements[current];
        elements[current] = 0;
        current--;
        down();
        return result;
    }

    private void up() {
        int index = current;
        while (((index - 1) / 2 >= 0) && elements[(index - 1) / 2] > elements[index]) {
            int temp = elements[(index - 1) / 2];
            elements[(index - 1) / 2] = elements[index];
            elements[index] = temp;
            index = (index - 1) / 2;
        }
    }

    private void down() {
        int index = 0;

        while ((2 * index + 2 <= current)) {
            int first = 2 * index + 1;
            int second = 2 * index + 2;
            if (elements[second] < elements[index]
                    && elements[second] < elements[first]) {

                int temp = elements[second];
                elements[second] = elements[index];
                elements[index] = temp;

                index = second;

            } else if (elements[first] < elements[index]) {

                int temp = elements[first];
                elements[first] = elements[index];
                elements[index] = temp;

                index = first;

            } else {
                break;
            }
        }

        int first = 2 * index + 1;
        if ((first <= current) && (elements[2 * index + 1] < elements[index])){
            int temp = elements[first];
            elements[first] = elements[index];
            elements[index] = temp;
        }
    }
}
