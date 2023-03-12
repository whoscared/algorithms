package whoscared.yandex.first_homework;

import java.util.Scanner;

public class GoodString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());
        int[] symbols = new int[count];
        for (int i = 0; i < count; i++) {
            symbols[i] = Integer.parseInt(scanner.nextLine());
        }

        System.out.println(length(symbols));
    }

    public static long length(int[] symbols) {
        long goodLength = 0;

        for (int i = 1; i < symbols.length; i++) {
            goodLength += Math.min(symbols[i-1], symbols[i]);
        }

        return goodLength;
    }
}
