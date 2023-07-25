package family_tree.view.add_human;

import family_tree.view.Console;

public class HumanPatronymic extends HumanData{
    public HumanPatronymic(Console console, Container container) {
        super(console, container);
        description = "Отчество";
    }

    @Override
    public void execute() {
        System.out.println("Введите отчество:");
        String patronymic = scanner.nextLine();
        container.setPatronymic(patronymic);
    }
}
