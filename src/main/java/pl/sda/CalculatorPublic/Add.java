package pl.sda.CalculatorPublic;

/**
 * Created by RENT on 2017-01-14.
 */
public class Add implements Operation {
    @Override
    public double eval(double x, double y) {
        return x+y;
    }
}
