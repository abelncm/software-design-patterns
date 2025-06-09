package behavioral_patterns.state;

/**
 * ConcreteState A: Represents the "Ordered" state of a package.
 * Implements behavior specific to this state.
 */
public class OrderedState implements PackageState {
    private static final String STATUS = "Ordered";

    public OrderedState() {
        System.out.println("Package is now in " + STATUS + " state.");
    }

    /**
     * When a package is in the Ordered state, the next action is typically to ship it.
     * This method transitions the context (package) to the ShippedState.
     * @param ctx The PackageContext.
     * @return A string describing the action.
     */
    @Override
    public String updateState(PackageContext ctx) {
        System.out.println(STATUS + ": Attempting to ship the package.");
        ctx.setCurrentState(new ShippedState()); // Transition to ShippedState
        return "Package has been ordered and is ready for shipping. Transitioning to Shipped state.";
    }

    @Override
    public String getStatus() {
        return STATUS;
    }
}
