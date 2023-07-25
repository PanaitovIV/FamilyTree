package family_tree.view.add_human;

import family_tree.view.Console;

public class Death extends DateBirthOrDeath{
    public Death(Console console, Container container) {
        super(console, container);
        description = "Дата смерти";
    }

    @Override
    public void execute() {
        super.execute();
        container.setDeath(value);
    }

}
