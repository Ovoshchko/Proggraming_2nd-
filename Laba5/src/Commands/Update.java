package Commands;

import Roads.CreateCollect;
import Roads.RouteCollection;
import Roads.Route;
public class Update implements Commandable{
    public Update() {
    }

    public String execute(Object arg) {
        RouteCollection routec = new RouteCollection();
        try {
            if (routec.busyId(Integer.parseInt((String)arg))) {
                int id = Integer.parseInt((String)arg);
                Route Routetodelete = (Route)RouteCollection.getCollection().stream().filter((x) -> {
                    return x.getId() == id;
                }).findFirst().get();
                routec.add((new CreateCollect()).create((String)arg));
                int ok = Integer.parseInt((String)arg);
                RouteCollection.getCollection().remove(Routetodelete);
                return "Путь [id:" + arg + "] успешно обновлен.";
            } else {
                return "Элемента с таким id не существует.";
            }
        } catch (Exception v) {
            //Uv.printStackTrace();
            return "Элемента с таким id не существует.";
        }
    }

    public String getName() {
        return "Update";
    }
}
