package pl.sda.Calculator;

/**
 * Created by RENT on 2017-01-14.
 */
public class Addition implements Calculation {

    @Override
    public double calculate(double a, double b) {
        return a+b;
    }
}
