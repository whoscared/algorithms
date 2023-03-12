package whoscared.yandex.first_homework;

import java.io.*;
import java.util.*;

public class OperationSystem {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("D:\\reborn\\algorithms\\Yandex-Algorithms\\src\\homework\\input.txt");
        BufferedReader br = new BufferedReader(fr);
        int sector = Integer.parseInt(br.readLine());
        int count = Integer.parseInt(br.readLine());
        Pair[] hdd = new Pair[count];
        //int[][] hdd = new int[count][2];
        for (int i = 0; i < count; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            hdd[i] = new Pair(Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()));
//            hdd[i][0] = Integer.parseInt(st.nextToken());
//            hdd[i][1] = Integer.parseInt(st.nextToken());
        }
        fr.close();

        FileWriter fw = new FileWriter("D:\\reborn\\algorithms\\Yandex-Algorithms\\src\\homework\\output.txt");
        fw.write(String.valueOf(countOS(hdd)));
        fw.close();
    }

//    public static int countOS(int[][] hdd, int sector) {
//        int count = 0;
//        int[][] hddWithOs = new int[hdd.length][2];
//
//        for (int i = 0; i < hdd.length; i++) {
//            int start = hdd[i][0];
//            int end = hdd[i][1];
//            for (int j = 0; j < hddWithOs.length; j++) {
//
//                if (hddWithOs[j][0] <= 0 && hddWithOs[j][1] <= 0) {
//                    hddWithOs[j][0] = start;
//                    hddWithOs[j][1] = end;
//                    count++;
//                    continue;
//                }
//                if (hddWithOs[j][0] <= end && start <= hddWithOs[j][1]) {
//                    hddWithOs[j][0] = start;
//                    hddWithOs[j][1] = end;
//                }
//                }
//            }
//        }

    public static int countOS(Pair[] hdd) {

        if(hdd.length == 0){
            return 0;
        }

        List<Pair> pairList = new ArrayList<>();
        pairList.add(new Pair(hdd[0]));

        for (int i = 1; i < hdd.length; i++) {
            int start = hdd[i].getFirst();
            int end = hdd[i].getSecond();

            List<Pair> deletePair = new ArrayList<>();
            for (Pair current : pairList) {
                if (start <= current.getSecond() && current.getFirst() <= end) {
                    deletePair.add(current);
                }
            }
            for (Pair pair : deletePair){
                pairList.remove(pair);
            }
            pairList.add(new Pair(start, end));
        }

        return pairList.size();
    }

    public static class Pair {
        private final int first;
        private final int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        Pair(Pair newPair) {
            this.first = newPair.getFirst();
            this.second = newPair.getSecond();
        }

        public int getFirst() {
            return first;
        }

        public int getSecond() {
            return second;
        }

        @Override
        public boolean equals(Object obj) {
            Pair pair = (Pair) obj;
            return pair.first == first && pair.second == second;
        }


    }
}
