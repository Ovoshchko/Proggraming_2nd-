package Commands;

import Roads.CreateCollect;
import Roads.RouteCollection;

public class Add implements NoArgs{
    public Add() {
    }
    public String execute(Object o) {
        RouteCollection routec = new RouteCollection();
        routec.add((new CreateCollect()).create("free"));
        return "Путь успешно добавлен.";
    }

    public String getName() {
        return "Add";
    }
}
