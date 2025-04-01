
import java.util.Scanner;

interface Cuisines {
    public void Food();
}

class Punjabi implements Cuisines {
    public void Food() {
        System.out.println("Lasssiiiiiii");
    }
}

class Gujarati implements Cuisines {
    public void Food() {
        System.out.println("Fafda Jalebiii");
    }
}

class Bengali implements Cuisines {
    public void Food() {
        System.out.println("Rosogullaa ChamCham");
    }
}

class InvalidCuisineException extends Exception {
    private static final long serialVersionUID = -2329257376277332049L;

    public InvalidCuisineException(String errorMessage) {
        super(errorMessage);
    }
}

class RestaurantFactory {
    public Cuisines getFood(String str) {
        try {
            if (str.equalsIgnoreCase("GUJARATI"))
                return new Gujarati();
            else if (str.equalsIgnoreCase("PUNJABI"))
                return new Punjabi();
            else if (str.equalsIgnoreCase("BENGALI"))
                return new Bengali();
            else
                throw new InvalidCuisineException("Invalid cuisine choice. Please enter a correct choice.");
        } catch (InvalidCuisineException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}

public class FactoryDesign {
    public static void main(String[] args) {
        RestaurantFactory rf = new RestaurantFactory();
        System.out.println("Enter food that you want to eat ");
        Scanner sc = new Scanner(System.in);
        String choice = sc.nextLine();
        Cuisines c = rf.getFood(choice);
        if (c != null)
            c.Food();
        sc.close();
    }
}
