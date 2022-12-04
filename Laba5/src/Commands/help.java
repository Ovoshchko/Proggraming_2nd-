package Commands;

public class help implements NoArgs{
    public help(){}
    public String execute(Object o){
        return "Список доступных команд: Help : вывести справку по доступным командам\nInfo : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)\nShow : вывести в стандартный поток вывода все элементы коллекции в строковом представлении\nAdd {element} : добавить новый элемент в коллекцию\nUpdate id {element} : обновить значение элемента коллекции, id которого равен заданному\nRemove id : удалить элемент из коллекции по его id\nClear : очистить коллекцию\nSave : сохранить коллекцию в файл\nExecute file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.\nExit : завершить программу (без сохранения в файл)\nExecute_first : удалить первый элемент из коллекции\nRemove_greater {element} : удалить из коллекции все элементы, превышающие заданный\nhistory : вывести последние 9 команд (без их аргументов)\nAverage_of_distance : вывести среднее значение поля distance для всех элементов коллекции\nMax_by_from : вывести любой объект из коллекции, значение поля from которого является максимальным\ncountdist distance : вывести количество элементов, значение поля distance которых больше заданного";
    }
    public String getName(){
        return "Help";
    }
}
