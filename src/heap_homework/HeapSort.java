package heap_homework;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class HeapSort {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("D:\\reborn\\algorithms\\Yandex-Algorithms\\src\\input_output\\input.txt");
        BufferedReader br = new BufferedReader(fr);

        int count = Integer.parseInt(br.readLine());
        int[] numbers = new int[count];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int[] result = sort(numbers);

        FileWriter fw = new FileWriter("D:\\reborn\\algorithms\\Yandex-Algorithms\\src\\input_output\\output.txt");
        for (int cur:result){
            fw.write(cur + " ");
        }
        fw.close();
    }

    public static int[] sort (int[] numbers){
        MyHeapMin heap = new MyHeapMin();
        for (int num : numbers){
            heap.insert(num);
        }
        int[] result = new int[numbers.length];
        for (int i = 0; i < result.length; i++){
            result[i] = heap.extract();
        }
        return result;
    }
}
