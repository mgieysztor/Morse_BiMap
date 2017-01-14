package pl.sda.Threading;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by RENT on 2017-01-14.
 */
public class Threading4 {
    public static void main(String[] args) throws InterruptedException {
        List<Integer> integersList = new ArrayList<>();

        Integer x = 1;
        Integer y = 1;
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    synchronized (x) {
                        synchronized (y) {
                            System.out.println();
                        }
                    }
                }


            }
        };
        Runnable runnable2 = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    synchronized (y) {
                        synchronized (x) {

                        }
                    }
                }

            }
        };

        Thread thread1 = new Thread(runnable1);
        Thread thread2  = new Thread(runnable2);
        thread1.start();
        thread2.start();


        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1_000_000; i++) {
                    synchronized (integersList) {
                        integersList.add(i);
                    }
                }
            }
        };
//        Thread thread = new Thread(runnable);
//        thread.start();
//
//        Thread thread2 = new Thread(runnable);
//        thread2.start();
//
//        thread.join();
//        thread2.join();


        System.out.println(integersList.size());
    }
}
