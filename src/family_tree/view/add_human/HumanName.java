package family_tree.view.add_human;
import family_tree.view.Console;

public class HumanName extends HumanData{

    public HumanName(Console console, Container container) {
        super(console, container);
        description = "Имя";
    }

    @Override
    public void execute() {
        System.out.println("Введите имя:");
        String name = scanner.nextLine();
        container.setName(name);
    }
}
