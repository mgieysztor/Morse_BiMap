package pl.sda.Threading;

/**
 * Created by RENT on 2017-01-14.
 */
public class Threading {
    public static void main(String[] args) {
        Runnable runnable = new MyThread();

        //przykład z klasą anonimową
        Runnable runnable2 = new Runnable() {
            @Override
            public void run() {
                for (int i = 100000; i < 110000; i++) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(i);
                }
            }
        };



        //runnable.run(); // to jest błąd - to tylko wywołanie metody, ale nie stworzenie wątku

        Thread thread = new Thread(runnable); //tu kolejna pułapka bo thread też ma metodę run dlatego
        Thread thread2 = new Thread(runnable2);
        System.out.println("Przed wywołaniem");
        thread.start(); // dopiero tu uruchamia metodę w nowym wątku
        thread2.start();
        System.out.println("Po wywołaniu");

    }
}
