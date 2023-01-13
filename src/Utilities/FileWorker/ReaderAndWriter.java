package Utilities.FileWorker;

import Utilities.FileWorker.Strategy.*;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

interface IData{
    String read(String filename);
    String getFileExtension(File file);
    void write(String filename, String text);
}

public class ReaderAndWriter implements IData {

    private File file;

    @Override
    public String getFileExtension(File file) {
        String fileName = file.getName();
        String test = file.getAbsolutePath();
        // если в имени файла есть точка и она не является первым символом в названии файла
        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0) {
            // ХХХХХ.txt -> txt
            test = fileName.substring(fileName.lastIndexOf(".") + 1);
            return test;
        }
            // в противном случае возвращаем заглушку, то есть расширение не найдено
        else return "";
    }
    @Override
    public String read(String filename) {
        file = new File(filename);

        String result = "";
        while(!getFileExtension(file).equals("txt") ) {

            switch (getFileExtension(file)) {
                case "zip":
                    boolean unzip = true;
                    Context contextZip = new Context(new OperationZipUnzip());
                    file = contextZip.executeStrategy(file.getName(), unzip = true);
                    break;
                case "encrypted":
                    boolean decrypt;
                    Context contextEnc = new Context(new OperationEncryptDecrypt());
                    file = contextEnc.executeStrategy(file.getName(), decrypt = true);
                    break;
//            case "txt":
//                Context contextTxt = new Context(new OperationReadAndWriteTXT());
//                file = contextTxt.executeStrategy(filename, isRead);
//                break;
//            case "json":
//                Context contextJson = new Context(new OperationReadAndWriteJSON());
//                file = contextJson.executeStrategy(filename, isRead);
//                break;
//            case "xml":
//                Context contextXML = new Context(new OperationReadAndWriteXML());
//                file = contextXML.executeStrategy(filename, isRead);
//                break;
            }
        }
        StringBuilder text = new StringBuilder();
        try {
            FileReader reader = new FileReader(file.getName());
            int c;
            while ((c = reader.read()) != -1) {
                text.append((char) c);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        // Result string
        result = text.toString();
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