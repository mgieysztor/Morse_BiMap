package pl.sda.Threading;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by RENT on 2017-01-14.
 */
public class Threading5_primary {
    public static void main(String[] args) {
        int numberExamined;
        numberExamined = 500;
        List<Integer> primaryList = new ArrayList<>();


        for (int i = 2; i < numberExamined / 2; i++) {
            {

            }


        }
    }

    public boolean isPrimary(int x) {
        boolean isPrimaryTest = true;
        for (int i = 2; i < x; i++) {
            if (x % i != 0) {
                isPrimaryTest = true;
            } else {
                isPrimaryTest = false;
            }
        }
        return isPrimaryTest;

    }

}
