package family_tree.view.commands;

import family_tree.view.Console;

public class DownlandProject extends Command{

    public DownlandProject(Console console) {
        super(console);
        description = "Открыть проект";
    }

    @Override
    public void execute() {
        console.downlandProject();
    }
}
