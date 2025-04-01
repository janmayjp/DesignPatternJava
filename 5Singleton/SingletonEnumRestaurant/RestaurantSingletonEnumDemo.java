enum RestaurantManagerEnum 
{
	INSTANCE;

    private int count;

    public int getCount() 
    {
        return count;
    }

    public void setCount(int count) 
    {
        this.count = count;
    }
}
public class RestaurantSingletonEnumDemo 
{
	public static void main(String[] args) 
	{
        RestaurantManagerEnum manager1 = RestaurantManagerEnum.INSTANCE;
        System.out.println("Initial value: " + manager1.getCount());

        manager1.setCount(2);
        System.out.println("Updated value: " + manager1.getCount());

        RestaurantManagerEnum manager2 = RestaurantManagerEnum.INSTANCE;
        manager2.setCount(5);
        System.out.println("Updated value from another instance: " + manager2.getCount());
    }

}
