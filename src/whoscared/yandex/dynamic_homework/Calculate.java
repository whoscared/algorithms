package whoscared.yandex.dynamic_homework;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Calculate {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("D:\\reborn\\algorithms\\Yandex-Algorithms\\src\\whoscared.yandex.input_output\\input.txt");
        BufferedReader br = new BufferedReader(fr);

        int n = Integer.parseInt(br.readLine());
        fr.close();

        int[] result = result(n);


        FileWriter fw = new FileWriter("D:\\reborn\\algorithms\\Yandex-Algorithms\\src\\whoscared.yandex.input_output\\output.txt");
        fw.write(result.length - 1 + "\n");
        for (int cur : result) {
            fw.write(cur + " ");
        }
        fw.close();
    }

    public static int[] result(int n) {
        //steps[n] = количество шагов для достижения числа n
        int[] steps = new int[Math.max(n + 1, 4)];

        //index[n] = предыдущее число = его индекс в массиве steps
        int[] index = new int[Math.max(n + 1, 4)];

        for (int i = 2; i <= n; i++) {
            int stepOne = steps[i - 1];
            int stepTwo = i % 2 == 0 ? steps[i / 2] : stepOne + 1;
            int stepThree = i % 3 == 0 ? steps[i / 3] : stepOne + 1;
            //stepOne + 1 Почему можно присвоить это значение
            //Если деление без остатка невозможно оба числа будут больше stepOne и выберется stepOne
            //Если возможно деление на оба числа, мы не придем к присваиванию stepOne + 1
            //Если возможно одно из делений (stepTwo или stepThree) оно будет либо меньше stepOne, либо больше
            //Если меньше, то оно в любом случае будет меньше stepTwo < stepOne < stepOne + 1
            //Если больше, то точно выберем stepOne
            if (stepOne < stepTwo && stepOne < stepThree){
                index[i] = i - 1;
            }
            else if (stepTwo < stepThree){
                index[i] = i / 2;
            }
            else {
                index[i] = i / 3;
            }
            steps[i] = steps[index[i]] + 1;
        }
        //Размер = кол-во шагов до конечного числа + 1
        int[] result = new int[steps[n] + 1];
        //Последнее число массива = число, к-ое требуется получить
        int prev = n;
        //Кол-во операций = кол-во шагов
        for (int i = steps[n]; i >= 0; i--) {
            result[i] = prev;
            prev = index[prev];
        }
        return result;
    }
}
