package pl.sda.CalculatorPublic;

import java.util.Scanner;

/**
 * Created by RENT on 2017-01-14.
 */
public class Calculator {
    public static void main(String[] args) {
        Scanner scannerIn = new Scanner(System.in);

        System.out.println("Podaj liczbę");
        Integer x = scannerIn.nextInt();
        System.out.println("Podaj liczbę");
        Integer y = scannerIn.nextInt();
        System.out.println("Podaj znak");
        String operationChar = new Scanner(System.in).nextLine();

        Operation operationToPerform = null;
        switch (operationChar) {
            case "+":
                operationToPerform = new Add();
                break;
            case "-":
                operationToPerform = new Substract();
                break;
            default:
                throw new IllegalArgumentException("Zły kod działania");
        }


        double result = operationToPerform.eval(x, y);
        System.out.println("Wynik działania: " + result);

    }
}
