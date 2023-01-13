package Utilities.FileWorker.Strategy;

import java.io.File;

public class OperationReadAndWriteXML implements Strategy{
    private File file;

    @Override
    public File doOperation(String fileName, boolean isRead) {
        return file;
    }
}
