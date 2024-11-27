public class Smoothie extends Beverage {
    private int numOfFruits;
    private boolean addProtein;
    private final double BASE_PRICE = 3.5;
    private final double FRUIT_COST = 0.5;
    private final double PROTEIN_COST = 1.5;

    // Constructor
    public Smoothie(String bevName, SIZE size, int numOfFruits, boolean addProtein) {
        super(bevName, size);
        this.numOfFruits = numOfFruits;
        this.addProtein = addProtein;
    }

    @Override
    public double calcPrice() {
        double price = BASE_PRICE;
        switch (getSize()) {
            case MEDIUM -> price += 1.0;
            case LARGE -> price += 1.5;
        }
        price += numOfFruits * FRUIT_COST;
        if (addProtein) price += PROTEIN_COST;
        return price;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" (Fruits: %d, Protein: %s)", numOfFruits, addProtein);
    }
}
