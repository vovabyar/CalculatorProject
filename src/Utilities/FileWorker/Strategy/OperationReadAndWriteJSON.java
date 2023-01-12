package Utilities.FileWorker.Strategy;

public class OperationReadAndWriteJSON implements Strategy{
    @Override
    public String doOperation(String fileName) {
        return fileName;
    }
}
