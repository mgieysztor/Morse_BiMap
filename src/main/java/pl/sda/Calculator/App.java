package pl.sda.Calculator;

import java.util.Scanner;

/**
 * Created by RENT on 2017-01-14.
 */
public class App {
    private Calculation calculation;

    public static void main(String[] args) {
        System.out.println("Podaj liczby");
        double inputA = new Scanner(System.in).nextDouble();
        double inputB= new Scanner(System.in).nextDouble();


        System.out.println("Podaj działanie: 1-dodawanie, 2-odejmowanie, 3-mnożenie, 4-dzielenie");
        int keyPressed = new Scanner(System.in).nextInt();
        switch (keyPressed){
            case 1:
                Calculation calculation = new Addition();



        }

    }


}
