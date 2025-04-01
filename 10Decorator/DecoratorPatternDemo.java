
// Component interface
interface MenuItem {
    void serve();
}

// Concrete component
class Burger implements MenuItem {
    @Override
    public void serve() {
        System.out.println("Serving: Burger");
    }
}

class Pizza implements MenuItem {
    @Override
    public void serve() {
        System.out.println("Serving: Pizza");
    }
}

// Decorator abstract class
abstract class MenuItemDecorator implements MenuItem {
    protected MenuItem decoratedItem;

    public MenuItemDecorator(MenuItem decoratedItem) {
        this.decoratedItem = decoratedItem;
    }

    public void serve() {
        decoratedItem.serve();
    }
}

// Concrete decorators
class SpicyMenuItemDecorator extends MenuItemDecorator {
    public SpicyMenuItemDecorator(MenuItem decoratedItem) {
        super(decoratedItem);
    }

    @Override
    public void serve() {
        decoratedItem.serve();
        addSpice(decoratedItem);
    }

    private void addSpice(MenuItem decoratedItem) {
        System.out.println("Adding spice to: " + decoratedItem.getClass().getSimpleName());
    }
}

// Implementation
public class DecoratorPatternDemo {
    public static void main(String[] args) {
        MenuItem burger = new Burger();
        MenuItem spicyBurger = new SpicyMenuItemDecorator(new Burger());

        MenuItem pizza = new Pizza();
        MenuItem spicyPizza = new SpicyMenuItemDecorator(new Pizza());

        System.out.println("Regular Burger:");
        burger.serve();

        System.out.println("\nSpicy Burger:");
        spicyBurger.serve();

        System.out.println("\nRegular Pizza:");
        pizza.serve();

        System.out.println("\nSpicy Pizza:");
        spicyPizza.serve();
    }
}
