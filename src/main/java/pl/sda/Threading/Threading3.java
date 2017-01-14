package pl.sda.Threading;

/**
 * Created by RENT on 2017-01-14.
 */
public class Threading3 {
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                sum(10_000_000_000l);
            }
        };

        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);


        long start = System.nanoTime();
        thread1.start();
        thread2.start();
        //synchronizacja wątków
        thread1.join(); //główny wątek będzie czekał na skończenie thread1
        thread2.join();
        long stop = System.nanoTime();
        double duration = (stop - start) / 1_000_000_000d;
        System.out.println("Duration: " + duration);

    }

    public static long sum(long x) {
        long sum = 0;
        for (long i = 1; i <= x; i++) {
            sum += i;
        }
        return sum;
    }
}
