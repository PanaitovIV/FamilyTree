package family_tree.view.commands;

import family_tree.view.Console;

public class StartNewProject extends Command{

    public StartNewProject(Console console) {
        super(console);
        description = "Начать новый проект";
    }

    @Override
    public void execute() {
        console.startNewProject();
    }
}
