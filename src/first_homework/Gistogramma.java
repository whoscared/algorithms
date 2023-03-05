package first_homework;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;


public class Gistogramma {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("D:\\reborn\\algorithms\\Yandex-Algorithms\\src\\homework\\input.txt");
        Scanner scan = new Scanner(fr);
        StringBuilder text = new StringBuilder();
        while (scan.hasNext()){
            text.append(scan.nextLine().replace(" ", ""));
        }
        fr.close();

        FileWriter fw = new FileWriter("D:\\reborn\\algorithms\\Yandex-Algorithms\\src\\homework\\output.txt");
        fw.write(getGistogramma(text.toString()));
        fw.close();
    }

    public static String getGistogramma(String s) {

        HashMap<Character, Integer> countOfSymbols = new HashMap<>();
        int max = 0;

        for (int i = 0; i < s.length(); i++) {
            countOfSymbols.put(s.charAt(i), countOfSymbols.getOrDefault(s.charAt(i), 0) + 1);
            max = Math.max(max, countOfSymbols.get(s.charAt(i)));
        }

        Character[] keySet = countOfSymbols.keySet().toArray(new Character[0]);
        Arrays.sort(keySet);

        StringBuilder result = new StringBuilder();

        for (int i = max; i > 0; i--) {
            for (Character c : keySet) {
                result.append(countOfSymbols.get(c) >= i ? "#" : " ");
            }
            result.append("\n\n");
        }

        for (Character c : keySet) {
            result.append(c);
        }

        return result.toString();
    }
}
