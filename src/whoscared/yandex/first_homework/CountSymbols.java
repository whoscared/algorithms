package whoscared.yandex.first_homework;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


public class CountSymbols {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("D:\\reborn\\algorithms\\Yandex-Algorithms\\src\\homework\\input.txt");
        BufferedReader br = new BufferedReader(fr);

        String st = br.readLine();
        char[] s = st.toCharArray();

        fr.close();

        FileWriter fw = new FileWriter("D:\\reborn\\algorithms\\Yandex-Algorithms\\src\\homework\\output.txt");
        HashMap<Character, Long> result = getCount(s);
        Character[] symbols = result.keySet().toArray(new Character[0]);
        Arrays.sort(symbols);

        for (char cur : symbols){
            fw.write(cur + ": " + result.get(cur) + "\n");
        }

        fw.close();

    }

    public static HashMap<Character, Long> getCount (char[] s){
        HashMap<Character, Long> symbolCount = new HashMap<>();

        for ( int i = 0; i < s.length; i++){
            long count = (long) (i + 1) * (s.length - i);
            symbolCount.put(s[i], symbolCount.getOrDefault(s[i], 0L) + count);
        }
        return symbolCount;
    }
}
