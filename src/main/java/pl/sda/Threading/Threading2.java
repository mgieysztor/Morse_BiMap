package pl.sda.Threading;

/**
 * Created by RENT on 2017-01-14.
 */

    public class Threading2 {
        public static void main(String[] args) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            break;
                        }
                        System.out.print(". ");
                    }
                }
            };
            Thread thread = new Thread(runnable);
            thread.start();

            long sum = sum(10_000_000_000l);
            System.out.println("\nSuma: " + sum);

            thread.interrupt();


        }

        public static long sum(long x) {
            long sum = 0;
            for (long i = 1; i <= x; i++) {
                sum += i;
            }
            return sum;
        }
    }

