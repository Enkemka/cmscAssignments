public class Coffee extends Beverage {
    private boolean extraShot;
    private boolean extraSyrup;
    private final double BASE_PRICE = 2.0;
    private final double EXTRA_COST = 0.5;

    // Constructor
    public Coffee(String bevName, SIZE size, boolean extraShot, boolean extraSyrup) {
        super(bevName, size);
        this.extraShot = extraShot;
        this.extraSyrup = extraSyrup;
    }

    @Override
    public double calcPrice() {
        double price = BASE_PRICE;
        switch (getSize()) {
            case MEDIUM -> price += 1.0;
            case LARGE -> price += 2.0;
        }
        if (extraShot) price += EXTRA_COST;
        if (extraSyrup) price += EXTRA_COST;
        return price;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" (Extra Shot: %s, Extra Syrup: %s)", extraShot, extraSyrup);
    }
}
