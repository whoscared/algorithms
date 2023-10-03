package whoscared.yandex.dynamic_homework;

import java.io.*;
import java.util.StringTokenizer;

public class MaxCostRoute {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("D:\\reborn\\algorithms\\Yandex-Algorithms\\src\\whoscared\\yandex\\input_output\\input.txt");
        BufferedReader br = new BufferedReader(fr);
        StringTokenizer tokenizer1 = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(tokenizer1.nextToken());
        int m = Integer.parseInt(tokenizer1.nextToken());

        int[][] table = new int[n + 1][m + 1];

        for (int i = 1; i < n + 1; i++) {
            tokenizer1 = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j < m + 1; j++) {
                table[i][j] = Integer.parseInt(tokenizer1.nextToken());
            }
        }
        fr.close();

        String[] result = getMaxCostAndRoute(n, m, table);
        FileWriter fw = new FileWriter("D:\\reborn\\algorithms\\Yandex-Algorithms\\src\\whoscared\\yandex\\input_output\\output.txt");
        fw.write(result[0]);
        fw.write("\n");
        fw.write(result[1]);

        fw.close();
    }

    public static String[] getMaxCostAndRoute(int n, int m, int[][] table) {
        int[][] resultTable = new int[n + 1][m + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                resultTable[i][j] = table[i][j];
                if (i == 1 && j == 1) {
                    continue;
                }
                resultTable[i][j] += Math.max(resultTable[i - 1][j], resultTable[i][j - 1]);
            }
        }

        return new String[]{String.valueOf(resultTable[n][m]), getRoute(n, m, resultTable)};
    }

    public static String getRoute (int n, int m, int[][] resultTable) {
        String down = "D";
        String right = "R";

        StringBuilder result = new StringBuilder();

        if (n == 1 && m == 1) {
            return "";
        }
        int i = n;
        int j = m;
        while (!(i == 1 && j == 1 )) {
            if (j == 1 || resultTable[i - 1][j] > resultTable[i][j - 1]) {
                result.append(down);
                i -= 1;
            } else {
                result.append(right);
                j -= 1;
            }
        }
        char[] revers_route = result.toString().toCharArray();
        StringBuilder route = new StringBuilder();
        for (int index = revers_route.length -1; index > 0; index--) {
            route.append(revers_route[index]).append(" ");
        }
        route.append(revers_route[0]);
        return route.toString();
    }
}
