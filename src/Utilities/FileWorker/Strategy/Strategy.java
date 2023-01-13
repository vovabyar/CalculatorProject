package Utilities.FileWorker.Strategy;

import java.io.File;

public interface Strategy {
    public File doOperation(String fileName, boolean isRead);

}
