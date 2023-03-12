package whoscared.yandex.stack_homework;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class LineLand {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("D:\\reborn\\algorithms\\Yandex-Algorithms\\src\\whoscared.yandex.stack_homework\\input.txt");
        BufferedReader br = new BufferedReader(fr);
        int count = Integer.parseInt(br.readLine());
        int[] cities = new int[count];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < count; i++) {
            cities[i] = Integer.parseInt(st.nextToken());
        }
        fr.close();

        int[] result = relocation(cities);

        FileWriter fw = new FileWriter("D:\\reborn\\algorithms\\Yandex-Algorithms\\src\\whoscared.yandex.stack_homework\\output.txt");
        for (int cur : result) {
            fw.write(cur + " ");
        }
        fw.close();
    }

    public static int[] relocation(int[] cities) {
        Stack<Pair> searchMin = new Stack<>();
        int[] result = new int[cities.length];
        Arrays.fill(result, -1);
        for (int i = 0; i < cities.length; i++) {
            if (searchMin.empty() || searchMin.peek().getValue() < cities[i]) {
                searchMin.push(new Pair(i, cities[i]));
                continue;
            }
            while (!searchMin.empty() && searchMin.peek().getValue() > cities[i]) {
                Pair current = searchMin.pop();
                result[current.getIndex()] = i;
            }
            searchMin.push(new Pair(i, cities[i]));
        }
        return result;
    }

    public static class Pair {
        final private int index;
        final private int value;

        Pair(int index, int value) {
            this.index = index;
            this.value = value;
        }

        public int getIndex() {
            return index;
        }

        public int getValue() {
            return value;
        }
    }
}
