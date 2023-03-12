package whoscared.yandex.first_homework;

import java.io.*;
import java.util.StringTokenizer;

public class MatrixSum {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("D:\\reborn\\algorithms\\Yandex-Algorithms\\src\\homework\\input.txt");
        BufferedReader br = new BufferedReader(fr);
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] request = new int[k][4];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 4; j++) {
                request[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        fr.close();

        int[] result = prefixSumOfMatrix(matrix, request);
        FileWriter fw = new FileWriter("D:\\reborn\\algorithms\\Yandex-Algorithms\\src\\homework\\output.txt");
        for (int res : result) {
            fw.write(res + "\n");
        }

        fw.close();
    }

    public static int[] sumOfMatrix(int[][] matrix, int[][] request) {
        int[] sum = new int[request.length];
        if (request.length == 0) {
            return sum;
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int indexSum = 0;
                while (indexSum < sum.length) {
                    if (i + 1 >= request[indexSum][0]
                            && j + 1 >= request[indexSum][1]
                            && i + 1 <= request[indexSum][2]
                            && j + 1 <= request[indexSum][3]) {
                        sum[indexSum] += matrix[i][j];
                    }
                    indexSum++;
                }
            }
        }

        return sum;
    }

    public static int[] prefixSumOfMatrix(int[][] matrix, int[][] request) {
        int[] sum = new int[request.length];
        if (request.length == 0) {
            return sum;
        }

        int[][] prefixSum = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < prefixSum.length; i++) {
            for (int j = 0; j < prefixSum[i].length; j++) {
                prefixSum[i][j] += matrix[i][j];
                prefixSum[i][j] += i > 0 ? prefixSum[i - 1][j] : 0;
                prefixSum[i][j] += j > 0 ? prefixSum[i][j - 1] : 0;
                prefixSum[i][j] -= i > 0 && j > 0 ? prefixSum[i - 1][j - 1] : 0;
            }
        }

        for (int i = 0; i < request.length; i++) {
            int minI = request[i][0] - 1;
            int minJ = request[i][1] - 1;
            int maxI = request[i][2] - 1;
            int maxJ = request[i][3] - 1;
            sum[i] += prefixSum[maxI][maxJ];
            sum[i] -= minI - 1 >= 0 ? prefixSum[minI - 1][maxJ] : 0;
            sum[i] -= minJ - 1 >= 0 ? prefixSum[maxI][minJ - 1] : 0;
            sum[i] += minI - 1 >= 0 && minJ - 1 >= 0 ? prefixSum[minI - 1][minJ - 1] : 0;
        }

        return sum;
    }
}
