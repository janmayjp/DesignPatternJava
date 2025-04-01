
import java.util.ArrayList;
import java.util.List;

interface RestaurantComponent {
    // Method to display details of the component with the specified depth
    void displayDetails(int depth);

    // Method to get the cost of the component
    double getCost();

    // Default method to add a subcomponent to the composite component
    default void addComponent(RestaurantComponent component) {
    }
}

class DishLeaf implements RestaurantComponent {
    double cost;
    String dishName;

    // Constructor to initialize DishLeaf object
    DishLeaf(String dishName, double cost) {
        this.dishName = dishName;
        this.cost = cost;
    }

    // Method to display details of the dish with the specified depth
    public void displayDetails(int depth) {
        StringBuilder indent = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            indent.append(" "); // Four spaces for each level of depth
        }
        System.out.println(indent + dishName + " : Rs " + cost);
    }

    // Method to get the cost of the dish
    public double getCost() {
        return cost;
    }
}

class MenuComposite implements RestaurantComponent {
    String menuName;
    List<RestaurantComponent> components = new ArrayList<>();

    // Constructor to initialize MenuComposite object
    public MenuComposite(String menuName) {
        this.menuName = menuName;
    }

    // Method to add a subcomponent to the composite component
    public void addComponent(RestaurantComponent component) {
        components.add(component);
    }

    // Method to get the total cost of the composite component
    public double getCost() {
        double totalCost = 0;
        for (RestaurantComponent component : components) {
            totalCost += component.getCost();
        }
        return totalCost;
    }

    // Method to display details of the menu with the specified depth
    public void displayDetails(int depth) {
        StringBuilder indent = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            indent.append(" "); // Four spaces for each level of depth
        }
        System.out.println(indent + menuName + " : Rs " + getCost());
        for (RestaurantComponent component : components) {
            component.displayDetails(depth + 1); // Increase depth for child components
        }
    }
}

public class RestaurantCompositePattern {
    public static void main(String[] args) {
        RestaurantComponent burger = new DishLeaf("Burger", 60);
        RestaurantComponent fries = new DishLeaf("Fries", 50);
        RestaurantComponent soda = new DishLeaf("Soda", 20);

        RestaurantComponent combo = new MenuComposite("Combo");
        combo.addComponent(burger);
        combo.addComponent(fries);
        combo.addComponent(soda);

        RestaurantComponent salad = new DishLeaf("Salad", 30);

        RestaurantComponent mainMenu = new MenuComposite("Main Menu");
        mainMenu.addComponent(combo);
        mainMenu.addComponent(salad);

        mainMenu.displayDetails(0); // Start with depth 0
    }
}
