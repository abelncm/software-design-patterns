package structural_patterns.decorator;

/**
 * Decorator Abstract Class: Implements the Component (Coffee) interface
 * and holds a reference to a Component object (the coffee being decorated).
 * It delegates operations to the wrapped component.
 * Subclasses will add their own behavior.
 */
public abstract class CoffeeDecorator implements Coffee {
    // The Coffee object that this decorator wraps.
    protected Coffee decoratedCoffee;

    /**
     * Constructor for CoffeeDecorator.
     * @param decoratedCoffee The Coffee object to be decorated.
     */
    public CoffeeDecorator(Coffee decoratedCoffee) {
        if (decoratedCoffee == null) {
            throw new IllegalArgumentException("Decorated coffee cannot be null.");
        }
        this.decoratedCoffee = decoratedCoffee;
        System.out.println("CoffeeDecorator initialized with a " + decoratedCoffee.getClass().getSimpleName());
    }

    /**
     * Delegates the getCost() call to the wrapped coffee.
     * Concrete decorators will override this to add their own cost.
     * @return The cost from the wrapped coffee.
     */
    @Override
    public double getCost() {
        return decoratedCoffee.getCost();
    }

    /**
     * Delegates the getDescription() call to the wrapped coffee.
     * Concrete decorators will override this to add their own description.
     * @return The description from the wrapped coffee.
     */
    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription();
    }
}
