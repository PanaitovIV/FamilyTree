package family_tree.view.commands;

import family_tree.view.Console;

public class NextOfKin extends Command{
    public NextOfKin(Console console) {
        super(console);
        description = "Показать ближайших родственников человека и степень родства";
    }

    @Override
    public void execute() {
        console.nextOfKin();
    }
}
