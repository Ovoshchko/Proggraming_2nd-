package Commands;

public class Exit implements NoArgs{
    public Exit() {
    }

    public String execute(Object o)  {
        System.out.println("Завершение работы.");
        System.exit(0);
        return null;
    }

    public String getName() {
        return "Exit";
    }
}
