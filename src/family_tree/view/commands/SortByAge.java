package family_tree.view.commands;

import family_tree.view.Console;

public class SortByAge extends Command{
    public SortByAge(Console console) {
        super(console);
        description = "Отсортировать всех людей в семеном древе по возрасту";
    }

    @Override
    public void execute() {
        console.sortByAge();
    }
}
