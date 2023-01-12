package Utilities.FileWorker.Strategy;

import java.io.FileReader;
import java.io.IOException;

public class OperationReadAndWriteTXT implements Strategy{
    @Override
    public String doOperation(String fileName) {
        StringBuilder text = new StringBuilder();
        try  {
            FileReader reader = new FileReader(fileName);
            int c;
            while ((c = reader.read()) != -1) {
                text.append((char) c);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        // Result string
        String result = text.toString();
        return result;
    }
}
