package whoscared.yandex.dynamic_homework;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class TheCheapestWay {
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
        int result = minCountFood(n, m, table);

        FileWriter fw = new FileWriter("D:\\reborn\\algorithms\\Yandex-Algorithms\\src\\whoscared\\yandex\\input_output\\output.txt");
        fw.write(String.valueOf(result));
        fw.close();
    }

    public static int minCountFood(int n, int m, int[][] table) {

        int[][] resultTable = new int[n + 1][m + 1];

        for (int i = 2; i < n+1; i++) {
            resultTable[i][0] = Integer.MAX_VALUE;
        }

        for (int j = 2; j < m+1; j++) {
            resultTable[0][j] = Integer.MAX_VALUE;
        }


        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                resultTable[i][j] += table[i][j];
                resultTable[i][j] += Math.min(resultTable[i - 1][j], resultTable[i][j - 1]);
            }
        }

        return resultTable[n][m];
    }
}
