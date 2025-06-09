package structural_patterns.decorator;

/**
 * Component Interface: Defines the interface for objects that can have
 * responsibilities added to them dynamically.
 * In this example, it's a Coffee.
 */
public interface Coffee {
    /**
     * Gets the cost of the coffee.
     * @return The cost.
     */
    double getCost();

    /**
     * Gets the description of the coffee.
     * @return The description.
     */
    String getDescription();
}
