import java.util.HashMap;

//Flyweight interface
interface MenuItem {
    void serve();// Represents the interface for both intrinsic and extrinsic objects
}

//Concrete flyweight class (Intrinsic Object)
class Dish implements MenuItem {
    private String name;
    private double price;
    
    // Constructor to initialize intrinsic properties
    public Dish(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public void serve() {
        System.out.println("Serving dish: " + name +  " - Rs " + price);
    }
}

//Flyweight factory
class MenuItemFactory {
    private static final HashMap<String, MenuItem> menuItems = new HashMap<>();
    
    // Factory method to get or create intrinsic objects
    public static MenuItem getMenuItem(String name, double price) {
        MenuItem menuItem = menuItems.get(name);

        if (menuItem == null) {
            menuItem = new Dish(name, price);// Creating new intrinsic object if not found
            menuItems.put(name, menuItem);// Storing intrinsic objects for future use
            System.out.println("Creating dish: " + name);
        }
        return menuItem;
    }
}

public class RestaurantFlyDemo {
    // Creating extrinsic object
    private static final String[] dishNames = { "Burger", "Pizza", "Pasta", "Salad", "Sandwich" };
    private static final double[] dishPrices = { 150, 200, 180, 120, 100 };

    public static void main(String[] args) {
        // Method to order menuitem (Creating extrinsic objects)
        for (int i = 0; i < 20; ++i) {
            MenuItem menuItem = MenuItemFactory.getMenuItem(getRandomName(), getRandomPrice());// Getting or creating intrinsic object
            menuItem.serve();// Using intrinsic object to serve the order
        }
    }

    private static String getRandomName() {
        return dishNames[(int) (Math.random() * dishNames.length)];
    }

    private static double getRandomPrice() {
        return dishPrices[(int) (Math.random() * dishPrices.length)];
    }
}
