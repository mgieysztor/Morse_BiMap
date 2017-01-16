package pl.sda.Threading;

import com.google.common.base.Charsets;
import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class FileGeneratorMulti {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<String> files = new ArrayList<>();


        Runnable runnable1 = new FileGeneratorRunnable(0, 500);
        Runnable runnable2 = new FileGeneratorRunnable(500, 1000);

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        long start = System.nanoTime();

        executorService.execute(runnable1);
        executorService.execute(runnable2);

        executorService.submit(new Runnable() {
            @Override
            public void run() {

            }
        });

        Future<String> future = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "A";
            }
        });

        String threadResult = future.get();


//        try {
//            thread1.join();
//            thread2.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        long end = System.nanoTime();
        double duration = (end - start) / 1_000_000_000d;

        for (String fileName : files) {
            System.out.println(fileName);
        }


        System.out.println("Rozmiar listy: " + files.size());
        System.out.println("Czas tworzenia plików: " + duration);
    }
}

