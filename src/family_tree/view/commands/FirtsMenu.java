package family_tree.view.commands;

import family_tree.view.Console;

import java.util.ArrayList;
import java.util.List;

public class FirtsMenu {
    private List<Command> commandList;
    Console consoleUI;
    public FirtsMenu(Console console){
        this.consoleUI = console;
        commandList = new ArrayList<>();
        commandList.add(new StartNewProject(consoleUI)); //Начать новый проект
        commandList.add(new DownlandProject(consoleUI)); //Открыть проект
        commandList.add(new FinishBeforeWork(consoleUI)); //Завершение работы
    }
    public String getMenu(){
        StringBuilder sb = new StringBuilder("Выберите действие:\n");
        for (int i = 0; i < commandList.size(); i++) {
            sb.append(i + 1);
            sb.append(". ");
            sb.append(commandList.get(i).getDescription());
            sb.append("\n");
        }
        return sb.toString();
    }

    public void execute(int choice){
        Command command = commandList.get(choice - 1);
        command.execute();
    }
    public int getSize(){
        return commandList.size();
    }
}
