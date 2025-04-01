interface Dish {
    void prepare();
}

class Burger implements Dish {
    @Override
    public void prepare() {
        System.out.println("Preparing burger...");
    }
}

class Pizza implements Dish {
    @Override
    public void prepare() {
        System.out.println("Preparing pizza...");
    }
}

class Drink implements Dish {
    @Override
    public void prepare() {
        System.out.println("Preparing drink...");
    }
}

class RestaurantFacade {
    private Dish burger;
    private Dish pizza;
    private Dish drink;

    public RestaurantFacade() {
        burger = new Burger();
        pizza = new Pizza();
        drink = new Drink();
    }

    public void prepareBurger() {
        burger.prepare();
    }

    public void preparePizza() {
        pizza.prepare();
    }

    public void prepareDrink() {
        drink.prepare();
    }
}

public class RestaurantFacadeDemo {
    public static void main(String[] args) {
        RestaurantFacade restaurantFacade = new RestaurantFacade();

        restaurantFacade.prepareBurger();
        restaurantFacade.preparePizza();
        restaurantFacade.prepareDrink();
    }
}
