package whoscared.yandex.deque_homework;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class MyDeque {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("D:\\reborn\\algorithms\\Yandex-Algorithms\\src\\whoscared.yandex.input_output\\input.txt");
        Scanner scanner = new Scanner(fr);
        StringBuilder sb = new StringBuilder();
        while (scanner.hasNext()) {
            sb.append(scanner.nextLine()).append("\n");
        }
        fr.close();
        String[] commands = sb.toString().split("\n");
        String[] result = result(commands);
        FileWriter fw = new FileWriter("D:\\reborn\\algorithms\\Yandex-Algorithms\\src\\whoscared.yandex.input_output\\output.txt");
        for (String s : result) {
            fw.write(s == null ? "" : s + "\n");
        }
        fw.close();
    }

    public static String[] result(String[] commands) {
        Deque<Integer> deque = new ArrayDeque<>();
        String[] result = new String[commands.length];
        for (int i = 0; i < commands.length; i++) {
            if (commands[i].equals("exit")) {
                result[i] = "bye";
                break;
            }
            if (commands[i].contains("push_front")) {
                deque.addFirst(Integer.parseInt(commands[i].substring(11)));
                result[i] = "ok";
                continue;
            }
            if (commands[i].contains("push_back")) {
                deque.addLast(Integer.parseInt(commands[i].substring(10)));
                result[i] = "ok";
                continue;
            }
            switch (commands[i]) {
                case "pop_front" -> {
                    Integer popFront = deque.pollFirst();
                    result[i] = popFront == null ? "error" : String.valueOf(popFront);
                }
                case "pop_back" -> {
                    Integer popBack = deque.pollLast();
                    result[i] = popBack == null ? "error" : String.valueOf(popBack);
                }
                case "front" -> {
                    if (deque.isEmpty()) {
                        result[i] = "error";
                        break;
                    }
                    result[i] = String.valueOf(deque.getFirst());
                }
                case "back" -> {
                    if (deque.isEmpty()) {
                        result[i] = "error";
                        break;
                    }
                    result[i] = String.valueOf(deque.getLast());
                }
                case "size" -> result[i] = String.valueOf(deque.size());
                case "clear" -> {
                    deque.clear();
                    result[i] = "ok";
                }
            }
        }
        return result;
    }
}
