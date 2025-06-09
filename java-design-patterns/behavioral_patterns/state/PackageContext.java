package behavioral_patterns.state;

/**
 * Context Class: Maintains an instance of a ConcreteState subclass that defines
 * the current state. It delegates requests from client code to the current State object.
 * It also provides a way for States to transition the Context to a new state.
 */
public class PackageContext {
    private PackageState currentState;
    private String packageId;

    /**
     * Constructor for PackageContext.
     * Initializes with a default starting state (e.g., OrderedState).
     * @param packageId An identifier for the package.
     */
    public PackageContext(String packageId) {
        this.packageId = packageId;
        // Set the initial state
        this.currentState = new OrderedState(); // Default initial state
        System.out.println("PackageContext for '" + packageId + "' created. Initial state: " + currentState.getStatus());
    }

    /**
     * Sets the current state of the package. This method is typically called by
     * ConcreteState objects when a state transition occurs.
     * @param state The new PackageState.
     */
    public void setCurrentState(PackageState state) {
        if (state != null) {
            System.out.println("PackageContext for '" + packageId + "': Transitioning from " +
                               (this.currentState != null ? this.currentState.getStatus() : "null") +
                               " to " + state.getStatus());
            this.currentState = state;
        }
    }

    /**
     * Gets the current state of the package.
     * @return The current PackageState.
     */
    public PackageState getCurrentState() {
        return currentState;
    }

    public String getPackageId(){
        return packageId;
    }

    /**
     * Client-facing method to trigger an update or action on the package.
     * This request is delegated to the current state object.
     * The name of this method could be more specific like 'processNextStep()' or similar.
     */
    public void proceedToNextStatus() {
        System.out.println("\nPackageContext for '" + packageId + "': Proceeding to next status from " + currentState.getStatus() + ".");
        String actionDescription = currentState.updateState(this); // Delegate to current state
        System.out.println("PackageContext for '" + packageId + "': Action result -> " + actionDescription);
        System.out.println("PackageContext for '" + packageId + "': Current status is now " + currentState.getStatus() + ".");
    }

    /**
     * A more direct way for client to see current status without directly accessing state object.
     */
    public void printCurrentStatus() {
        System.out.println("PackageContext for '" + packageId + "': Current actual status is " + currentState.getStatus() + ".");
    }
}
