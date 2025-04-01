
// MainCourse interface
interface MainCourse {
    void getMainCourse();
}

// Concrete implementations of MainCourse interface
class Gujarati implements MainCourse {
    @Override
    public void getMainCourse() {
        System.out.println("Your Fafda-Jalebi is ready");
    }
}

class Punjabi implements MainCourse {
    @Override
    public void getMainCourse() {
        System.out.println("Your Lassi is ready");
    }
}

class Bengali implements MainCourse {
    @Override
    public void getMainCourse() {
        System.out.println("Your Rosogolla is ready");
    }
}

// MainCourseFactory class
class MainCourseFactory extends AbstractFactory {
    @Override
    MainCourse getMainCourse(String mainCourseType) {
        if (mainCourseType == null) {
            System.out.println("Options available are: Bengali / Gujarati / Punjabi");
            return null;
        } else if (mainCourseType.equalsIgnoreCase("Bengali")) {
            return new Bengali();
        } else if (mainCourseType.equalsIgnoreCase("Gujarati")) {
            return new Gujarati();
        } else if (mainCourseType.equalsIgnoreCase("Punjabi")) {
            return new Punjabi();
        } else {
            System.out.println("Please enter your choice correctly.");
            return null;
        }
    }

    @Override
    Dessert getDessert(String dessertType) {
        return null;  // MainCourseFactory doesn't create desserts
    }
}

// Dessert interface
interface Dessert {
    void getDessert();
}

// Concrete implementations of Dessert interface
class Brownie implements Dessert {
    @Override
    public void getDessert() {
        System.out.println("Your Brownie is ready");
    }
}

class Cheesecake implements Dessert {
    @Override
    public void getDessert() {
        System.out.println("Your Cheesecake is ready");
    }
}

class IceCream implements Dessert {
    @Override
    public void getDessert() {
        System.out.println("Your IceCream is ready");
    }
}

// DessertFactory class
class DessertFactory extends AbstractFactory {
    @Override
    MainCourse getMainCourse(String mainCourseType) {
        return null;  // DessertFactory doesn't create main courses
    }

    @Override
    Dessert getDessert(String dessertType) {
        if (dessertType == null) {
            System.out.println("Options available are: IceCream / Brownie / Cheesecake");
            return null;
        } else if (dessertType.equalsIgnoreCase("IceCream")) {
            return new IceCream();
        } else if (dessertType.equalsIgnoreCase("Brownie")) {
            return new Brownie();
        } else if (dessertType.equalsIgnoreCase("Cheesecake")) {
            return new Cheesecake();
        } else {
            System.out.println("Please enter your choice correctly.");
            return null;
        }
    }
}

// AbstractFactory class
abstract class AbstractFactory {
    abstract MainCourse getMainCourse(String mainCourseType);
    abstract Dessert getDessert(String dessertType);
}

// FactoryProducer class
class FactoryProducer {
    static AbstractFactory getMenu(String choose) {
        if (choose.equalsIgnoreCase("MainCourse")) {
            return new MainCourseFactory();
        } else if (choose.equalsIgnoreCase("Dessert")) {
            return new DessertFactory();
        } else {
            System.out.println("Please select from MainCourse or Dessert.");
            return null;
        }
    }
}

// Main class
public class RestaurantAbstractFactoryPattern {
    public static void main(String[] args) {
        // Using the FactoryProducer to get a MainCourseFactory
        AbstractFactory mainCourseFactory = FactoryProducer.getMenu("MainCourse");
        // Creating a Punjabi main course
        MainCourse mainCourse = mainCourseFactory.getMainCourse("Punjabi");
        if (mainCourse != null) {
            mainCourse.getMainCourse();
        }

        // Using the FactoryProducer to get a DessertFactory
        AbstractFactory dessertFactory = FactoryProducer.getMenu("Dessert");
        // Creating a Brownie dessert
        Dessert dessert = dessertFactory.getDessert("Brownie");
        if (dessert != null) {
            dessert.getDessert();
        }
    }
}
