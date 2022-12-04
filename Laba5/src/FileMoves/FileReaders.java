package FileMoves;

import Roads.Coordinates;
import Roads.Route;
import Roads.RouteCollection;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.Iterator;

public class FileReaders{
    public static final String envPath = System.getenv("route");

    public FileReaders(){}

    public static String getEnvPath(){return envPath;}

    public static String readFromFile(String filename) {
        try {
            String data = "";
            File file = new File(filename);

            int i;
            for(BufferedInputStream bufferedReader = new BufferedInputStream(new FileInputStream(file)); (i = bufferedReader.read()) != -1; data = data + (char)i) {
            }

            FileWriters.setFilename(filename);
            return data;
        } catch (NullPointerException | FileNotFoundException r) {
            System.out.println("Вы забыли указать имя файла.");
            return null;
        } catch (IOException b) {
            b.printStackTrace();
            return null;
        }
    }

    public static void fillCollection(String data){
        ArrayDeque<Route> routesall = new ArrayDeque<>();
        new Gson();
        if (data.equals(null)) {
            System.out.println("Указанный файл не найден.Коллекция пустая.");
        } else {
            try {
                Type type = (new TypeToken<ArrayDeque>() {
                }).getType();
                ArrayDeque<LinkedTreeMap> routes = (ArrayDeque) (new Gson()).fromJson(data, type);
                Iterator var5 = routes.iterator();

                while (var5.hasNext()) {
                    LinkedTreeMap params = (LinkedTreeMap) var5.next();
                    Route route = new Route();
                    route.setId(((Double)params.get("id")).intValue());
                    route.setName((String) params.get("name"));
                    LinkedTreeMap cParams = (LinkedTreeMap) params.get("coordinates");
                    Coordinates coordinates = new Coordinates();
                    coordinates.setX(((Double) cParams.get("x")).longValue());
                    coordinates.setY(((Double) cParams.get("y")).doubleValue());
                    route.setCoordinates(coordinates);
                    LinkedTreeMap LocaFrom= (LinkedTreeMap)params.get("from");
                    route.setFrom((String)LocaFrom.get("name"),(((Double)LocaFrom.get("x")).floatValue()),(((Double)LocaFrom.get("y"))).longValue());
                    LinkedTreeMap LocaTo= (LinkedTreeMap)params.get("to");
                    route.setTo((String)LocaTo.get("name"),(((Double)LocaTo.get("x")).floatValue()),(((Double)LocaTo.get("y"))).longValue());
                    /*route.setFrom((Location) params.get("from"));
                    route.setTo((Location) params.get("to"));*/
                    route.setDistance(((Double)params.get("distance")).intValue());
                    routesall.add(route);
                }

                RouteCollection.setCollection(routesall);
                    System.out.println("Коллекция успешно заполнена.");
                } catch(JsonSyntaxException v){
                    System.out.println("Ошибка заполнения.Коллекция пустая");
                } catch(NullPointerException v){
                    System.out.println("В файле указаны некорретные данные. Коллекция пустая.");
                }
            }

        }


}
