import java.util.ArrayList;
import java.util.List;

// Originator: Represents the FoodMenu whose state needs to be saved/restored
class FoodMenu {
    private List<String> items;

    public FoodMenu() {
        this.items = new ArrayList<>();
    }

    public void addItem(String item) {
        items.add(item);
    }

    public void removeItem(String item) {
        items.remove(item);
    }

    public void displayMenu() {
        for (String item : items) {
            System.out.println("- " + item);
        }
    }

    // Create Memento object containing the current state of the menu
    public MenuMemento saveMenu() {
        return new MenuMemento(new ArrayList<>(items));
    }

    // Restore the menu to a previous state from a Memento object
    public void restoreMenu(MenuMemento memento) {
        this.items = memento.getSavedMenu();
    }
}

// Memento: Represents the snapshot of the FoodMenu's state
class MenuMemento {
    private List<String> savedMenu;

    public MenuMemento(List<String> menu) {
        this.savedMenu = new ArrayList<>(menu);
    }

    public List<String> getSavedMenu() {
        return savedMenu;
    }
}

// Caretaker: Manages the list of saved menu states
class MenuHistory {
    private List<MenuMemento> mementos = new ArrayList<>();

    public void addMenuMemento(MenuMemento memento) {
        mementos.add(memento);
    }

    public MenuMemento getLastMenuMemento() {
        if (mementos.size() > 0) {
            return mementos.remove(mementos.size() - 1);
        }
        return null;
    }
}

public class MementoDesignPattern {
    public static void main(String[] args) {
        FoodMenu menu = new FoodMenu();
        MenuHistory history = new MenuHistory();

        // Add items to the menu
        System.out.println("\nCurrent Menu:");
        menu.addItem("Burger");
        menu.addItem("Pizza");
        menu.displayMenu();

        // Save the menu state
        history.addMenuMemento(menu.saveMenu());

        System.out.println("There are some changes in the menu.");
        // Make changes to the menu
        menu.removeItem("Pizza");
        menu.addItem("Pasta");
        System.out.println("------------------------------------");
        System.out.println("Updated Menu: ");
        menu.displayMenu();

        // Restore previous menu state
        MenuMemento lastMenuMemento = history.getLastMenuMemento();
        if (lastMenuMemento != null) {
            menu.restoreMenu(lastMenuMemento);
            System.out.println("------------------------------------");
            System.out.println("If any previous Menu is available it is displayed below.");
            System.out.println("Restored Menu:");
            menu.displayMenu();
        } else {
            System.out.println("No previous menu states found.");
        }
    }
}