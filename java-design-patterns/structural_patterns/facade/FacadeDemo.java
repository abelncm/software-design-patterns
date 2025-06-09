package structural_patterns.facade;

/**
 * Client Class (Demo): Uses the Facade to interact with the complex subsystem.
 * The client is decoupled from the intricacies of the subsystem components
 * (CPU, Memory, HardDrive).
 */
public class FacadeDemo {
    public static void main(String[] args) {
        System.out.println("--- Facade Pattern Demo: Computer Startup/Shutdown ---");

        // Create the Facade instance
        ComputerFacade computer = new ComputerFacade();

        // Use the simplified interface provided by the Facade
        // Start the computer
        computer.startComputer();

        // Perform some other operation via Facade
        computer.performQuickCheck();

        // Shutdown the computer
        computer.shutdownComputer();

        System.out.println("\n--- Facade Pattern Demo Finished ---");

        // Note: The client (FacadeDemo) does not interact directly with CPU, Memory, or HardDrive.
        // All interactions are routed through the ComputerFacade, which simplifies the process.
        // If needed, advanced clients could still access subsystem components directly if the
        // Facade or another mechanism provides access, but the typical use of Facade
        // is for simplification.
    }
}
