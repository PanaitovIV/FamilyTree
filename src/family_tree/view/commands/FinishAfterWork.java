package family_tree.view.commands;

import family_tree.view.Console;

public class FinishAfterWork extends Command{
    public FinishAfterWork(Console console){
        super(console);
        description = "Завершить работу";
    }
    @Override
    public void execute() {
        console.finishAfterWork();
    }
}
