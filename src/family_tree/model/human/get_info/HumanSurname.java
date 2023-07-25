package family_tree.model.human.get_info;

import family_tree.model.human.Human;

public class HumanSurname extends InfoElements {
    public HumanSurname(Human human) {
        super(human);
        description = "Фамилия: ";
    }
    @Override
    public String getValue() {
        if(human.getSurname() == null) return null;
        else return human.getSurname();
    }
}
