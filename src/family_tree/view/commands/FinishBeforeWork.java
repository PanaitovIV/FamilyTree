package family_tree.view.commands;

import family_tree.view.Console;

public class FinishBeforeWork extends Command{
    public FinishBeforeWork(Console console) {
        super(console);
        description = "Завершение работы";
    }

    @Override
    public void execute() {
        console.finishBeforeWork();
    }
}
