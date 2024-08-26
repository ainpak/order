import java.util.Arrays;
import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) {

        Restaurant restaurant = new Restaurant();


        MenuItem pizza = new MenuItem("Pizza", 12.99);
        MenuItem burger = new MenuItem("Burger", 8.99);
        MenuItem salad = new MenuItem("Salad", 5.99);

        restaurant.addMenuItem(pizza);
        restaurant.addMenuItem(burger);
        restaurant.addMenuItem(salad);


        Order order1 = new Order(1, "Alice", Arrays.asList(pizza, burger));

        try {

            restaurant.placeOrder(order1);


            Order retrievedOrder = restaurant.getOrderById(1);
            System.out.println("Order ID: " + retrievedOrder.getOrderId());
            System.out.println("Customer Name: " + retrievedOrder.getCustomerName());
            System.out.println("Total Price: $" + retrievedOrder.calculateTotal());


            restaurant.completeOrder(1);
            System.out.println("Order 1 completed status: " + retrievedOrder.isCompleted());


            restaurant.completeOrder(1);
        } catch (IllegalArgumentException | NoSuchElementException | IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
