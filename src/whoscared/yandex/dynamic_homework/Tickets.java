package whoscared.yandex.dynamic_homework;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class Tickets {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("D:\\reborn\\algorithms\\Yandex-Algorithms\\src\\whoscared.yandex.input_output\\input.txt");
        BufferedReader br = new BufferedReader(fr);
        int n = Integer.parseInt(br.readLine());
        int[][] times = new int[n + 3][3];
        for (int i = 3; i < times.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            times[i][0] = Integer.parseInt(st.nextToken());
            times[i][1] = Integer.parseInt(st.nextToken());
            times[i][2] = Integer.parseInt(st.nextToken());
        }

        fr.close();
        int result = minTime(n, times);

        FileWriter fw = new FileWriter("D:\\reborn\\algorithms\\Yandex-Algorithms\\src\\whoscared.yandex.input_output\\output.txt");
        fw.write(String.valueOf(result));
        fw.close();
    }

    public static int minTime(int n, int[][] times) {
        int[] dp = new int[n + 3];
        for (int i = 0; i < 3; i++) {
            times[i][0] = Integer.MAX_VALUE;
            times[i][1] = Integer.MAX_VALUE;
            times[i][2] = Integer.MAX_VALUE;
        }
        for (int i = 3; i < dp.length; i++) {
            int timeA = dp[i - 1] + times[i][0];
            int timeB = dp[i - 2] + times[i - 1][1];
            int timeC = dp[i - 3] + times[i - 2][2];
            if (timeA < timeB && timeA < timeC) {
                dp[i] = timeA;
            } else {
                dp[i] = Math.min(timeB, timeC);
            }
        }
        return dp[dp.length -1 ];
    }
}
