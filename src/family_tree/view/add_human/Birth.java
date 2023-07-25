package family_tree.view.add_human;

import family_tree.view.Console;
//сделать через декоратор
public class Birth extends DateBirthOrDeath{
    public Birth(Console console, Container container) {
        super(console, container);
        description = "Дата рождения";
    }
    @Override
    public void execute() {
        super.execute();
        container.setBirth(value);
    }
}
