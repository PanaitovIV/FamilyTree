package family_tree.model.human.get_info;

import family_tree.model.human.Human;

public class HumanPatronymic extends InfoElements{
    public HumanPatronymic(Human human) {
        super(human);
        description = "Отчество: ";
    }
    @Override
    public String getValue() {
        if (human.getPatronymic() == null) return null;
        else return human.getPatronymic();
    }
}
