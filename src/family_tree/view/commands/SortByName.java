package family_tree.view.commands;

import family_tree.view.Console;

public class SortByName extends Command{
    public SortByName(Console console) {
        super(console);
        description = "Отсортировать всех людей в семеном древе по имени";
    }
    @Override
    public void execute() {
        console.sortByName();
    }
}
