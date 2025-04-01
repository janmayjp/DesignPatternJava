

// Interface for regular menu items
 interface RegularMenuItem {
    void serve(String itemType, String itemName);
}

// Interface for seasonal menu items
 interface SeasonalMenuItem {
    void serveSeasonalFood(String foodName);
    void serveSeasonalDrink(String drinkName);
}

// Concrete class representing seasonal food items
class FoodSeasonal implements SeasonalMenuItem {
    @Override
    public void serveSeasonalFood(String foodName) {
        System.out.println("SeasonalFood : " + foodName);
    }
    @Override
    public void serveSeasonalDrink(String drinkName) {
        // do nothing
    }
}

// Concrete class representing seasonal drink items
class DrinkSeasonal implements SeasonalMenuItem {
    @Override
    public void serveSeasonalFood(String foodName) {
        // do nothing
    }
    @Override
    public void serveSeasonalDrink(String drinkName) {
        System.out.println("SeasonalDrink : " + drinkName);
    }
}

// Adapter class to adapt seasonal menu items to regular menu items
class SeasonalMenuAdapter implements RegularMenuItem {
    SeasonalMenuItem seasonalMenuItem;

    public SeasonalMenuAdapter(String itemType) {
        if (itemType.equalsIgnoreCase("food")) {
            seasonalMenuItem = new FoodSeasonal();
        } else if (itemType.equalsIgnoreCase("drink")) {
            seasonalMenuItem = new DrinkSeasonal();
        }
    }
    
    @Override
    public void serve(String itemType, String itemName) {
        if (itemType.equalsIgnoreCase("food")) {
            seasonalMenuItem.serveSeasonalFood(itemName);
        } else if (itemType.equalsIgnoreCase("drink")) {
            seasonalMenuItem.serveSeasonalDrink(itemName);
        }
    }
}

// Class representing the main restaurant menu
class RestaurantMenu implements RegularMenuItem {
    SeasonalMenuAdapter seasonalMenuAdapter;

    public void serve(String itemType, String itemName) {
        // Inbuilt support to serve regular menu items
        if (itemType.equalsIgnoreCase("regular")) {
            System.out.println("Serving regular item: " + itemName);
        }
        // SeasonalMenuAdapter provides support to serve seasonal items
        else if (itemType.equalsIgnoreCase("food") || itemType.equalsIgnoreCase("drink")) {
            seasonalMenuAdapter = new SeasonalMenuAdapter(itemType);
            seasonalMenuAdapter.serve(itemType, itemName);
        } else {
            System.out.println("Invalid item. " + itemType + " not supported");
        }
    }
}

// Demo class to showcase the adapter pattern usage
public class RestaurantAdapterPatternDemo {
    public static void main(String[] args) {
        RestaurantMenu restaurantMenu = new RestaurantMenu();

        restaurantMenu.serve("regular", "Pizza Margherita");
        restaurantMenu.serve("food", "Seasonal Salad");
        restaurantMenu.serve("drink", "Seasonal Cocktail");
        restaurantMenu.serve("dessert", "Chocolate Cake");
    }
}
