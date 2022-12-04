package Commands;

import Roads.RouteCollection;
import Roads.Route;
import java.util.Iterator;

public class Average_of_distance implements NoArgs{
    public Average_of_distance(){

    }

    public String execute(Object o){
        try {
            int i = 0;
            double sum = 0;
            Iterator it = RouteCollection.getCollection().iterator();
            while (it.hasNext()) {
                Route rt = (Route) it.next();
                sum += rt.getDistance();
                i++;
            }
            System.out.println(sum/i);
            return "";
        }catch(NullPointerException v){
            return "В коллекции нет элементов.";
        }
    }

    public String getName(){return "Average_of_distance";}
}
