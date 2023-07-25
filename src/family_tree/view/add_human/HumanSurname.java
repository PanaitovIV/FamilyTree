package family_tree.view.add_human;

import family_tree.view.Console;

public class HumanSurname extends HumanData{

    public HumanSurname(Console console, Container container) {
        super(console, container);
        description = "Фамилия";
    }

    @Override
    public void execute() {
        System.out.println("Введите фамилию:");
        String surname = scanner.nextLine();
        container.setSurname(surname);
    }

}
