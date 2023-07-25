package family_tree.model.human.get_info;

import family_tree.model.human.Human;

public class HumanID extends InfoElements {
    public HumanID(Human human) {
        super(human);
        description = "ID: ";
    }
    @Override
    public String getValue() {
        return Integer.toString(human.getId());
    }

}
