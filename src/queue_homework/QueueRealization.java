package queue_homework;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class QueueRealization {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("D:\\reborn\\algorithms\\Yandex-Algorithms\\src\\queue_homework\\input.txt");
        Scanner scanner = new Scanner(fr);
        StringBuilder sb = new StringBuilder();
        while (scanner.hasNext()) {
            sb.append(scanner.nextLine()).append("\n");
        }
        fr.close();
        String[] commands = sb.toString().split("\n");
        String[] result = result(commands);
        FileWriter fw = new FileWriter("D:\\reborn\\algorithms\\Yandex-Algorithms\\src\\queue_homework\\output.txt");
        for (String s : result){
            fw.write(s == null ? "" : s + "\n");
        }
        fw.close();
    }

    public static String[] result (String[] commands){
        MyQueue queue = new MyQueue();
        String[] result = new String[commands.length];
        for (int i = 0; i < commands.length; i++) {
            switch (commands[i]) {
                case "pop" -> {
                    Integer pop = queue.pop();
                    result[i] = pop == null ? "error" : String.valueOf(pop);
                }
                case "front" -> {
                    Integer front = queue.front();
                    result[i] = front == null ? "error" : String.valueOf(front);
                }
                case "size" -> result[i] = String.valueOf(queue.size());
                case "clear" -> {
                    queue.clear();
                    result[i] = "ok";
                }
                case "exit" -> {
                    result[i] = "bye";
                    i = commands.length;
                }
                default -> {
                    int push = Integer.parseInt(commands[i].substring(5));
                    queue.push(push);
                    result[i] = "ok";
                }
            }
        }
        return result;
    }

}
