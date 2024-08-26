import java.util.List;

public class Order {


        private int orderId;
        private String customerName;
        private List<MenuItem> items;
        private boolean isCompleted;


        public Order(int orderId, String customerName, List<MenuItem> items) {
            this.orderId = orderId;
            this.customerName = customerName;
            this.items = items;
            this.isCompleted = false;
        }


        public int getOrderId() {
            return orderId;
        }

        public void setOrderId(int orderId) {
            this.orderId = orderId;
        }

        public String getCustomerName() {
            return customerName;
        }

        public void setCustomerName(String customerName) {
            this.customerName = customerName;
        }

        public List<MenuItem> getItems() {
            return items;
        }

        public void setItems(List<MenuItem> items) {
            this.items = items;
        }

        public boolean isCompleted() {
            return isCompleted;
        }

        public void setCompleted(boolean completed) {
            isCompleted = completed;
        }


        public double calculateTotal() {
            double total = 0;
            for (MenuItem item : items) {
                total += item.getPrice();
            }
            return total;
        }


        public void completeOrder() {
            if (!isCompleted) {
                isCompleted = true;
            } else {
                throw new IllegalStateException("Order is already completed.");
            }
        }
    }


