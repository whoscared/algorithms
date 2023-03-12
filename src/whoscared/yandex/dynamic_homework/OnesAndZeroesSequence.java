package whoscared.yandex.dynamic_homework;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class OnesAndZeroesSequence {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("D:\\reborn\\algorithms\\Yandex-Algorithms\\src\\whoscared.yandex.input_output\\input.txt");
        BufferedReader br = new BufferedReader(fr);

        int n = Integer.parseInt(br.readLine());
        fr.close();
        int result = countSequence(n);

        FileWriter fw = new FileWriter("D:\\reborn\\algorithms\\Yandex-Algorithms\\src\\whoscared.yandex.input_output\\output.txt");
        fw.write(String.valueOf(result));
        fw.close();
    }

    public static int countSequence(int n) {
        int[] dp = new int[Math.max(n, 3)];
        dp[0] = 2;
        dp[1] = dp[0] * 2;
        dp[2] = dp[1] * 2 - 1;
        for (int i = 3; i < n; i++) {
            dp[i] += dp[i - 3] + dp[i - 2] + dp[-1];
        }
        return dp[n - 1];
    }
}
