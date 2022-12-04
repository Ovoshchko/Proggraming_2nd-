package Commands;

import Roads.Route;
import Roads.RouteCollection;

import java.util.Iterator;

public class remove_greater implements Commandable{
    public remove_greater(){}

    public String execute(Object o){
        try{
            int idd = Integer.parseInt((String)o);
            RouteCollection rt = new RouteCollection();
            Iterator it = RouteCollection.getCollection().iterator();
            while(it.hasNext()){
                Route Routetodelete = (Route)it.next();
                if(Routetodelete.getId()>idd) RouteCollection.getCollection().remove(Routetodelete);
            }
            System.out.println("Элементы успешно удалены.");
        }catch(NullPointerException v){
            System.out.println("Нет элементов в коллекции.");
        }catch(Exception v){
            System.out.println("Что-то пошло не так, попробуйте ещё раз.");
        }
        return "";
    }

    public String getName(){return "Remove_greater";}
}
