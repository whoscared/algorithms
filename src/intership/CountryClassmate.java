package intership;

import java.util.Arrays;
import java.util.Scanner;

class Classmate {
    private int profit;
    private int higherEducation;
    private int parents;

    public int getProfit() {
        return profit;
    }

    public int getHigherEducation() {
        return higherEducation;
    }

    public void setHigherEducation(int higherEducation) {
        this.higherEducation = higherEducation;
    }

    public int getParents() {
        return parents;
    }

    public void setParents(int parents) {
        this.parents = parents;
    }

    public void setProfit(int profit) {
        this.profit = profit;
    }


}

class Country {
    private int minProfit;
    private int higherEducation;
    private int kids;


    public int getMinProfit() {
        return minProfit;
    }

    public void setMinProfit(int minProfit) {
        this.minProfit = minProfit;
    }

    public int getHigherEducation() {
        return higherEducation;
    }

    public void setHigherEducation(int higherEducation) {
        this.higherEducation = higherEducation;
    }

    public int getKids() {
        return kids;
    }

    public void setKids(int kids) {
        this.kids = kids;
    }
}

public class CountryClassmate {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countCountry = Integer.parseInt(scanner.nextLine());
        Country[] countries = new Country[countCountry];

        String s_minProfit = scanner.nextLine();
        int[] minProfit = Arrays.stream(s_minProfit.split(" ")).mapToInt(Integer::parseInt).toArray();

        String s_higher = scanner.nextLine();
        int[] higher = Arrays.stream(s_higher.split(" ")).mapToInt(Integer::parseInt).toArray();

        String s_kids = scanner.nextLine();
        int[] kids = Arrays.stream(s_kids.split(" ")).mapToInt(Integer::parseInt).toArray();


        for (int i = 0; i < countCountry; i++) {
            countries[i] = new Country();
            countries[i].setMinProfit(minProfit[i]);
            countries[i].setHigherEducation(higher[i]);
            countries[i].setKids(kids[i]);
        }

        int countClassmate = Integer.parseInt(scanner.nextLine());
        Classmate[] classmates = new Classmate[countClassmate];

        String s_profit = scanner.nextLine();
        int[] profit = Arrays.stream(s_profit.split(" ")).mapToInt(Integer::parseInt).toArray();

        String s_hight = scanner.nextLine();
        int[] hight = Arrays.stream(s_hight.split(" ")).mapToInt(Integer::parseInt).toArray();

        String s_parents = scanner.nextLine();
        int[] parents = Arrays.stream(s_parents.split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < countClassmate; i++) {
            classmates[i] = new Classmate();
            classmates[i].setProfit(profit[i]);
            classmates[i].setHigherEducation(hight[i]);
            classmates[i].setParents(parents[i]);
        }


        System.out.println(chooseCountry(countCountry, countries, countClassmate, classmates));
    }

    public static String chooseCountry(int countCountry, Country[] countries,
                                       int countClassmate, Classmate[] classmates) {
        int[] result = new int[countClassmate];
        for (int i = 0; i < countClassmate; i++) {
            Classmate currentClassmate = classmates[i];
            for (int j = 0; j < countCountry; j++) {
                Country current = countries[j];
                if ((current.getMinProfit() <= currentClassmate.getProfit()
                        && (current.getHigherEducation() == 0 || currentClassmate.getHigherEducation() == 1))
                        || (current.getKids() == 1 && currentClassmate.getParents() == j + 1)) {
                    result[i] = j + 1;
                    break;
                }

            }
        }
        return Arrays.toString(result).replace("[", "")
                .replace("]", "")
                .replace(",", "");
    }
}
