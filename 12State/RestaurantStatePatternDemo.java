interface OrderState {
    void handle(Context context);
}

// Concrete class representing the state when the order is being prepared
class PrepareState implements OrderState {
    public void handle(Context context) {
        System.out.println("Order is being prepared");
        context.setState(this);
    }

    public String toString() {
        return "Preparing Order";
    }
}

// Concrete class representing the state when the order is ready for delivery
class ReadyState implements OrderState {
    public void handle(Context context) {
        System.out.println("Order is ready for delivery");
        context.setState(this);
    }

    public String toString() {
        return "Ready for Delivery";
    }
}

// Context class to maintain the current state of the order
class Context {
    private OrderState state;

    public Context() {
        state = null;
    }

    public void setState(OrderState state) {
        this.state = state;
    }

    public OrderState getState() {
        return state;
    }
}

// Main class to demonstrate the state pattern in the restaurant domain
public class RestaurantStatePatternDemo {
    public static void main(String[] args) {
        Context context = new Context();

        PrepareState prepareState = new PrepareState();
        prepareState.handle(context);

        System.out.println(context.getState().toString());

        ReadyState readyState = new ReadyState();
        readyState.handle(context);

        System.out.println(context.getState().toString());
    }
}
