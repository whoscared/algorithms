package whoscared.yandex.first_homework;

//import java.util.HashSet;

import java.util.Scanner;
//import java.util.Set;

public class BeautString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int swap = Integer.parseInt(scanner.nextLine());
        String s = scanner.nextLine();
        System.out.println(getBeautStringLength(swap, s));
    }

    public static int getBeautStringLength(int swap, String s) {
        if (swap >= s.length() || s.length() == 1) {
            return s.length();
        }

        int currentBeaut = 0;

//        Set<Character> symbolsSet = new HashSet<>();
//        for (int i = 0; i < s.length(); i++) {
//            symbolsSet.add(s.charAt(i));
//        }

        for (int symbol = 97; symbol <= 122; symbol++) {
            //for (char currentSymbol : symbolsSet) {
            char currentSymbol = (char) symbol;
            int counter = swap;
            int rightIndex = 0;
            for (int leftIndex = 0; leftIndex < s.length() && rightIndex < s.length(); leftIndex++) {
//                counter += (leftIndex != rightIndex
//                        && s.charAt(leftIndex - 1) != currentSymbol) ? 1 : 0;
//                for (; counter >= 0 && rightIndex < s.length(); rightIndex++) {
//                    if (s.charAt(rightIndex) != currentSymbol) {
//                        counter--;
//                    }
//                }
                if (leftIndex > rightIndex) {
                    break;
                }
                if (leftIndex != rightIndex && s.charAt(leftIndex - 1) != currentSymbol) {
                    counter++;
                    rightIndex++;
                }
                while (counter >= 0 && rightIndex < s.length()) {
                    if (s.charAt(rightIndex) != currentSymbol) {
                        counter--;
                    }
                    rightIndex += counter != -1 ? 1 : 0;
                }
//                while (counter >= 0 && rightIndex < s.length()) {
//                    if (s.charAt(rightIndex) != currentSymbol) {
//                        rightIndex += (counter > 0 && rightIndex < s.length() - 1) ? 1 : 0;
//                        counter--;
//                    }
//                    else {
//                        rightIndex++;
//                    }
//                    //rightIndex += (counter >= 0 && rightIndex < s.length() - 1) ? 1 : 0;
//                }
                currentBeaut = Math.max(currentBeaut, rightIndex - leftIndex);
            }
        }
        return currentBeaut;
    }
}
