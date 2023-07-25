package family_tree.model.human.get_info;

import family_tree.model.human.Human;

public class HumanFather extends InfoElements{
    public HumanFather(Human human) {
        super(human);
        description = "Отец: ";
    }
    @Override
    public String getValue() {
        if (human.getFather() != null) return human.getFather().getName();
        else return null;
    }
}
