import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Order {
    private int orderNumber;
    private int orderTime; // e.g., 24-hour format
    private String orderDay; // e.g., "Monday"
    private Customer customer;
    private List<Beverage> beverages;

    // Constructor
    public Order(int orderTime, String orderDay, Customer customer) {
        this.orderNumber = generateOrderNumber();
        this.orderTime = orderTime;
        this.orderDay = orderDay;
        this.customer = new Customer(customer); // Deep copy
        this.beverages = new ArrayList<>();
    }

    // Method to generate a random order number
    private int generateOrderNumber() {
        Random rand = new Random();
        return 10000 + rand.nextInt(80001); // Generates a number between 10000 and 90000
    }

    // Check if the order is placed on a weekend
    public boolean isWeekend() {
        return orderDay.equalsIgnoreCase("Saturday") || orderDay.equalsIgnoreCase("Sunday");
    }

    // Add a new beverage
    public void addNewBeverage(String bevName, SIZE size, boolean extraShot, boolean extraSyrup) {
        beverages.add(new Coffee(bevName, size, extraShot, extraSyrup));
    }

    public void addNewBeverage(String bevName, SIZE size) {
        beverages.add(new Alcohol(bevName, size, isWeekend()));
    }

    public void addNewBeverage(String bevName, SIZE size, int numOfFruits, boolean addProtein) {
        beverages.add(new Smoothie(bevName, size, numOfFruits, addProtein));
    }

    // Retrieve a beverage by index
    public Beverage getBeverage(int index) {
        if (index >= 0 && index < beverages.size()) {
            return beverages.get(index);
        }
        return null;
    }

    // Calculate the total cost of the order
    public double calcOrderTotal() {
        double total = 0.0;
        for (Beverage bev : beverages) {
            total += bev.calcPrice();
        }
        return total;
    }

    // Find the number of beverages of a specific type
    public int findNumOfBeveType(TYPE type) {
        int count = 0;
        for (Beverage bev : beverages) {
            if (bev.getType() == type) {
                count++;
            }
        }
        return count;
    }

    // Getters and Setters
    public int getOrderNumber() {
        return orderNumber;
    }

    public int getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(int orderTime) {
        this.orderTime = orderTime;
    }

    public String getOrderDay() {
        return orderDay;
    }

    public void setOrderDay(String orderDay) {
        this.orderDay = orderDay;
    }

    public Customer getCustomer() {
        return new Customer(customer); // Return a deep copy
    }

    public List<Beverage> getBeverages() {
        return beverages;
    }

    // Overridden toString
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Order #%d\nTime: %d\nDay: %s\nCustomer: %s\n", 
                orderNumber, orderTime, orderDay, customer.toString()));
        sb.append("Beverages:\n");
        for (Beverage bev : beverages) {
            sb.append(bev.toString()).append("\n");
        }
        sb.append(String.format("Total Price: $%.2f", calcOrderTotal()));
        return sb.toString();
    }
}
