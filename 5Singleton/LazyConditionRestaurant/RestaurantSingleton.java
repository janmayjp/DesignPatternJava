class RestaurantManager 
{
	private static RestaurantManager instance; // Not initializing here to achieve lazy loading

    private RestaurantManager() 
    {
        System.out.println("Restaurant Manager instance created");
        // Additional initialization code can go here
    }

    public static synchronized RestaurantManager getInstance() 
    {
    	if (instance == null) 
    	{
            instance = new RestaurantManager(); // Create the object only if it's not already created
        }
        System.out.println("Inside getInstance method");
        return instance;
    }
}

public class RestaurantSingleton 
{
	public static void main(String[] args) 
	{
        RestaurantManager manager1 = RestaurantManager.getInstance();
        RestaurantManager manager2 = RestaurantManager.getInstance();

        // Both manager1 and manager2 should refer to the same instance
        System.out.println(manager1 == manager2); // Output should be true
    }
}

