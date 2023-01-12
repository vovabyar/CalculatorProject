package Utilities.FileWorker;

import Utilities.FileWorker.Strategy.Context;
import Utilities.FileWorker.Strategy.OperationReadAndWriteJSON;
import Utilities.FileWorker.Strategy.OperationReadAndWriteTXT;
import Utilities.FileWorker.Strategy.OperationReadAndWriteXML;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

interface IData{
    String read(String filename);
    void write(String filename, String text);
}

public class ReaderAndWriter implements IData {
    @Override
    public String read(String filename) {
        List<String> items = Arrays.asList(filename.split("\\."));
        String fileExtension = items.get(1);
        String result = "";
        switch (fileExtension) {
            case "txt":
                Context contextTxt = new Context(new OperationReadAndWriteTXT());
                result = contextTxt.executeStrategy(filename);
                break;
            case "json":
                Context contextJson = new Context(new OperationReadAndWriteJSON());
                result = contextJson.executeStrategy(filename);
                break;
            case "xml":
                Context contextXML = new Context(new OperationReadAndWriteXML());
                result = contextXML.executeStrategy(filename);
                break;
        }
        return result;
    }
    @Override
    public void write(String filename, String text) {
        try
        {
            FileWriter writer = new FileWriter(filename, false);
            writer.write(text);
            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}