package whoscared.yandex.first_homework;

import java.io.*;

public class Test {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("D:\\reborn\\algorithms\\Yandex-Algorithms\\src\\homework\\input.txt");
        BufferedReader br = new BufferedReader(fr);

        int classmates = Integer.parseInt(br.readLine());
        int options = Integer.parseInt(br.readLine());
        int row = Integer.parseInt(br.readLine());
        int side = Integer.parseInt(br.readLine());

        fr.close();

        FileWriter fw = new FileWriter("D:\\reborn\\algorithms\\Yandex-Algorithms\\src\\homework\\output.txt");

        int[] result = seats(classmates, options, row, side);
        StringBuilder res = new StringBuilder();
        for (int curr : result) {
            res.append(curr).append("\n");
        }
        fw.write(res.toString());
        fw.close();
    }

    public static int[] seats(int classmates, int options, int row, int side) {
        int resultSide = options % 2 == 0 ? side : (side == 1 ? 2 : 1);

        int seat = row * 2;
        seat -= side == 1 ? 1 : 0;

        int firstRow = seat - options;
        int secondRow = seat + options;

        firstRow = firstRow > 0 ? firstRow / 2 : -1;
        secondRow = secondRow <= classmates ? secondRow / 2 : -1;

        if (resultSide == 1) {
            firstRow += firstRow == -1 ? 0 : 1;
            secondRow += secondRow == -1 ? 0 : 1;
        }

        if (firstRow == -1 && secondRow == -1) {
            return new int[]{-1};
        }

        if (firstRow == -1 || (secondRow != -1 && row - firstRow - 1 >= secondRow - row - 1 )) {
            return new int[]{secondRow, resultSide};
        } else {
            return new int[]{firstRow, resultSide};
        }

    }
}
