package Commands;

import Roads.Route;
import Roads.RouteCollection;

import java.util.Iterator;

public class Show implements NoArgs{
    public Show() {
    }

    public String execute(Object o) {
        RouteCollection collection = new RouteCollection();
        if (collection.Size() == 0) {
            return "Коллекция пустая.";
        } else {
            String result = "---------------------------\n";

            Route route;
            for(Iterator var4 = RouteCollection.getCollection().iterator(); var4.hasNext(); result = result + route.getInfo() + "\n---------------------------\n") {
                route = (Route)var4.next();
            }

            return result;
        }
    }

    public String getName() {
        return "Show";
    }
}
