package family_tree.view.commands;

import family_tree.view.Console;

public class SortByID extends Command{
    public SortByID(Console console) {
        super(console);
        description = "Отсортировать всех людей в семеном древе по id";
    }

    @Override
    public void execute() {
        console.sortByID();
    }
}
