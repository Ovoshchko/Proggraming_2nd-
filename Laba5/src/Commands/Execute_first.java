package Commands;

import Roads.RouteCollection;
public class Execute_first implements NoArgs{
    public Execute_first(){}
    public String execute(Object o){
        try{
            RouteCollection rt = new RouteCollection();
            rt.rF();
            System.out.println("Первый элемент успешно удалён.");
        } catch(NullPointerException v){
            System.out.println("Коллекция и так пуста.");
        }
        return "";
    }

    public String getName(){
        return "Execute_first";
    }
}
