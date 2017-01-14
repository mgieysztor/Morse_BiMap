package pl.sda.Threading;

import java.io.IOException;

/**
 * Created by RENT on 2017-01-14.
 */
public class Threading2a {
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(20);
                    } catch (InterruptedException e) {
                        break;
                    }

                    for (int i = 0; i < 4; i++) {
                        for (int j = 0; j < 1; j++) {
                            System.out.println("");
                        }
                        try {
                            Thread.sleep(150);
                        } catch (InterruptedException e) {
                            break;
                        }
                        switch (i) {
                            case 0:
                                System.out.print("-");
                                break;
                            case 1:
                                System.out.print("\\");
                                break;
                            case 2:
                                System.out.print("|");
                                break;
                            case 3:
                                System.out.print("/");
                                break;
                            default:
                                System.out.print("");
                                break;

                        }

                    }
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
    public static void lines(){
        for (int i = 0; i < 50; i++) {
            System.out.println("");
        }
    }
}
