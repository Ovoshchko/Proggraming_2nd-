package Commands;

import FileMoves.FileWriters;
import Roads.RouteCollection;

import java.io.IOException;

public class Save implements NoArgs{
    public Save() {
    }
    public String execute(Object o) throws IOException{
        FileWriters.writeToFile(RouteCollection.getCollection());
        return "";
    }

    public String getName() {
        return "Save";
    }
}
