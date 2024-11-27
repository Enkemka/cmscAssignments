public abstract class Beverage {
    private String name;
    private SIZE size;

    // Constructor
    public Beverage(String name, SIZE size) {
        this.name = name;
        this.size = size;
    }

    // Abstract method for calculating price
    public abstract double calcPrice();

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SIZE getSize() {
        return size;
    }

    public void setSize(SIZE size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Size: " + size;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Beverage beverage = (Beverage) obj;
        return name.equals(beverage.name) && size == beverage.size;
    }

	public TYPE getType() {
		// TODO Auto-generated method stub
		return null;
	}
}
