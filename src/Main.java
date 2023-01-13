import CalculationEngine.Engine.Calculator;
import Utilities.FileEncryption;
import Exceptions.FileEncryptionException;
import Utilities.FileWorker.ReaderAndWriter;
import Utilities.ZipUtilities;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws FileEncryptionException, IOException {
        ReaderAndWriter readWrite = new ReaderAndWriter();
        String text = readWrite.read("test.txt.encrypted.zip.encrypted.encrypted.encrypted");

        Pattern regex = Pattern.compile("[()0-9]*( ){0,}([+-/*]( ){0,}[()0-9]{0,})*");
        Matcher m = regex.matcher(text);
        while (m.find()) {
            String expression = m.group();
            if(expression.equals("") || expression.equals(" ")) {
                continue;
            }
            try {
                text = text.replace(expression, Calculator.calculateExpression(expression));
//                text = new StringBuilder(text).insert(0, " ").toString();
//                text = new StringBuilder(text).insert(text.length(), " ").toString();
            }
            catch(Exception e){
                //System.out.println(e.getMessage());
            }
        }
        readWrite.write("out.txt", text);
        //new FileEncryption("test.txt.encrypted.zip.encrypted.encrypted", "123", FileEncryption.ENCRYPT_MODE).start();
        //ZipUtilities.getInstance().compressFile("test.txt.encrypted", "test.txt.encrypted.zip");
        //ZipUtilities.getInstance().unzip("test.txt.encrypted.zip");
    }
}