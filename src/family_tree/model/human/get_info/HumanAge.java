package family_tree.model.human.get_info;

import family_tree.model.human.Human;

public class HumanAge extends InfoElements{
    public HumanAge(Human human) {
        super(human);
        description = "Возраст: ";
    }
    @Override
    public String getValue() {
        if (human.getAge() == 0) return null;
        else return Integer.toString(human.getAge());
    }
}
