package Commands;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.Scanner;

public class Execute implements Commandable{
    static ArrayDeque<String> eSH = new ArrayDeque<>();

    public Execute() {
    }

    public String execute(Object arg) {
        try {
            eSH.add("execute_script " + (String)arg);
            String result = "";
            File file = new File((String)arg);
            Scanner in = new Scanner(file);
            Commands commands = new Commands();
            String exFileName = "";

            while(in.hasNextLine()) {
                String command = in.nextLine();
                String[] exArg = command.split(" ");
                if (exArg.length == 2) {
                    exFileName = exArg[1];
                }

                if (!command.equals("")) {
                    if (!command.equals("execute_script " + exFileName)) {
                        result = result + "Команда \"" + command + "\":\n";
                        result = result + commands.executeCommand(command);
                        result = result + "\n";
                    } else if (eSH.contains("execute_script " + exFileName)) {
                        result = result + "Команда \"" + command + "\": невыполнима во избежание бесконечной рекурсии .\n\n";
                    } else {
                        eSH.add("execute_script " + exFileName);
                        result = result + "Выполнение вложенного скрипта \"" + command + "\":\n";
                        result = result + commands.executeCommand(command);
                        result = result + "Выполнение вложенного скрипта завершено.\n\n";
                    }
                }
            }

            eSH.clear();
            return result;
        } catch (FileNotFoundException | NullPointerException var9) {
            return "Указанный файл не найден.";
        }
    }

    public String getName() {
        return "Execute";
    }
}
