package family_tree.model.human.comparators;

import family_tree.model.tree.FamilyItem;

import java.util.Comparator;

public class HumanComparatorByID<E extends FamilyItem<E>> implements Comparator<E> {
    @Override
    public int compare(E o1, E o2) {
        return Integer.compare(o1.getId(), o2.getId());
    }
}
