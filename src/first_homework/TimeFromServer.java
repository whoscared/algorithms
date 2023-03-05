package first_homework;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TimeFromServer {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("D:\\reborn\\algorithms\\Yandex-Algorithms\\src\\homework\\input.txt");
        BufferedReader br = new BufferedReader(fr);
        Time firstTime = new Time(br.readLine());
        Time secondTime = new Time(br.readLine());
        Time thirdTime = new Time(br.readLine());


        System.out.println(Integer.parseInt("01"));

        fr.close();

        FileWriter fw = new FileWriter("D:\\reborn\\algorithms\\Yandex-Algorithms\\src\\homework\\output.txt");
        fw.write(getCurrentTime(firstTime, secondTime, thirdTime));
        fw.close();

    }

    public static String getCurrentTime(Time a, Time b, Time c) {
        Time between = Time.minus(a, c);

        int delayHours = between.getHours() / 2;
        int delayMinutes = between.getMinutes() / 2;
        int delaySeconds = (between.getSeconds() % 2 == 1 ? 1 : 0) + between.getSeconds() / 2;

        if (between.getHours() % 2 == 1) {
            delayMinutes += 30;
        }
        if (between.getMinutes() % 2 == 1) {
            delaySeconds += 30;
        }
        if (delaySeconds >= 60) {
            delayMinutes += 1;
            delaySeconds -= 60;
        }
        if (delayMinutes >= 60) {
            delayHours += 1;
            delayMinutes -= 60;
        }

        Time delay = new Time(delayHours, delayMinutes, delaySeconds);

        return Time.plus(delay, b).toString();
    }

    public static class Time {
        int hours;
        int minutes;
        int seconds;

        Time(int hours, int minutes, int seconds) {
            this.hours = hours;
            this.minutes = minutes;
            this.seconds = seconds;
        }

        Time(String time) {
            if (time.charAt(0) == '0') {
                hours = Integer.parseInt(time.substring(1, 2));
            }
            hours = Integer.parseInt(time.substring(0, 2));

            if (time.charAt(3) == '0') {
                minutes = Integer.parseInt(time.substring(4, 5));
            }
            minutes = Integer.parseInt(time.substring(3, 5));

            if (time.charAt(6) == '0') {
                seconds = Integer.parseInt(time.substring(7, 8));
            }
            seconds = Integer.parseInt(time.substring(6, 8));
        }

        public int getHours() {
            return hours;
        }

        public int getMinutes() {
            return minutes;
        }

        public int getSeconds() {
            return seconds;
        }

        public void setHours(int hours) {
            this.hours = hours;
        }

        public void setMinutes(int minutes) {
            this.minutes = minutes;
        }

        public void setSeconds(int seconds) {
            this.seconds = seconds;
        }

        static Time minus(Time before, Time after) {
            Time result = new Time(0, 0, 0);
            if (after.getHours() < before.getHours()) {
                int helpValue = after.getMinutes() > before.getMinutes() || after.getSeconds() > before.getSeconds() ? 23 : 24;
                result.setHours((helpValue - before.getHours()) + after.getHours());
            } else {
                int helpValue = after.getMinutes() < before.getMinutes() ? 1 : 0;
                result.setHours(after.getHours() - before.getHours() - helpValue);
            }

            if (after.getSeconds() >= before.getSeconds()) {
                result.setSeconds(after.getSeconds() - before.getSeconds());
            } else {
                int seconds = (60 - before.getSeconds()) + after.getSeconds();
                if (seconds >= 60) {
                    result.setMinutes(result.getMinutes() + seconds / 60);
                    seconds -= (seconds / 60) * 60;
                }
                result.setSeconds(seconds);
            }

            if (after.getMinutes() >= before.getMinutes()) {
                int helpValue = after.getSeconds() < before.getSeconds() ? 1 : 0;
                result.setMinutes(after.getMinutes() - before.getMinutes() - helpValue);
            } else {
                int minutes = (60 - before.getMinutes()) + after.getMinutes();
                if (minutes >= 60) {
                    result.setHours(result.getHours() + minutes / 60);
                    minutes -= (minutes / 60) * 60;
                }
                result.setMinutes(minutes);
            }


            return result;
        }

        static Time plus(Time first, Time second) {
            Time result = new Time(0, 0, 0);
            int hours = first.getHours() + second.getHours();
            int minutes = first.getMinutes() + second.getMinutes();
            int seconds = first.getSeconds() + second.getSeconds();
            if (seconds >= 60) {
                minutes += seconds / 60;
                seconds -= (seconds / 60) * 60;
            }
            result.setSeconds(seconds);
            if (minutes >= 60) {
                hours += minutes / 60;
                minutes -= (minutes / 60) * 60;
            }
            result.setMinutes(minutes);
            if (hours > 23) {
                hours -= 24;
            }
            result.setHours(hours);
            return result;
        }

        @Override
        public String toString() {
            return String.valueOf(hours < 10 ? 0 : "") + hours +
                    ":" +
                    (minutes < 10 ? 0 : "") + minutes +
                    ":" +
                    (seconds < 10 ? 0 : "") + seconds;
        }
    }
}
