package Roads;

import java.util.Date;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Iterator;

public class RouteCollection {
    private static ArrayDeque<Route> RouteCollection = new ArrayDeque<Route>();
    private Date NowDate;

    public RouteCollection(){this.NowDate = new Date();}

    public void setNowDate(Date dt){this.NowDate = dt;}

    public Date getNowDate(){return this.NowDate;}

    public static ArrayDeque<Route> getCollection() {
        return RouteCollection;
    }

    public static void setCollection(ArrayDeque<Route> collection) {
        RouteCollection = collection;
    }

    public static void add(Route route){RouteCollection.add(route);}

    public static int Size(){return RouteCollection.size();}

    public static Integer makeId(){
        HashMap<Integer,String> OurId = new HashMap<>();
        Iterator iterator = RouteCollection.iterator();

        while(iterator.hasNext()){
            Route route = (Route)iterator.next();
            OurId.put(route.getId(),"id");
        }

        int id;
        for( id=1; OurId.get(id)!=null;id++){}

        return (Integer)id;
    }

    public boolean busyId(int id){
        int sz = this.Size();
        Iterator iterator = RouteCollection.iterator();

        Route rt;
        do {
            if (!iterator.hasNext()) {
                return false;
            }

            rt = (Route) iterator.next();
        } while(rt.getId() != id);

        return true;
    }

    public void clear(){RouteCollection.clear();}

    public static void rF(){
        RouteCollection.removeFirst();
    }

    public String getInfo() {
        int var10000 = this.Size();
        return "Тип коллекции: ArrayDeque\nРазмер коллекции: " + var10000 + "\nВремя последней инициализации: " + NowDate;
    }
}