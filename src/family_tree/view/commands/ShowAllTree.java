package family_tree.view.commands;

import family_tree.view.Console;

public class ShowAllTree extends Command{
    public ShowAllTree(Console console) {
        super(console);
        description = "Показать всех людей в семейном древе";
    }

    @Override
    public void execute() {
        console.showAllTree();
    }
}
