package Utilities.FileWorker.Strategy;

import java.io.File;

public class Context {
    private Strategy strategy;

    public Context(Strategy strategy){
        this.strategy = strategy;
    }

    public File executeStrategy(String fileName, boolean isRead)  {
        return strategy.doOperation(fileName, isRead);
    }
}