package structural_patterns.facade;

/**
 * Subsystem Class 3: Represents the Hard Drive.
 */
public class HardDrive {
    private static final long BOOT_SECTOR = 0x0000; // Example boot sector start
    private static final int SECTOR_SIZE = 512;    // Example sector size

    public byte[] readBootSector() {
        System.out.println("HardDrive: Reading data from boot sector " + BOOT_SECTOR + ".");
        // Simulate reading 512 bytes of boot data
        byte[] data = new byte[SECTOR_SIZE];
        for (int i = 0; i < SECTOR_SIZE; i++) {
            data[i] = (byte) (i % 256); // Dummy data
        }
        System.out.println("HardDrive: Boot sector data read.");
        return data;
    }

    public void powerDown() {
        System.out.println("HardDrive: Powering down.");
    }

    public void spinUp() {
        System.out.println("HardDrive: Spinning up platters.");
    }
}
