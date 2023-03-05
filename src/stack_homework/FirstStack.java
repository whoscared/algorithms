package stack_homework;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class FirstStack {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("D:\\reborn\\algorithms\\Yandex-Algorithms\\src\\stack_homework\\input.txt");
        Scanner scanner = new Scanner(fr);
        StringBuilder sb = new StringBuilder();
        while (scanner.hasNext()) {
            sb.append(scanner.nextLine()).append("\n");
        }
        fr.close();
        String[] commands = sb.toString().split("\n");
        String[] result = result(commands);
        FileWriter fw = new FileWriter("D:\\reborn\\algorithms\\Yandex-Algorithms\\src\\stack_homework\\output.txt");
        for (String s : result) {
            fw.write(s == null ? "" : s + "\n");
        }
        fw.close();
    }

    public static String[] result(String[] commands) {
        MyStack stack = new MyStack();
        String[] result = new String[commands.length];
        for (int i = 0; i < commands.length; i++) {
            switch (commands[i]) {
                case "pop" -> {
                    Integer pop = stack.pop();
                    result[i] = pop == null ? "error" : String.valueOf(pop);
                }
                case "back" -> {
                    Integer back = stack.back();
                    result[i] = back == null ? "error" : String.valueOf(back);
                }
                case "size" -> result[i] = String.valueOf(stack.size());
                case "clear" -> {
                    stack.clear();
                    result[i] = "ok";
                }
                case "exit" -> {
                    result[i] = "bye";
                    i = commands.length;
                }
                default -> {
                    int push = Integer.parseInt(commands[i].substring(5));
                    stack.push(push);
                    result[i] = "ok";
                }
            }
        }
        return result;
    }

    public static class MyStack {
        int size = 100;
        int[] elements = new int[size];
        int end;

        MyStack() {
            end = 0;
        }

        void push(int x) {
            elements[end++] = x;
        }

        Integer pop() {
            return end == 0 ? null : elements[end-- - 1];
        }

        Integer back() {
            return end == 0 ? null : elements[end - 1] ;
        }

        int size() {
            return end;
        }

        void clear() {
            end = 0;
        }
    }
}
