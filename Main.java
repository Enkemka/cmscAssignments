public class Main {
    public static void main(String[] args) {
        // Create BevShop instance
    	   BevShop bevShop = new BevShop();

           // Start a new order
           System.out.println("Start new order");
           bevShop.startNewOrder(10, "Saturday", "John", 23);
           System.out.println("Total on order: " + bevShop.calculateTotalForCurrentOrder());

           // Add first alcohol drink
           System.out.println("Add alcohol drink");
           bevShop.addNewBeverage("Whiskey", SIZE.LARGE);
           System.out.println("Total on the order: " + bevShop.calculateTotalForCurrentOrder());

           // Add second alcohol drink
           System.out.println("Add 2nd alcohol drink");
           bevShop.addNewBeverage("Vodka", SIZE.MEDIUM);
           System.out.println("Total on the order: " + bevShop.calculateTotalForCurrentOrder());

           // Add a coffee to the order
           System.out.println("Add coffee to the order");
           bevShop.addNewBeverage("Latte", SIZE.SMALL, true, false);
           System.out.println("Total on the order: " + bevShop.calculateTotalForCurrentOrder());

           // Print total for all orders
           System.out.println("Total amount for all orders: " + bevShop.totalMonthlySales());
    }
}
