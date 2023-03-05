package AaSHD;

import java.util.Arrays;
import java.util.Scanner;

public class BinaryNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] binary = Arrays.stream(scanner.nextLine().split("")).mapToInt(Integer::parseInt).toArray();
        System.out.println(division15(binary) ? "true" : "false");
    }

    public static boolean division15(int[] binary) {
        int evenSumThree = 0;
        int oddSumThree = 0;
        for (int i = 0; i < binary.length; i++) {
            if (i % 2 == 0) {
                evenSumThree += binary[i];
            } else {
                oddSumThree += binary[i];
            }
        }
        boolean three = Math.abs(evenSumThree - oddSumThree) % 3 == 0;
        if (!three) {
            return false;
        }

        int evenSumFour = 0;
        int oddSumFour = 0;
        boolean even = true;
        for (int i = binary.length - 1; i <= 0; i -= 2){
            int current = binary[i];
            int prev = i > 0 ? binary[i-1] : 0;
            int value = 0;

            if (current == 1 && prev == 0 )
                value = 1;
            else if (current == 0 && prev == 1 )
                value = 2;
            else if (current == 1 && prev == 1 )
                value =3;

            if (even)
                evenSumFour += value;
            else
                oddSumFour += value;

            even = !even;

        }
        boolean five = Math.abs(evenSumFour - oddSumFour) % 5 == 0;
        return five;
    }
}
