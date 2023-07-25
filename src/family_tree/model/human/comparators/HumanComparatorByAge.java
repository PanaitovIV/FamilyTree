package family_tree.model.human.comparators;

import family_tree.model.tree.FamilyItem;

import java.util.Comparator;

public class HumanComparatorByAge<T extends FamilyItem> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}
