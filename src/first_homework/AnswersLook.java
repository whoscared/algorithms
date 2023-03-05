package first_homework;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class AnswersLook {
    public static void main(String[] args) throws IOException {
        FileReader myAnsw = new FileReader("D:\\reborn\\algorithms\\Yandex-Algorithms\\src\\homework\\output.txt");
        FileReader YandexAnsw = new FileReader("D:\\reborn\\algorithms\\Yandex-Algorithms\\src\\homework\\10-answ.txt");

        BufferedReader myBr = new BufferedReader(myAnsw);
        BufferedReader yanBr = new BufferedReader(YandexAnsw);

        int[] myAnswers = Arrays.stream(myBr.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] yandexAnswers = Arrays.stream(yanBr.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        long max = Math.max(myAnswers.length, yandexAnswers.length);
        for (int i = 0; i < max; i++) {
            if (myAnswers[i] != yandexAnswers[i]) {
                System.out.println(i + ")\nmy: " + myAnswers[i] + "\nyandex: " + yandexAnswers[i]);
            }
        }
    }
}
