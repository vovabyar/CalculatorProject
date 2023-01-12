package Utilities.FileWorker.Strategy;

public class Context {
    private Strategy strategy;

    public Context(Strategy strategy){
        this.strategy = strategy;
    }

    public String executeStrategy(String fileName){
        return strategy.doOperation(fileName);
    }
}