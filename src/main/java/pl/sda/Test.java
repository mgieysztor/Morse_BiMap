package pl.sda;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        List<Integer> integers = new ArrayList<>();

        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            Thread.sleep(1);
            for (int j = 0; j <100000 ; j++) {
                Integer integer = new Integer(10);
            }
        }
        Thread.sleep(3000000);
    }
}
