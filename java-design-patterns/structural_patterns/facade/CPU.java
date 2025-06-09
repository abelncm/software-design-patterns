package structural_patterns.facade;

/**
 * Subsystem Class 1: Represents the Central Processing Unit (CPU).
 * Part of the complex subsystem that the Facade will simplify.
 */
public class CPU {
    public void freeze() {
        System.out.println("CPU: Freezing processor.");
    }

    public void jump(long position) {
        System.out.println("CPU: Jumping to memory position " + position + ".");
    }

    public void execute() {
        System.out.println("CPU: Executing instructions.");
    }

    public void stop() {
        System.out.println("CPU: Stopping processor.");
    }
}
