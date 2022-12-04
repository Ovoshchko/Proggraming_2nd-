import Commands.Commands;
import FileMoves.FileReaders;
import Roads.RouteCollection;
import Commands.*;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        new RouteCollection();
        String history = "";
        FileReaders.fillCollection(FileReaders.readFromFile(FileReaders.getEnvPath()));
        Commands commands = new Commands();
        commands.regist(new Commandable[]{new Show(), new Exit(), new help(), new Info(), new Clear(), new Execute(), new Add(), new Save(), new Update(), new Average_of_distance(), new countdist(), new Execute_first(), new max_by_from(), new remove_greater(), new Remove()});
        Scanner in = new Scanner(System.in);
        System.out.println("Приложение готово к работе,введите команду,для справки введите help.");

        while(true) {
            System.out.print("~ ");
            String commandName = in.nextLine();
            if (!commandName.equals("")&&!commandName.equals("history")) {
                System.out.println(commands.executeCommand(commandName));
                history += commandName+" ";
            }
            else if (commandName.equals("history"))
            {
                System.out.println(history);
            }


            System.out.println("Введите команду:");
        }
    }
}
