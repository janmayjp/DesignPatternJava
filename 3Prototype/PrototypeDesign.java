import java.util.ArrayList;
import java.util.List;

class Dish {
    private String dishName;
    private double cost;

    // Getters and setters for Dish properties
    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Dish [dishName=" + dishName + ", cost=" + cost + "]";
    }
}

class Menu implements Cloneable {
    private String menuName;
    List<Dish> dishes = new ArrayList<>();

    // Getters and setters for Menu properties
    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

    public void loadMenuItems() {
        // Loading Dish objects into the Menu
        for (int i = 1; i <= 10; i++) {
            Dish d = new Dish();
            d.setDishName("Dish " + i);
            d.setCost(9.99 + i * 2);
            getDishes().add(d);
        }
    }

    @Override
    public String toString() {
        return "Menu [menuName=" + menuName + ", dishes=" + dishes + "]";
    }

    // Deep cloning the Menu by creating a new Menu and copying Dish objects
    @Override
    protected Menu clone() throws CloneNotSupportedException {
        Menu menu = new Menu();
        for (Dish d : this.getDishes()) {
            menu.getDishes().add(d);
        }
        return menu;
    }
}

public class PrototypeDesign {
    public static void main(String[] args) throws CloneNotSupportedException {
        Menu originalMenu = new Menu();
        originalMenu.setMenuName("Regular Menu");
        originalMenu.loadMenuItems();

        // Uncomment the lines below for shallow cloning
        // originalMenu.getDishes().remove(2);
        // System.out.println(originalMenu);
    
        // Menu clonedMenu = (Menu) originalMenu.clone(); // for shallow clone

        // Creating a cloned menu using deep cloning
        Menu clonedMenu = originalMenu.clone();
        originalMenu.getDishes().remove(2);
        clonedMenu.setMenuName("Seasonal Menu");
        // Uncomment the line below for shallow cloning
        // clonedMenu.loadMenuItems(); // for shallow clone

        System.out.println(originalMenu);
        System.out.println(clonedMenu);
    }
}