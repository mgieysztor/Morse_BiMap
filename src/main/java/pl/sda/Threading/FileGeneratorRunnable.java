package pl.sda.Threading;
import com.google.common.base.Charsets;
import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;

public class FileGeneratorRunnable implements Runnable {
    private int start;
    private int end;

    public FileGeneratorRunnable(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        for (int i = start; i < end; i++) {
            String filePath = "test/file" + i + ".txt";

            File file = new File(filePath);
            try {
                Files.write("1", file, Charsets.UTF_8);
//                files.add(filePath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
