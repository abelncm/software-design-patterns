package creational_patterns.builder;

public class Demo {
    public static void main(String[] args) {
        System.out.println("--- Builder Pattern Demo ---");

        // Scenario 1: Basic Computer with only required parts and default OS
        System.out.println("\nBuilding a basic computer (required parts only, default OS):");
        Computer basicComputer = new Computer.Builder("Intel i5", "8GB")
                                    // No optional parts set explicitly
                                    .build();
        System.out.println(basicComputer);

        // Scenario 2: Gaming Computer with several optional parts
        System.out.println("\nBuilding a gaming computer:");
        Computer gamingComputer = new Computer.Builder("Intel i9", "32GB")
                                     .setStorage("1TB SSD + 2TB HDD")
                                     .setGraphicsCard("NVIDIA RTX 4090")
                                     .setOperatingSystem("Windows 11 Pro")
                                     .enableBluetooth(true)
                                     .enableWiFi(true)
                                     .build();
        System.out.println(gamingComputer);

        // Scenario 3: Office Computer with specific optional parts
        System.out.println("\nBuilding an office computer:");
        Computer officeComputer = new Computer.Builder("AMD Ryzen 5", "16GB")
                                     .setStorage("512GB SSD")
                                     // No dedicated graphics card, uses integrated
                                     .setOperatingSystem("Windows 10 Pro")
                                     .enableWiFi(true)
                                     // Bluetooth might not be needed
                                     .enableBluetooth(false)
                                     .build();
        System.out.println(officeComputer);

        // Scenario 4: Computer with only some optional features changed from default
        System.out.println("\nBuilding a custom computer (default OS, WiFi enabled):");
        Computer customComputer = new Computer.Builder("Intel Celeron", "4GB")
                                     .setStorage("256GB SSD")
                                     .enableWiFi(true)
                                     .build(); // OS will be default "Linux (Default)"
        System.out.println(customComputer);

        // Example of trying to build without required params (should fail if Builder constructor enforces)
        // This would typically be a compile-time error if no default constructor exists for Builder,
        // or a runtime error if checks are in the constructor, as done in Computer.Builder.
        try {
            System.out.println("\nAttempting to build computer without required CPU/RAM (expecting error):");
            Computer invalidComputer = new Computer.Builder(null, null).build();
            System.out.println(invalidComputer); // Should not reach here
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }


        System.out.println("\n--- Builder Pattern Demo Finished ---");
    }
}
