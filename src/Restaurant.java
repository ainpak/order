import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Restaurant {
    private List<Order> orders;
    private List<MenuItem> menu;

    // Конструктор
    public Restaurant() {
        this.orders = new ArrayList<>();
        this.menu = new ArrayList<>();
    }

    // Метод для добавления блюда в меню
    public void addMenuItem(MenuItem item) {
        menu.add(item);
    }

    // Метод для размещения заказа
    public void placeOrder(Order order) {
        for (MenuItem item : order.getItems()) {
            if (!menu.contains(item)) {
                throw new NoSuchElementException("Menu item not found: " + item.getName());
            }
        }
        orders.add(order);
    }

    // Метод для получения заказа по ID
    public Order getOrderById(int orderId) {
        for (Order order : orders) {
            if (order.getOrderId() == orderId) {
                return order;
            }
        }
        throw new IllegalArgumentException("Order not found with ID: " + orderId);
    }

    // Метод для завершения заказа по ID
    public void completeOrder(int orderId) {
        Order order = getOrderById(orderId);
        order.completeOrder();
    }
}

