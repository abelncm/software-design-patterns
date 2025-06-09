package structural_patterns.decorator;

/**
 * ConcreteComponent: A basic object to be decorated.
 * This is a simple, unadorned coffee.
 */
public class SimpleCoffee implements Coffee {

    public SimpleCoffee() {
        System.out.println("Created SimpleCoffee instance.");
    }

    @Override
    public double getCost() {
        return 2.0; // Base cost of a simple coffee
    }

    @Override
    public String getDescription() {
        return "Simple Coffee";
    }
}
