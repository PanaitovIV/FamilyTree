package family_tree.view.commands;

import family_tree.view.Console;

public class AddConnection extends Command{
    public AddConnection(Console console) {
        super(console);
        description = "Добавить связь ребенок-родитель для имеющихся в дереве людей";
    }
    @Override
    public void execute() {
        console.addConnection();
    }
}
