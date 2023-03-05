package first_homework;

import java.io.*;

public class TimeFromServerSeconds {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("D:\\reborn\\algorithms\\Yandex-Algorithms\\src\\homework\\input.txt");
        BufferedReader br = new BufferedReader(fr);
        String firstTime = br.readLine();
        String secondTime = br.readLine();
        String thirdTime = br.readLine();

        fr.close();

        FileWriter fw = new FileWriter("D:\\reborn\\algorithms\\Yandex-Algorithms\\src\\homework\\output.txt");
        fw.write(getTime(firstTime, secondTime, thirdTime));
        fw.close();
    }

    public static String getTime(String sendTime, String serverTime, String answerTime) {
        long sendTimeSeconds = getSeconds(sendTime);
        long serverTimeSeconds = getSeconds(serverTime);
        long answerTimeSeconds = 0;
        if (Integer.parseInt(sendTime.substring(0, 2)) > Integer.parseInt(answerTime.substring(0, 2))) {
            answerTimeSeconds += getSeconds(answerTime) + getSeconds("24:00:00");
        } else {
            answerTimeSeconds += getSeconds(answerTime);
        }

        long betweenSeconds = answerTimeSeconds - sendTimeSeconds;
        betweenSeconds = betweenSeconds % 2 == 1 ? betweenSeconds / 2 + 1 : betweenSeconds / 2;
        long answerSeconds = serverTimeSeconds + betweenSeconds;

        return secondsToString(answerSeconds);
    }

    public static long getSeconds(String time) {
        long seconds = 0;
        long minutes = 0;
        long hours = 0;

        seconds += Integer.parseInt(time.substring(6, 8));
        minutes += Integer.parseInt(time.substring(3, 5));
        hours += Integer.parseInt(time.substring(0, 2));

        minutes += hours * 60;
        seconds += minutes * 60;
        return seconds;
    }

    public static String secondsToString(long seconds) {
        long minutes = seconds / 60;
        seconds -= (seconds / 60) * 60;
        long hours = minutes / 60;
        minutes -= (minutes / 60) * 60;
        if (hours >= 24) {
            hours -= 24;
        }
        return (hours <= 9 ? "0" + hours : hours)
                + ":" +
                (minutes <= 9 ? "0" + minutes : minutes)
                + ":" +
                (seconds <= 9 ? "0" + seconds : seconds);
    }
}
