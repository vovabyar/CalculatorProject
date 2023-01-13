package Utilities.FileWorker.Strategy;

import Utilities.FileEncryption;

import java.io.File;

public class OperationReadAndWriteJSON implements Strategy{

    private File file;

    @Override
    public File doOperation(String fileName, boolean isRead) {
        return file;
    }
}
