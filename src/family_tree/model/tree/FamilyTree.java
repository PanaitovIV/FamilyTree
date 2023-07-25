package family_tree.model.tree;

import family_tree.model.human.Gender;
import family_tree.model.human.comparators.HumanComparatorByAge;
import family_tree.model.human.comparators.HumanComparatorByID;
import family_tree.model.human.comparators.HumanComparatorByName;
import family_tree.model.human.get_info.HumanForTreeInfo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<E extends FamilyItem<E>> implements Serializable, Iterable<E>, TreeToService {
    private List<E> tree;
    private int newID;
    public FamilyTree() {
        this.tree = new ArrayList<>();
    }
    public void addToTree(E human) {
        tree.add(human);
        human.setId(newID);
        this.newID++;
    }
    @Override
    public String nextOfKin(FamilyItem human) {
        StringBuilder sb = new StringBuilder();
        getParent(sb, (E)human.getFather());
        getParent(sb, (E) human.getMother());
        getChildren(sb, (E) human);
        if ((human.getMother() == null) && (human.getFather() != null)) {
            getFatherOrMotherChildren(sb, (E) human.getFather(), (E) human);
        } else if ((human.getMother() != null) && (human.getFather() == null)) {
            getFatherOrMotherChildren(sb, (E) human.getMother(), (E) human);
        } else if ((human.getMother() != null) && (human.getFather() != null)) {
            List<E> motherChildren = ((E) human.getMother()).getChildren();
            List<E> fatherChildren = ((E)human.getFather()).getChildren();
            if ((motherChildren.size() == 1) || (fatherChildren.size() == 1)) {
                maternalBrothersAndSisters(sb, motherChildren, (E) human);
                paternalBrothersAndSisters(sb, fatherChildren, (E) human);
            } else {
                getSiblingsAndBloodBrotherAndSister(sb, motherChildren, fatherChildren, (E) human);
            }
        }
        return sb.toString();
    }
    private void getParent(StringBuilder sb, E human) {
        if (human == null) return;
        if (human.getGender() == Gender.Female) sb.append("Мать:\n");
        else sb.append("Отец:\n");
        sb.append(getHumanInfo(human));
        sb.append("\n");
    }
    private void getChildren(StringBuilder sb, E human) {
        List<E> Children = human.getChildren();
        if (Children == null) return;
        else {
            sb.append("Дети:\n");
            for (E el : Children) {
                sb.append(getHumanInfo(el));
                sb.append("\n");
            }
            sb.delete(sb.length() - 2, sb.length());
        }
        sb.append("\n");
    }

    private void getFatherOrMotherChildren(StringBuilder sb, E parent, E humanException) {
        List<E> children = parent.getChildren();
        if (children.size() == 1) return;
        if (checkFemale(children, humanException)) {
            sb.append("Cестры (степень родства определить невозможно):\n");
            getFemale(sb, children, humanException);
        }
        if (checkMale(children, humanException)) {
            sb.append("Братья (степень родства определить невозможно):\n");
            getMale(sb, children, humanException);
        }
    }
    private void maternalBrothersAndSisters(StringBuilder sb, List<E> motherChildren, E humanException) {
        if ((motherChildren.size() > 1)) {
            if (checkFemale(motherChildren, humanException)) {
                sb.append("Кровные сестры по матери:\n");
                getFemale(sb, motherChildren, humanException);
            }
            if (checkMale(motherChildren, humanException)) {
                sb.append("Кровные братья по матери:\n");
                getMale(sb, motherChildren, humanException);
            }
        }
    }
    private void paternalBrothersAndSisters(StringBuilder sb, List<E> fatherChildren, E humanException) {
        if ((fatherChildren.size() > 1)) {
            if (checkFemale(fatherChildren, humanException)) {
                sb.append("Кровные сестры по отцу:\n");
                getFemale(sb, fatherChildren, humanException);
            }
            if (checkMale(fatherChildren, humanException)) {
                sb.append("Кровные братья по отцу:\n");
                getMale(sb, fatherChildren, humanException);
            }
        }
    }
    private void getSiblingsAndBloodBrotherAndSister(StringBuilder sb, List<E> motherChildren, List<E> fatherChildren, E humanException) {
        List<E> common = findCommonChildren(motherChildren, fatherChildren);
        if (checkFemale(common, humanException)) {
            sb.append("Родные сестры:\n");
            getFemale(sb, common, humanException);
        }
        if (checkMale(common, humanException)) {
            sb.append("Родные братья:\n");
            getMale(sb, common, humanException);
        }
        if (motherChildren.toString().equals(fatherChildren.toString())) return;
        List<E> diff = differentChildren(common, fatherChildren);
        if (checkFemale(diff, humanException)) {
            sb.append("Кровные сестры по отцу:\n");
            getFemale(sb, diff, humanException);
        }
        if (checkMale(diff, humanException)) {
            sb.append("Кровные братья по отцу:\n");
            getMale(sb, diff, humanException);
        }
        diff = differentChildren(common, motherChildren);
        if (checkFemale(diff, humanException)) {
            sb.append("Кровные сестры по матери:\n");
            getFemale(sb, diff, humanException);
        }
        if (checkMale(diff, humanException)) {
            sb.append("Кровные братья по матери:\n");
            getMale(sb, diff, humanException);
        }
    }

    private List<E> differentChildren(List<E> commonList, List<E> parentList) {
        List<E> list = new ArrayList<>();
        for (E i : commonList) {
            for (E j : parentList) {
                if (!i.equals(j)) {
                    list.add(i);
                }
            }
        }
        return list;
    }
    private List<E> findCommonChildren(List<E> motherChildren, List<E> fatherChildren) {
        List<E> list = new ArrayList<>();
        for (E i : motherChildren) {
            for (E j : fatherChildren) {
                if (i.equals(j)) {
                    list.add(i);
                }
            }
        }
        return list;
    }
    private boolean checkFemale(List<E> list, E human) {
        if (list == null) return false;
        boolean flag = false;
        for (E el : list) {
            if ((el.getGender() == Gender.Female) && (el != human)) {
                flag = true;
            }
        }
        return flag;
    }
    private boolean checkMale(List<E> list, E human) {
        if (list == null) return false;
        boolean flag = false;
        for (E el : list) {
            if ((el.getGender() == Gender.Male) && (el != human)) {
                flag = true;
            }
        }
        return flag;
    }
    private void getMale(StringBuilder sb, List<E> list, E human) {
        boolean flag = false;
        for (E el : list) {
            if ((el.getGender() == Gender.Male) && (el != human)) {
                sb.append(getHumanInfo(el));
                sb.append("\n");
                flag = true;
            }
        }
        if (flag == false) sb.append("Отсутствуют\n");
    }

    private void getFemale(StringBuilder sb, List<E> list, E human) {
        boolean flag = false;
        for (E el : list) {
            if ((el.getGender() == Gender.Female) && (el != human)) {
                sb.append(getHumanInfo(el));
                sb.append("\n");
                flag = true;
            }
        }
        if (flag == false) sb.append("Отсутствуют\n");
    }

    private String getHumanInfo(E human) {
        HumanForTreeInfo info = new HumanForTreeInfo(human);
        return info.getInfo();
    }
    @Override
    public String toString() {
        return getInfo();
    }
    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        if (tree.size() > 0) {
            for (int i = 0; i < tree.size(); i++) {
                sb.append(tree.get(i));
                sb.append("\n");
            }
        } else sb.append("Дерево не заполнено");
        return sb.toString();
    }
    @Override
    public Iterator<E> iterator() {
        return new HumanIterator(tree);
    }
    @Override
    public void sortByName() {
        Collections.sort(tree, new HumanComparatorByName<>());
    }
    @Override
    public void sortByAge() {
        Collections.sort(tree, new HumanComparatorByAge<>());
    }
    @Override
    public void sortByID(){
        Collections.sort(tree, new HumanComparatorByID<>());
    }
    public E getHumanByID(int id) {
        for (E el : tree) {
            if (el.getId() == id) return el;
        }
        return null;
    }
    @Override
    public int getSize() {
        return tree.size();
    }
}