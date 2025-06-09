package structural_patterns.decorator;

/**
 * ConcreteDecorator A: Adds Milk to the coffee.
 * It extends CoffeeDecorator and adds its own cost and description modification.
 */
public class MilkDecorator extends CoffeeDecorator {

    private static final double MILK_COST = 0.5;
    private static final String MILK_DESCRIPTION = ", Milk";

    /**
     * Constructor for MilkDecorator.
     * @param decoratedCoffee The Coffee object to be decorated with milk.
     */
    public MilkDecorator(Coffee decoratedCoffee) {
        super(decoratedCoffee); // Calls the constructor of CoffeeDecorator
        System.out.println("MilkDecorator added.");
    }

    /**
     * Adds the cost of milk to the cost of the wrapped coffee.
     * @return The total cost.
     */
    @Override
    public double getCost() {
        return super.getCost() + MILK_COST;
    }

    /**
     * Appends ", Milk" to the description of the wrapped coffee.
     * @return The modified description.
     */
    @Override
    public String getDescription() {
        return super.getDescription() + MILK_DESCRIPTION;
    }
}
