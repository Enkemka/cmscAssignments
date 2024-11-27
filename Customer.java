public class Customer {
    private String name;
    private int age;

    // Parametrized constructor
    public Customer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Copy constructor
    public Customer(Customer other) {
        this.name = other.name;
        this.age = other.age;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // Overridden toString method
    @Override
    public String toString() {
        return String.format("Customer{name='%s', age=%d}", name, age);
    }
}
