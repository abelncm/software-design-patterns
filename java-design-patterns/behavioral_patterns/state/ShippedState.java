package behavioral_patterns.state;

/**
 * ConcreteState B: Represents the "Shipped" state of a package.
 */
public class ShippedState implements PackageState {
    private static final String STATUS = "Shipped";

    public ShippedState() {
        System.out.println("Package is now in " + STATUS + " state.");
    }

    /**
     * When a package is in the Shipped state, the next action is typically to deliver it.
     * This method transitions the context (package) to the DeliveredState.
     * @param ctx The PackageContext.
     * @return A string describing the action.
     */
    @Override
    public String updateState(PackageContext ctx) {
        System.out.println(STATUS + ": Attempting to deliver the package.");
        ctx.setCurrentState(new DeliveredState()); // Transition to DeliveredState
        return "Package is in transit. Transitioning to Delivered state upon arrival.";
    }

    @Override
    public String getStatus() {
        return STATUS;
    }
}
