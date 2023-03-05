package stack_homework;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Stack;

public class ReversePolishNotation {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("D:\\reborn\\algorithms\\Yandex-Algorithms\\src\\stack_homework\\input.txt");
        BufferedReader br = new BufferedReader(fr);
        String reversePolishString = br.readLine();
        fr.close();


        FileWriter fw = new FileWriter("D:\\reborn\\algorithms\\Yandex-Algorithms\\src\\stack_homework\\output.txt");
        fw.write(String.valueOf(getAnswer(reversePolishString.split(" "))));
        fw.close();
    }

    public static int getAnswer(String[] reversePolish) {
        Stack<Integer> numbers = new Stack<>();
        String operand = "*+-";
        for (String current : reversePolish) {
            if (!operand.contains(current)) {
                numbers.push(Integer.parseInt(current));
            } else {
                int second = numbers.pop();
                int first = numbers.pop();
                switch (current) {
                    case "*" -> numbers.push(first * second);
                    case "+" -> numbers.push(first + second);
                    case "-" -> numbers.push(first - second);
                }
            }
        }
        return numbers.pop();
    }
}
