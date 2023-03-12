package whoscared.yandex.stack_homework;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Stack;

public class BracketSequence {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("D:\\reborn\\algorithms\\Yandex-Algorithms\\src\\whoscared.yandex.stack_homework\\input.txt");
        BufferedReader br = new BufferedReader(fr);
        String bracketSequence = br.readLine();
        fr.close();
        FileWriter fw = new FileWriter("D:\\reborn\\algorithms\\Yandex-Algorithms\\src\\whoscared.yandex.stack_homework\\output.txt");
        fw.write(rightBracketSequence(bracketSequence) ? "yes" : "no");
        fw.close();
    }
    public static boolean rightBracketSequence (String bracketSequence){
        String open = "([{";
        String close = ")]}";
        Stack<Character> brackets = new Stack<>();
        for (int i =0; i< bracketSequence.length(); i++){
            char current = bracketSequence.charAt(i);
            if (open.indexOf(current) != -1){
                brackets.push(current);
                continue;
            }
            if (brackets.empty()){
                return false;
            }
            if (close.indexOf(current) != open.indexOf(brackets.pop())){
                return false;
            }
        }
        return brackets.empty();
    }
}
