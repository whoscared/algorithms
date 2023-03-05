package intership;

import java.util.*;

public class IceSecond {
    class Pair {
        private int key;

        private int value;

        Pair() {
        }

        Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }
        public int getKey() {
            return key;
        }
        public void setKey(int key) {
            this.key = key;
        }
        public int getValue() {
            return value;
        }
        public void setValue(int value) {
            this.value = value;
        }
    }

    public Integer[] editFigures(int[] figures, int x, int t) {
        Set<Pair> set = new TreeSet<>((o1, o2) -> o1.getValue() - o2.getValue());
        for (int i = 0; i < figures.length; i++) {
            set.add(new Pair(i, Math.abs(figures[i] - x)));
        }
        int k = 0;
        Iterator<Pair> iterator = set.iterator();
        List<Integer> result = new ArrayList<>();
        while (k < t) {
            if (!iterator.hasNext()) {
                break;
            }
            Pair pair = iterator.next();
            if (pair.getValue() > t - k) {
                break;
            }
            k += pair.getValue();
            result.add(pair.getKey());
        }
        result.sort(Comparator.comparing(o -> o));
        return result.toArray(new Integer[0]);
    }
}
