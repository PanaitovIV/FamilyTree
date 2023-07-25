package family_tree.model.human.get_info;

import family_tree.model.human.Human;

public class HumanGender extends InfoElements{

    public HumanGender(Human human) {
        super(human);
        description = "Пол: ";
    }

    @Override
    public String getValue() {
        if (human.getGender() == null) return null;
        else return human.getGender().toString();
    }
}
