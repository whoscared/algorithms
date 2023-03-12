package whoscared.yandex.queue_homework;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class DrunkGame {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("D:\\reborn\\algorithms\\Yandex-Algorithms\\src\\whoscared.yandex.queue_homework\\input.txt");
        BufferedReader br = new BufferedReader(fr);
        String first = br.readLine();
        String second = br.readLine();
        fr.close();

        String result = whoWins(first, second);

        FileWriter fw = new FileWriter("D:\\reborn\\algorithms\\Yandex-Algorithms\\src\\whoscared.yandex.queue_homework\\output.txt");
        fw.write(result);
        fw.close();
    }

    public static String whoWins(String firstDeck, String secondDeck) {
        MyQueue first = new MyQueue();
        MyQueue second = new MyQueue();
        StringTokenizer st = new StringTokenizer(firstDeck, " ");
        for (int i = 0; i < 5; i++) {
            first.push(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(secondDeck, " ");
        for (int i = 0; i < 5; i++) {
            second.push(Integer.parseInt(st.nextToken()));
        }
        int countSteps = 0;
        while (countSteps < 1000000) {
            if (first.size() == 0 || second.size() == 0) {
                break;
            }
            int firstCard = first.pop();
            int secondCard = second.pop();
            if (!(secondCard == 0 && firstCard == 9) &&
                    ((firstCard > secondCard) || (firstCard == 0 && secondCard == 9))) {
                first.push(firstCard);
                first.push(secondCard);
            } else {
                second.push(firstCard);
                second.push(secondCard);
            }
            countSteps++;
        }
        if (first.size() != 0 && second.size() != 0) {
            return "botva";
        }
        return (first.size() == 0 ? "second " : "first ") + countSteps;


    }
}
