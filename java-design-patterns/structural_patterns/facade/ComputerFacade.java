package structural_patterns.facade;

/**
 * Facade Class: Provides a simplified interface to the complex subsystem
 * of computer components (CPU, Memory, HardDrive).
 */
public class ComputerFacade {
    private CPU processor;
    private Memory ram;
    private HardDrive hdd;

    /**
     * Constructor initializes the subsystem components.
     * In a real application, these might be injected or obtained from a factory.
     */
    public ComputerFacade() {
        this.processor = new CPU();
        this.ram = new Memory();
        this.hdd = new HardDrive();
        System.out.println("ComputerFacade: Subsystem components initialized.");
    }

    /**
     * Starts the computer.
     * This method encapsulates the complex sequence of operations
     * required to boot up the computer.
     */
    public void startComputer() {
        System.out.println("\nComputerFacade: --- Starting Computer ---");
        hdd.spinUp();
        processor.freeze();
        ram.load(ram.getBootAddress(), hdd.readBootSector());
        processor.jump(ram.getBootAddress());
        processor.execute();
        System.out.println("ComputerFacade: --- Computer Started Successfully ---");
    }

    /**
     * Shuts down the computer.
     * This method encapsulates the sequence of operations for shutdown.
     */
    public void shutdownComputer() {
        System.out.println("\nComputerFacade: --- Shutting Down Computer ---");
        processor.stop();
        ram.clear();
        hdd.powerDown();
        System.out.println("ComputerFacade: --- Computer Shutdown Successfully ---");
    }

    // We can also expose parts of the subsystem if needed,
    // though the primary goal of Facade is simplification.
    public void performQuickCheck() {
        System.out.println("\nComputerFacade: --- Performing Quick System Check ---");
        System.out.println("CPU Status: OK (Simulated)");
        System.out.println("Memory Status: OK (Simulated)");
        System.out.println("HardDrive Status: OK (Simulated)");
        System.out.println("ComputerFacade: --- Quick Check Finished ---");
    }
}
