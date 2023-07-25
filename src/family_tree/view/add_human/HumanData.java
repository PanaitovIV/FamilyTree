package family_tree.view.add_human;


import family_tree.view.Console;
import java.util.Scanner;

public abstract class HumanData {
    String description;
    Console console;
    Scanner scanner;
    Container container;
    public HumanData(Console console, Container container) {
        this.console = console;
        this.scanner = new Scanner(System.in);
        this.container = container;
    }
    public String getDescription() {
        return description;
    }
    public abstract void execute();
}
