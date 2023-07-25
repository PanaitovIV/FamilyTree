package family_tree.view.add_human;

import family_tree.view.Console;

public class HumanGender extends HumanData{

    public HumanGender(Console console, Container container) {
        super(console, container);
        description = "Пол";
    }

    @Override
    public void execute() {
        System.out.println("Введите пол(м, ж):");
        String sex = scanner.nextLine();
        if (sex.length() > 1) {
            System.out.println("Введено больше одного символа!");
            execute();
        }
        container.setSex(sex);
    }
}
