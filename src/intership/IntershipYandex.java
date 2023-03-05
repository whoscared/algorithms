package intership;

import java.util.*;

public class IntershipYandex {

//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int count = Integer.parseInt(scanner.nextLine());
//        String ident = scanner.nextLine();
//        String rows = scanner.nextLine();
//        int countSymbols = Integer.parseInt(scanner.nextLine());
//        String paper = scanner.nextLine();
//        System.out.println(IntershipYandex.keyboard(count, ident, rows, countSymbols, paper));
//    }
//
//    public static int keyboard(int count, String ident, String rows, int countSymbols, String paper) {
//        int counter = 0;
//        int[] ident_arr = Arrays.stream(ident.split(" ")).mapToInt(Integer::parseInt).toArray();
//        int[] rows_arr = Arrays.stream(rows.split(" ")).mapToInt(Integer::parseInt).toArray();
//        HashMap<Integer, Integer> ident_row = new HashMap<>();
//        for (int i = 0; i < count; i++) {
//            ident_row.put(ident_arr[i], rows_arr[i]);
//        }
//        int[] paper_arr = Arrays.stream(paper.split(" ")).mapToInt(Integer::parseInt).toArray();
//        for (int i = 1; i < countSymbols; i++) {
//
//            if (!Objects.equals(ident_row.get(paper_arr[i - 1]), ident_row.get(paper_arr[i]))) {
//                counter++;
//            }
//        }
//        return counter;
//    }
//
//    class Pair {
//        private int key;
//
//        private int value;
//
//        Pair(){}
//        Pair(int key, int value){
//            this.key = key;
//            this.value = value;
//        }
//
//        public int getKey() {
//            return key;
//        }
//
//        public void setKey(int key) {
//            this.key = key;
//        }
//
//        public int getValue() {
//            return value;
//        }
//
//        public void setValue(int value) {
//            this.value = value;
//        }
//    }
//
//    public Integer[] editFigures(int[] figures, int x, int t) {
//
//        Set<Pair> set = new TreeSet<>((o1, o2) -> o1.getValue() - o2.getValue());
//        for (int i = 0; i < figures.length; i++) {
//            set.add(new Pair(i, Math.abs(figures[i] - x)));
//        }
//        int k = 0;
//        Iterator<Pair> iterator = set.iterator();
//        List<Integer> result = new ArrayList<>();
//        while (k < t) {
//            if (!iterator.hasNext()) {
//                break;
//            }
//            Pair pair = iterator.next();
//            if (pair.getValue() > t - k) {
//                break;
//            }
//            k += pair.getValue();
//            result.add(pair.getKey());
//        }
//        result.sort();
//        return result.toArray();
//    }
}
