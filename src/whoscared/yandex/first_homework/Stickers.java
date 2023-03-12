package whoscared.yandex.first_homework;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Stickers {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new FileReader("D:\\reborn\\algorithms\\Yandex-Algorithms\\src\\homework\\10.txt"));
//
//        //Scanner scanner = new Scanner(System.in);
//        //int countStickers = Integer.parseInt(scanner.nextLine());
//        int countStickers = Integer.parseInt(br.readLine());
//        //int[] stickers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
//        int[] stickers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
//        //int countFriends = Integer.parseInt(scanner.nextLine());
//        int countFriends = Integer.parseInt(br.readLine());
//        //int[] friendsStickers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
//        int[] friendsStickers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
//
//        int[] result = wantSticker(countStickers, stickers, countFriends, friendsStickers);
//        for (int curr : result) {
//            System.out.println(curr);
//        }
//
//    }
public static void main(String[] args) throws IOException {
    FileReader fr = new FileReader("D:\\reborn\\algorithms\\Yandex-Algorithms\\src\\homework\\10.txt");
    BufferedReader br = new BufferedReader(fr);

    int countStickers = Integer.parseInt(br.readLine());
    StringTokenizer tokenizer1 = new StringTokenizer(br.readLine(), " ");
    int[] stickers = new int[countStickers];
    for (int i = 0; i < countStickers; i++) {
        stickers[i] = Integer.parseInt(tokenizer1.nextToken());
    }

    int countFriends = Integer.parseInt(br.readLine());
    StringTokenizer tokenizer2 = new StringTokenizer(br.readLine(), " ");
    int[] friendsStickers = new int[countFriends];
    for (int i = 0; i < countFriends; i++) {
        friendsStickers[i] = Integer.parseInt(tokenizer2.nextToken());
    }

    fr.close();

    FileWriter fw = new FileWriter("D:\\reborn\\algorithms\\Yandex-Algorithms\\src\\homework\\output.txt");


    int[] result = wantSticker(countStickers, stickers, countFriends, friendsStickers);
    StringBuilder res = new StringBuilder();
    for (int curr : result) {
        res.append(curr).append("\n");
    }
    fw.write(res.toString());
    fw.close();

}

    public static int[] wantSticker(int countStickers, int[] stickers, int countFriends, int[] friendsStickers) {

        stickers = Arrays.stream(stickers).distinct().toArray();
        Arrays.sort(stickers);
        int[] result = new int[countFriends];

        for (int i = 0; i < countFriends; i++) {
            if (friendsStickers[i] == 0) {
                result[i] = 0;
            }
            if (friendsStickers[i] > stickers[stickers.length - 1]) {
                result[i] = stickers.length;
            } else {
                int count = binarySearch(stickers, friendsStickers[i], 0, stickers.length - 1);
                result[i] = count == -1 ? 0 : count;
            }
        }

//        int[] values = new int[stickers[stickers.length - 1] + 1];
//        int index_stickers = 0;
//        int count = 0;
//        for (int i = 0; i < values.length; i++) {
//            values[i] = count;
//            if (stickers[index_stickers] == i) {
//                count++;
//                index_stickers++;
//            }
//        }
//        int[] result = new int[countFriends];
//        for (int i = 0; i < countFriends; i++) {
//            result[i] = friendsStickers[i] > values.length - 1 ? result[i] = count : values[friendsStickers[i]];
//        }

        return result;
    }

    public static int binarySearch(int[] array, int value, int left, int right) {
        if (left == right) {
            return left;
        }

        int middle = left + ((right - left) / 2);
        if (array[middle] == value) {
            return middle;
        }
        if (array[middle] > value) {
            return binarySearch(array, value, left, middle);
        } else {
            return binarySearch(array, value, middle + 1, right);
        }
    }

    //бинарный поиск без рекурсии => меньше память, рекурсия дорого по памяти!!!!
    //так как она сохраняет все локальные переменные и указатели (куда вернуться)
    public static int binarySearch(int[] array, int value) {
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int midEL = array[mid];

            if (midEL == value) {
                return mid;
            }

            if (midEL > value) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
