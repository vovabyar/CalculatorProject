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
        //readWrite.process("test.txt.encrypted.zip.encrypted.encrypted.encrypted");
        readWrite.process("input.json.encrypted.encrypted.encrypted.zip.encrypted");

       // readWrite.write("out.txt", text);
        //new FileEncryption("input.json.encrypted.encrypted.encrypted.zip.encrypted", "123", FileEncryption.ENCRYPT_MODE).start();
        //ZipUtilities.getInstance().compressFile("input.json.encrypted.encrypted.encrypted", "input.json.encrypted.encrypted.encrypted.zip");
        //ZipUtilities.getInstance().unzip("test.txt.encrypted.zip");
    }
}