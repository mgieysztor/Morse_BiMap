package pl.sda.Threading;

/**
 * Created by RENT on 2017-01-14.
 */
public class MyThread implements Runnable {
    @Override
    public void run() {
        //ta metoda będzie uruchomiona w nowym watku

        for (int i = 0; i < 100000; i++) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i);
        }
    }
}
