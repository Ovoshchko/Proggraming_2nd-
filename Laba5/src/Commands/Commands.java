package Commands;

import java.util.Map;
import java.util.TreeMap;
import java.io.IOException;

public class Commands implements Commandable{
    private static Map<String,Commandable> commands = new TreeMap();

    public Commands() {
    }
    public String execute(Object o){
        return null;
    }
    public Commandable getCommand(String commandname) {
        return (Commandable)commands.get(commandname);
    }

    public static void setCommands(Map<String, Commandable> commands) {
        Commands.commands = commands;
    }

    public void regist(Commandable... commands) {
        Commandable[] com = commands;
        int i = commands.length;

        for(int j = 0; j < i; ++j) {
            Commandable command = com[j];
            Commands.commands.put(command.getName(), command);
        }

    }

    public String executeCommand(String commandName) {
        String[] nameAndArgument = commandName.split(" ");
        commandName = commandName.replace(" ", "");
        if (!commandName.equals("")) {
            if (commands.get(nameAndArgument[0]) == null) {
                return "Такой команды не существует, введите \"help\", чтобы ознакомиться со всем перечнем команд.";
            }

            String s;
            try {
                NoArgs var3 = (NoArgs)commands.get(nameAndArgument[0]);

                try {
                    s = nameAndArgument[1];
                    return "Неверный формат команды, введите \"help\", чтобы ознакомиться с форматами команд.";
                } catch (Exception v) {
                    return ((Commandable)commands.get(nameAndArgument[0])).execute((Object)null);
                }
            } catch (Exception v1) {
                try {
                    s = nameAndArgument[2];
                    return "Неверный формат команды, введите \"help\", чтобы ознакомиться с форматами команд.";
                } catch (IndexOutOfBoundsException v2) {
                    try {
                        return ((Commandable)commands.get(nameAndArgument[0])).execute(nameAndArgument[1]);
                    } catch (IndexOutOfBoundsException | IOException var7) {
                        return "Неверный формат команды, введите \"help\", чтобы ознакомиться с форматами команд.";
                    }
                }
            }
        }

        return null;
    }

    public String getName(){return "Commands";}
}
