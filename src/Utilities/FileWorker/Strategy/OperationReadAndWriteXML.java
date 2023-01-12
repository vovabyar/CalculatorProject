package Utilities.FileWorker.Strategy;

public class OperationReadAndWriteXML implements Strategy{
    @Override
    public String doOperation(String fileName) {
        return fileName;
    }
}
