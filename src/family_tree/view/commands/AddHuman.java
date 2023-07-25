package family_tree.view.commands;

import family_tree.view.Console;

public class AddHuman extends Command {
    public AddHuman(Console console) {
        super(console);
        description = "Добавить человека в семейное древо";
    }
    public void execute(){
        console.addHuman();
    }

}
