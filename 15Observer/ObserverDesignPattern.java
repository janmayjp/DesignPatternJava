import java.util.ArrayList;
import java.util.List;

// Observer: Branch
class Branch {
    private String name;

    public Branch(String name) {
        this.name = name;
    }

    public void update(String newItem) {
        System.out.println(name + " branch\n New menu item '" + newItem + "' introduced!");
    }
}

// Subject: FoodMenu
class FoodMenu {
    private List<Branch> observers = new ArrayList<>();

    public void attach(Branch observer) {
        observers.add(observer);
    }

    public void detach(Branch observer) {
        observers.remove(observer);
    }

    public void notifyObservers(String newItem) {
        for (Branch observer : observers) {
            observer.update(newItem);
        }
    }
}

// Main class
public class ObserverDesignPattern {
    public static void main(String[] args) {
        FoodMenu menu = new FoodMenu();

        Branch branch1 = new Branch("SBR");
        Branch branch2 = new Branch("Shahibaug");

        menu.attach(branch1);
        menu.attach(branch2);

        // When a new menu item is introduced
        String newItem = "Gelato Supreme";
        menu.notifyObservers(newItem);
    }
}
