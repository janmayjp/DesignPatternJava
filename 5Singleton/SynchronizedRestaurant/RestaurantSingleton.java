class RestaurantManager 
{
	private static RestaurantManager instance;

    private RestaurantManager() 
    {
        System.out.println("Restaurant Manager instance created");
    }

    public static synchronized RestaurantManager getInstance() 
    {
        if (instance == null) 
        {
            instance = new RestaurantManager();
        }
        System.out.println("Inside getInstance method");
        return instance;
    }
}

public class RestaurantSingleton 
{
    public static void main(String[] args) 
    {
        Thread t1 = new Thread(new Runnable() 
        {
            public void run() 
            {
                RestaurantManager manager1 = RestaurantManager.getInstance();
            }
        });

        Thread t2 = new Thread(new Runnable() 
        {
            public void run() 
            {
                RestaurantManager manager2 = RestaurantManager.getInstance();
            }
        });

        t1.start();
        t2.start();
    }
}

