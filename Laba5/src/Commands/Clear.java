package Commands;

import Roads.RouteCollection;

public class Clear implements NoArgs{
    public Clear() {
    }

    public String execute(Object o) {
        RouteCollection routc = new RouteCollection();
        if (routc.Size() == 0) {
            return "Коллекция и так пустая.";
        } else {routc.clear();
            return "Коллекция успешно очищена.";
        }
    }

    public String getName() {
        return "Clear";
    }
}
