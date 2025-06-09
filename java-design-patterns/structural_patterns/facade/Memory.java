package structural_patterns.facade;

/**
 * Subsystem Class 2: Represents the system Memory.
 */
public class Memory {
    private static final long BOOT_ADDRESS = 0x000A; // Example boot address

    public long getBootAddress() {
        return BOOT_ADDRESS;
    }

    public void load(long position, byte[] data) {
        System.out.println("Memory: Loading data to position " + position + ".");
        // Simulate loading data
        for (int i = 0; i < data.length; i++) {
            // In a real scenario, data[i] would be stored at position + i
        }
        System.out.println("Memory: Data loaded successfully.");
    }

    public void clear() {
        System.out.println("Memory: Clearing memory.");
    }
}
