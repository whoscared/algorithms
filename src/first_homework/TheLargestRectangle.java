package first_homework;

import java.io.*;
import java.util.StringTokenizer;

public class TheLargestRectangle {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("D:\\reborn\\algorithms\\Yandex-Algorithms\\src\\homework\\input.txt");
        BufferedReader br = new BufferedReader(fr);
        int countPoints = Integer.parseInt(br.readLine());

        int[][] points = new int[countPoints][2];
        for (int i = 0; i < countPoints; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            points[i][0] = Integer.parseInt(st.nextToken());
            points[i][1] = Integer.parseInt(st.nextToken());
        }

        fr.close();

        int[][] rectangle = getTheLargestRectangle(points);
        FileWriter fw = new FileWriter("D:\\reborn\\algorithms\\Yandex-Algorithms\\src\\homework\\output.txt");
        fw.write(rectangle[0][0] + " " + rectangle[0][1] + " " + rectangle[1][0] + " " + rectangle[1][1]);
        fw.close();
    }

    public static int[][] getTheLargestRectangle(int[][] points) {
        int[][] rectangle = new int[2][2];
        if (points.length == 0) {
            return rectangle;
        }

        rectangle[0][0] = points[0][0];
        rectangle[1][0] = points[0][0];
        rectangle[0][1] = points[0][1];
        rectangle[1][1] = points[0][1];

        for (int[] point : points) {
            rectangle[0][0] = Math.min(rectangle[0][0], point[0]);
            rectangle[1][0] = Math.max(rectangle[1][0], point[0]);
            rectangle[0][1] = Math.min(rectangle[0][1], point[1]);
            rectangle[1][1] = Math.max(rectangle[1][1], point[1]);
        }

        return rectangle;
    }
}
