class RestaurantManager 
{
    // Eagerly creating a single instance of RestaurantManager
    private static final RestaurantManager instance = new RestaurantManager();

    // Private constructor to prevent instantiation from outside
    private RestaurantManager() 
    {
        System.out.println("Restaurant Manager instance created");
        // Additional initialization code can go here
    }

    // Public method to provide access to the singleton instance
    public static RestaurantManager getInstance() 
    {
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
