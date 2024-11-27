import java.util.ArrayList;
import java.util.List;

public class BevShop {
    private List<Order> orders;
    private int currentOrderIndex;

    // Constructor
    public BevShop() {
        this.orders = new ArrayList<>();
        this.currentOrderIndex = -1;
    }

    // Start a new order
    public void startNewOrder(int time, String day, String customerName, int customerAge) {
        Customer customer = new Customer(customerName, customerAge);
        Order order = new Order(time, day, customer);
        orders.add(order);
        currentOrderIndex = orders.size() - 1;
    }

    // Add a beverage to the current order
    public void addNewBeverage(String bevName, SIZE size, boolean extraShot, boolean extraSyrup) {
        if (currentOrderIndex >= 0) {
            orders.get(currentOrderIndex).addNewBeverage(bevName, size, extraShot, extraSyrup);
        }
    }

    public void addNewBeverage(String bevName, SIZE size) {
        if (currentOrderIndex >= 0) {
            orders.get(currentOrderIndex).addNewBeverage(bevName, size);
        }
    }

    public void addNewBeverage(String bevName, SIZE size, int numOfFruits, boolean addProtein) {
        if (currentOrderIndex >= 0) {
            orders.get(currentOrderIndex).addNewBeverage(bevName, size, numOfFruits, addProtein);
        }
    }

    // Calculate the total price of the current order
    public double calculateTotalForCurrentOrder() {
        if (currentOrderIndex >= 0) {
            return orders.get(currentOrderIndex).calcOrderTotal();
        }
        return 0.0;
    }

    // Find total earnings
    public double totalMonthlySales() {
        double total = 0.0;
        for (Order order : orders) {
            total += order.calcOrderTotal();
        }
        return total;
    }

    // Get total number of orders
    public int totalNumOfMonthlyOrders() {
        return orders.size();
    }

    // Get a specific order
    public Order getOrder(int index) {
        if (index >= 0 && index < orders.size()) {
            return orders.get(index);
        }
        return null;
    }

    // Getters
    public List<Order> getOrders() {
        return orders;
    }

    // Overridden toString
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Beverage Shop Orders:\n");
        for (Order order : orders) {
            sb.append(order.toString()).append("\n");
        }
        sb.append(String.format("Total Monthly Sales: $%.2f", totalMonthlySales()));
        return sb.toString();
    }
}
