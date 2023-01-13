package Utilities.FileWorker.Parsing;

import Utilities.FileWorker.FileUtilities;
import Utilities.FileWorker.Parsing.JSON.JSONOperations;
import Utilities.FileWorker.Parsing.TXT.TxtOperations;
import java.io.File;
import java.util.ArrayList;

public class ParseService  {

    private TxtOperations txtParser = new TxtOperations();

    private JSONOperations jsonParser = new JSONOperations();

    private String expressions;
    private ArrayList<String> exampleList;

    public void parseAndWrite(File file) throws Exception {
        String results;
        switch (FileUtilities.getFileExtension(file)) {
            case "txt":
                expressions = txtParser.parse(file);
                break;
            case "json":
                exampleList = jsonParser.parse(file);
                break;
            case "xml":
                //expressions = xmldomParser.parse(array);
                break;
//            case default:
//                throw new IllegalArgumentException("Incorrect file format");
        }

        switch (FileUtilities.getFileExtension(file)) {
            case "txt":
                txtParser.write(expressions, "res_" + file.getName());
                break;
            case "json":
                jsonParser.write(exampleList, "res_" + file.getName());
                break;
//            case "xml":

        }
    }
}
