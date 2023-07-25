package family_tree.model.human.get_info;

import family_tree.model.human.Human;

public class HumanMother extends InfoElements{
    public HumanMother(Human human) {
        super(human);
        description = "Мать: ";
    }
    @Override
    public String getValue() {
        if (human.getMother() != null) return human.getMother().getName();
        else return null;
    }
}
