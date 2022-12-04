package Commands;

import Roads.RouteCollection;

public class Info implements NoArgs{
    public Info() {
    }
    public String execute(Object o) {
        RouteCollection routec = new RouteCollection();
        return routec.getInfo();
    }

    public String getName() {
        return "Info";
    }
}
