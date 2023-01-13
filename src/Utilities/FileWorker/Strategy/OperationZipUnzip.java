package Utilities.FileWorker.Strategy;

import Utilities.ZipUtilities;

import java.io.File;
import java.io.IOException;

public class OperationZipUnzip implements Strategy{    private File file;

    @Override
    public File doOperation(String fileName, boolean unzip) {
        try {
            String newFileName = ZipUtilities.getInstance().unzip(fileName);
            file = new File(newFileName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return file;
    }
}
