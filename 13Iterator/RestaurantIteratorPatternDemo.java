//Iterator interface for iterating over menu items
interface MenuItemIterator {
    public boolean hasNext();
    public Object next();
}

//Container interface representing a menu containing items
interface MenuContainer {
    public MenuItemIterator getIterator();
}

//Concrete class implementing the MenuContainer interface
class MenuRepository implements MenuContainer {
    public String menuItems[] = {"Pizza Margherita", "Seasonal Salad", "Seasonal Cocktail", "Chocolate Cake"};

    @Override
    public MenuItemIterator getIterator() {
        return new MenuItemIteratorImpl();
    }

    private class MenuItemIteratorImpl implements MenuItemIterator {
        int index;

        @Override
        public boolean hasNext() {
            if (index < menuItems.length) {
                return true;
            }
            return false;
        }

        @Override
        public Object next() {
            if (this.hasNext()) {
                return menuItems[index++];
            }
            return null;
        }
    }
}

//Main class to demonstrate the iterator pattern in the restaurant domain
public class RestaurantIteratorPatternDemo {

    public static void main(String[] args) {
        MenuRepository menuRepository = new MenuRepository();

        for (MenuItemIterator iter = menuRepository.getIterator(); iter.hasNext();) {
            String menuItem = (String) iter.next();
            System.out.println("Menu Item: " + menuItem);
        }
    }
}
