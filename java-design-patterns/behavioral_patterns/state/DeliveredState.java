package behavioral_patterns.state;

/**
 * ConcreteState C: Represents the "Delivered" state of a package.
 * This is often a final state in this context.
 */
public class DeliveredState implements PackageState {
    private static final String STATUS = "Delivered";

    public DeliveredState() {
        System.out.println("Package is now in " + STATUS + " state.");
    }

    /**
     * When a package is in the Delivered state, there are typically no further state transitions
     * in a simple delivery lifecycle.
     * @param ctx The PackageContext.
     * @return A string describing the current status.
     */
    @Override
    public String updateState(PackageContext ctx) {
        String message = "Package has been successfully " + STATUS + ". No further state changes.";
        System.out.println(STATUS + ": " + message);
        // No state transition from here in this simple model.
        // ctx.setCurrentState(new SomeOtherState()); // If there were a next state
        return message;
    }

    @Override
    public String getStatus() {
        return STATUS;
    }
}
