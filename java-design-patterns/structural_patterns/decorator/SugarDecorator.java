package structural_patterns.decorator;

/**
 * ConcreteDecorator B: Adds Sugar to the coffee.
 * It extends CoffeeDecorator and adds its own cost and description modification.
 */
public class SugarDecorator extends CoffeeDecorator {

    private static final double SUGAR_COST = 0.25;
    private static final String SUGAR_DESCRIPTION = ", Sugar";

    /**
     * Constructor for SugarDecorator.
     * @param decoratedCoffee The Coffee object to be decorated with sugar.
     */
    public SugarDecorator(Coffee decoratedCoffee) {
        super(decoratedCoffee);
        System.out.println("SugarDecorator added.");
    }

    /**
     * Adds the cost of sugar to the cost of the wrapped coffee.
     * @return The total cost.
     */
    @Override
    public double getCost() {
        return super.getCost() + SUGAR_COST;
    }

    /**
     * Appends ", Sugar" to the description of the wrapped coffee.
     * @return The modified description.
     */
    @Override
    public String getDescription() {
        return super.getDescription() + SUGAR_DESCRIPTION;
    }
}
