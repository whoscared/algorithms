package whoscared.yandex.dynamic_homework;

import java.io.*;
import java.util.StringTokenizer;

public class Grasshopper {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("D:\\reborn\\algorithms\\Yandex-Algorithms\\src\\whoscared.yandex.input_output\\input.txt");
        BufferedReader br = new BufferedReader(fr);
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        fr.close();

        int result = count(n, k);

        FileWriter fw = new FileWriter("D:\\reborn\\algorithms\\Yandex-Algorithms\\src\\whoscared.yandex.input_output\\output.txt");
        fw.write(String.valueOf(result));
        fw.close();
    }

    public static int count(int n, int k) {
        int[] bp = new int[n];
        bp[0] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= i - k && j >= 0; j--) {
                bp[i] += bp[j];
            }
        }
        return bp[n - 1];
    }
}
