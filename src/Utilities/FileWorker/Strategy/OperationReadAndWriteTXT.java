package Utilities.FileWorker.Strategy;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class OperationReadAndWriteTXT implements Strategy{

    private File file;

    @Override
    public File doOperation(String fileName, boolean isRead) {
        String result = "";
        if (isRead) {
            StringBuilder text = new StringBuilder();
            try {
                FileReader reader = new FileReader(fileName);
                int c;
                while ((c = reader.read()) != -1) {
                    text.append((char) c);
                }
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
            // Result string
            result = text.toString();
        }
        return file;
    }
}
