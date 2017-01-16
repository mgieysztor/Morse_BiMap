package pl.sda.Threading;

import com.google.common.base.Charsets;
import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class FilesGeneratorCallable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Future<List<String>> future = executorService.submit(new Callable<List<String>>() {
            @Override
            public List<String> call() throws Exception {

                List<String> stringList = new ArrayList<>();

                for (int i = 0; i < 100; i++) {
                    String filePath = "test/file" + i + ".txt";

                    File file = new File(filePath);
                    try {
                        Files.write("1", file, Charsets.UTF_8);
                        stringList.add(filePath);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                return stringList;
            }
        });

        List<String> strings = future.get();
        for (String string : strings) {
            System.out.println(string);
        }





    }
}