class Dish 
{
        private String name;
        private String cuisine;
        private double price;
        private boolean vegetarian;

        public Dish(String name, String cuisine, double price, boolean vegetarian) {
            this.name = name;
            this.cuisine = cuisine;
            this.price = price;
            this.vegetarian = vegetarian;
        }

        public void display() {
            System.out.println("Name: " + name + "\nCuisine: " + cuisine + "\nPrice: " + price + "\nVegetarian: " + vegetarian);
        }
}

class DishBuilder 
{
        private String name;
        private String cuisine;
        private double price;
        private boolean vegetarian;

        public DishBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public DishBuilder setCuisine(String cuisine) {
            this.cuisine = cuisine;
            return this;
        }

        public DishBuilder setPrice(double price) {
            this.price = price;
            return this;
        }

        public DishBuilder setVegetarian(boolean vegetarian) {
            this.vegetarian = vegetarian;
            return this;
        }

        public Dish build() {
            return new Dish(name, cuisine, price, vegetarian);
        }
}

public class BuilderDesign 
{
    public static void main(String[] args) {
        Dish dish = new DishBuilder()
            .setName("Bruschetta")
            .setCuisine("Italian")
            .setPrice(1000)
            .setVegetarian(false)
            .build();
        dish.display();
    }
}    