package Commands;

import Roads.RouteCollection;
import Roads.Route;
import java.util.Iterator;

public class Remove implements Commandable{
    public Remove() {
    }
    public String execute(Object arg) {
        try {
            RouteCollection routec = new RouteCollection();
            if (routec.Size() == 0) {
                return "Коллекция пустая.";
            }

            boolean isRemoved = false;
            int id = 0;

            try {
                id = Integer.parseInt((String)arg);
            } catch (NumberFormatException var8) {
            }

            Iterator it = RouteCollection.getCollection().iterator();

            while(it.hasNext()) {
                Route route = (Route)it.next();
                int Id = route.getId();
                if (id == Id) {
                    it.remove();
                    isRemoved = true;
                    return "Путь успешно удален.";
                }
            }

            if (!isRemoved) {
                return "Элемента с таким id не существует.";
            }
        } catch (Exception v) {
            //v.printStackTrace();
        }

        return null;
    }

    public String getName() {
        return "Remove";
    }
}
