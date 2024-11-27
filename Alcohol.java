public class Alcohol extends Beverage {
    private boolean isWeekend;
    private final double BASE_PRICE = 3.0;

    // Constructor
    public Alcohol(String bevName, SIZE size, boolean isWeekend) {
        super(bevName, size);
        this.isWeekend = isWeekend;
    }

    @Override
    public double calcPrice() {
        double price = BASE_PRICE;
        switch (getSize()) {
            case MEDIUM -> price += 1.5;
            case LARGE -> price += 3.0;
        }
        if (isWeekend) price += 0.6; // Additional charge for weekend
        return price;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" (Weekend: %s)", isWeekend);
    }
}
