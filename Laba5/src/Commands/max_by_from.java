package Commands;

import Roads.Route;
import Roads.RouteCollection;

import java.util.Iterator;

public class max_by_from implements NoArgs{
    public max_by_from(){

    }
    public String execute(Object o){
        System.out.println(maxfrom().getInfo());
        return "";
    }
    public Route maxfrom(){
        try {
            Route max = new Route();
            Iterator it = RouteCollection.getCollection().iterator();
            while (it.hasNext()) {
                Route rt = (Route)it.next();
                if (max.getFrom(1).getX()<rt.getFrom(1).getX()){
                    max =rt;
                }
            }
            return max;
        }catch(NullPointerException v){
            if (RouteCollection.Size()==1) return RouteCollection.getCollection().getFirst();
            else{
                v.printStackTrace();
                System.out.println("В коллекции нет элементов.");
                return null;
            }
        }
    }

    public String getName(){return "Max_by_from";}
}
