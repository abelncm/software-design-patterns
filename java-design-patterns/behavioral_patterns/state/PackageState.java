package behavioral_patterns.state;

/**
 * State Interface: Declares methods that represent actions that can be performed on the context.
 * The behavior of these methods will vary depending on the current concrete state.
 * Each method typically takes the Context object as a parameter to allow states
 * to change the context's current state.
 */
public interface PackageState {
    /**
     * Updates the state of the package based on an action.
     * This is a general method; specific actions might be more descriptive
     * e.g., order(), ship(), deliver(). For this example, we'll use a more
     * generic updateState and let concrete states decide the next step.
     *
     * @param ctx The PackageContext whose state is to be updated.
     * @return A string describing the current action or status.
     */
    String updateState(PackageContext ctx);

    /**
     * Gets the name or status of the current state.
     * @return A string representing the current state.
     */
    String getStatus();
}
