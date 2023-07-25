package family_tree.presenter;

import family_tree.model.service.Service;
import family_tree.model.tree.FamilyTree;
import family_tree.view.View;

import java.time.LocalDate;

public class Presenter {
    private View view;
    private Service service;
    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }
    public void sortByAge() {
        service.sortByAge();
    }
    public void sortByName() {
        service.sortByName();
    }
    public void sortByID(){
        service.sortByID();
    }
    public FamilyTree showAllTree() {
        return service.showAllTree();
    }
    public boolean connection(int parentID, int childID) {
        return service.connection(parentID, childID);
    }
    public boolean save(String path) {
        return service.save(path);
    }
    public boolean downland(String path) {
        return service.dowland(path);
    }
    public String nextOfKin(int humanID) {
        return service.nextOfKin(humanID);
    }
    public int treeIsEmpty(){
        return service.treeIsEmpty();
    }


    public void addHumanToTree(String name, String surname, String patronymic, String sex, LocalDate birth, LocalDate death) {
        service.addHumanToTree(name, surname, patronymic, sex, birth, death);
    }
}
