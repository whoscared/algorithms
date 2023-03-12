package whoscared.yandex.stack_homework;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Train {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("D:\\reborn\\algorithms\\Yandex-Algorithms\\src\\whoscared.yandex.stack_homework\\input.txt");
        BufferedReader br = new BufferedReader(fr);
        int count = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] carriages = new int[count];
        for (int i = 0; i < count; i++){
            carriages[i] = Integer.parseInt(st.nextToken());
        }
        fr.close();

        boolean result = sortCarriages(carriages);

        FileWriter fw = new FileWriter("D:\\reborn\\algorithms\\Yandex-Algorithms\\src\\whoscared.yandex.stack_homework\\output.txt");
        fw.write(result ? "YES" : "NO");
        fw.close();
    }

    public static boolean sortCarriages (int[] carriages){
        Stack<Integer> deadEnd = new Stack<>();
        int[] sortCarriages = Arrays.stream(carriages).sorted().toArray();
        int indexMin = 0;
        int indexCur = 0;
        while (indexCur < carriages.length){
            if (carriages[indexCur] != sortCarriages[indexMin]){
                deadEnd.push(carriages[indexCur]);
                indexCur++;
            }
            else {
                indexCur++;
                indexMin++;
                while (!deadEnd.empty() && deadEnd.peek() == sortCarriages[indexMin]){
                    deadEnd.pop();
                    indexMin++;
                }
            }
        }
        return deadEnd.empty();
    }

}
