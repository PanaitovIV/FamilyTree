package family_tree.model.human.comparators;

import family_tree.model.tree.FamilyItem;

import java.util.Comparator;

public class HumanComparatorByName<T extends FamilyItem> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
