package family_tree.view.add_human;

import family_tree.view.Console;

public class Finish extends HumanData{

    public Finish(Console console, Container container) {
        super(console, container);
        description = "Завершить ввод данных и добавить человека";
    }

    @Override
    public void execute() {
        console.finishAddHuman(container.getName(), container.getSurname(), container.getPatronymic(),
                container.getSex(), container.getBirth(), container.getDeath());
    }
}
