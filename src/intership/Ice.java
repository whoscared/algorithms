package intership;


import java.util.Scanner;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Comparator;
import java.util.stream.Collectors;


public class Ice {
    private static class Pair {
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


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String first = scanner.nextLine();
        long[] first_s = Arrays.stream(first.split(" ")).mapToLong(Long::parseLong).toArray();
        int count = (int)first_s[0];
        int perfect = (int)first_s[1];
        long minutes = first_s[2];
        String s = scanner.nextLine();
        int[] sculptures = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] result = perfectSculptures(count, perfect, minutes, sculptures);
        System.out.println(result.length);
        if (result.length != 0) {
            System.out.println(Arrays.toString(result).replace("[", "")
                    .replace("]", "")
                    .replace(",", ""));
        }
    }

    public static int[] perfectSculptures(int count, int perfect, long minutes, int[] sculptures) {


        List<Integer> perfect_list = new ArrayList<>();

        Pair[] pairs = new Pair[sculptures.length];

        int pairs_index = 0;

        for (int i = 0; i < sculptures.length; i++) {
            if (sculptures[i] == perfect) {
                perfect_list.add(i + 1);
                continue;
            }
            if (Math.abs(sculptures[i] - perfect) <= minutes) {
                pairs[pairs_index] = new Pair(i, Math.abs(sculptures[i] - perfect));
                pairs_index++;
            }
        }

        List<Pair> pairList = Arrays.stream(pairs).filter(Objects::nonNull).sorted(Comparator.comparingInt(Pair::getValue)).collect(Collectors.toList());
        int index_list = 0;
        while (minutes > 0 && index_list < pairList.size()) {
            Pair current = pairList.get(index_list);
            if (minutes - current.getValue() >= 0) {
                minutes -= current.getValue();
                perfect_list.add(current.getKey() + 1);
                index_list++;
            } else {
                break;
            }
        }


        return perfect_list.stream().mapToInt(Integer::valueOf).sorted().toArray();
    }

}
