package Utilities.FileWorker.Strategy;

import Exceptions.FileEncryptionException;
import Utilities.FileEncryption;

import java.io.File;

public class OperationEncryptDecrypt implements Strategy{

    private File file;

    private FileEncryption fileEncryptionObj;

    @Override
    public File doOperation(String fileName, boolean isEncrypt) {
        if (isEncrypt) {
            try {
                fileEncryptionObj = new FileEncryption(fileName, "123", FileEncryption.DECRYPT_MODE);
                fileEncryptionObj.start();
                file = fileEncryptionObj.getFile();
                return file;

            } catch (FileEncryptionException e) {
                System.out.println("FileEncryption!");
            }
        }

        return null;
    }
}
