package family_tree.view.commands;

import family_tree.view.Console;

public class ReturnToFirstMenu extends Command{
    public ReturnToFirstMenu(Console console) {
        super(console);
        description = "Вернуться к стартовому меню";
    }

    @Override
    public void execute() {
        console.returnToFirstMenu();
    }
}
