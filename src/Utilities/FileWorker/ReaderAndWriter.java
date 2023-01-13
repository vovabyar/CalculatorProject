package Utilities.FileWorker;

import Utilities.FileWorker.Parsing.ParseService;
import Utilities.FileWorker.Strategy.*;
import java.io.File;



public class ReaderAndWriter {

    private File file;

    public void process(String filename) {
        file = new File(filename);

        String result = "";
        while((!FileUtilities.getFileExtension(file).equals("txt")
        && !FileUtilities.getFileExtension(file).equals("json")
        && !FileUtilities.getFileExtension(file).equals("xml"))) {

            switch (FileUtilities.getFileExtension(file)) {
                case "zip":
                    boolean unzip;
                    Context contextZip = new Context(new OperationZipUnzip());
                    file = contextZip.executeStrategy(file.getName(), unzip = true);
                    break;
                case "encrypted":
                    boolean decrypt;
                    Context contextEnc = new Context(new OperationEncryptDecrypt());
                    file = contextEnc.executeStrategy(file.getName(), decrypt = true);
                    break;
            }
        }

        ParseService parse = new ParseService();
        try {
            parse.parseAndWrite(file);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}