package Commands;

import Roads.RouteCollection;
import Roads.Route;
import java.util.Iterator;

public class countdist implements Commandable{

    public String execute(Object o){
        try{
            int i = 0;
            int dist = Integer.parseInt((String)o);
            Iterator it = RouteCollection.getCollection().iterator();
            while(it.hasNext()){
                if(((Route)it.next()).getDistance()>dist) i++;
            }
            System.out.println(i);
            return "";
        }catch(NullPointerException v){
            System.out.print("Нет элементов колеекции.");
            return "";
        }
    }

    public String getName(){return "Countdist";}
}
