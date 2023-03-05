package heap_homework;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class HeapRealization {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("D:\\reborn\\algorithms\\Yandex-Algorithms\\src\\input_output\\input.txt");
        BufferedReader br = new BufferedReader(fr);

        int count = Integer.parseInt(br.readLine());
        String[] commands = new String[count];
        int index = 0;

        while (index < count) {
            StringTokenizer st = new StringTokenizer(br.readLine(), "\n");
            commands[index++] = st.nextToken();
        }

        String result = result(commands);

        FileWriter fw = new FileWriter("D:\\reborn\\algorithms\\Yandex-Algorithms\\src\\input_output\\output.txt");
        fw.write(result);
        fw.close();
    }

    public static String result(String[] commands) {
        MyHeapMax heap = new MyHeapMax();
        StringBuilder result = new StringBuilder();
        for (String command : commands) {
            if (command.charAt(0) == '0') {
                int x = Integer.parseInt(command.substring(2));
                heap.insert(x);
            } else {
                int x = heap.extract();
                result.append(x).append("\n");
            }
        }
        return result.toString();
    }
}
