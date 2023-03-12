package whoscared.yandex.dynamic_homework;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Tacks {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("D:\\reborn\\algorithms\\Yandex-Algorithms\\src\\whoscared.yandex.input_output\\input.txt");
        BufferedReader br = new BufferedReader(fr);
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] coordinates = new int[n];
        for (int i = 0; i < coordinates.length; i++) {
            coordinates[i] = Integer.parseInt(st.nextToken());
        }
        fr.close();

        int result = minCountLength(coordinates);

        FileWriter fw = new FileWriter("D:\\reborn\\algorithms\\Yandex-Algorithms\\src\\whoscared.yandex.input_output\\output.txt");
        fw.write(String.valueOf(result));
        fw.close();
    }

    public static int minCountLength(int[] coordinates) {
        Arrays.sort(coordinates);
        if (coordinates.length <= 1) {
            return 0;
        }
        int[] dp = new int[coordinates.length];
        dp[0] = Integer.MAX_VALUE;
        dp[1] = coordinates[1] - coordinates[0];
        for (int i = 2; i < coordinates.length; i++) {
            int prev = coordinates[i] - coordinates[i - 1];
            dp[i] = Math.min(dp[i - 2], dp[i - 1]) + prev;
        }
        return dp[dp.length - 1];
    }
}
