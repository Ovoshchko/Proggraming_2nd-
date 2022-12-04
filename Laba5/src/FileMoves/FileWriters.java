package FileMoves;

import Roads.Route;
import com.google.gson.Gson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayDeque;

public class FileWriters {
    static String filename;

    public FileWriters() {
    }

    public static void setFilename(String filename) {
        FileWriters.filename = filename;
    }

    public static void writeToFile(ArrayDeque<Route> Routes) throws FileNotFoundException {
        Gson gson = new Gson();

        try {
            File file = new File(filename);
            FileWriter filewriter = new FileWriter(file);
            filewriter.write(gson.toJson(Routes));
            filewriter.close();
            System.out.println("Коллекция записана в файл.");
        } catch (Exception var4) {
            var4.printStackTrace();
        }

    }
}
