package creational_patterns.builder;

/**
 * Product: The complex object to be built.
 * In this case, a Computer with various components.
 */
public class Computer {
    // Required parameters
    private String cpu;
    private String ram;

    // Optional parameters
    private String storage;
    private String graphicsCard;
    private String operatingSystem;
    private boolean hasBluetooth;
    private boolean hasWiFi;

    // Private constructor that takes the Builder as an argument.
    // This ensures that the Computer object can only be created through the Builder.
    private Computer(Builder builder) {
        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.storage = builder.storage;
        this.graphicsCard = builder.graphicsCard;
        this.operatingSystem = builder.operatingSystem;
        this.hasBluetooth = builder.hasBluetooth;
        this.hasWiFi = builder.hasWiFi;
    }

    // Getters for all fields (optional, but useful for demonstration)
    public String getCpu() { return cpu; }
    public String getRam() { return ram; }
    public String getStorage() { return storage; }
    public String getGraphicsCard() { return graphicsCard; }
    public String getOperatingSystem() { return operatingSystem; }
    public boolean hasBluetooth() { return hasBluetooth; }
    public boolean hasWiFi() { return hasWiFi; }

    @Override
    public String toString() {
        return "Computer Config: \n" +
               " CPU: " + cpu + "\n" +
               " RAM: " + ram + "\n" +
               (storage != null ? " Storage: " + storage + "\n" : "") +
               (graphicsCard != null ? " Graphics Card: " + graphicsCard + "\n" : "") +
               (operatingSystem != null ? " OS: " + operatingSystem + "\n" : "") +
               " Bluetooth: " + (hasBluetooth ? "Enabled" : "Disabled") + "\n" +
               " WiFi: " + (hasWiFi ? "Enabled" : "Disabled");
    }

    /**
     * Static Nested Builder Class.
     * This is the ConcreteBuilder in the Builder pattern.
     * It provides a fluent interface for constructing a Computer object.
     */
    public static class Builder {
        // Required parameters mirror those in Computer
        private String cpu;
        private String ram;

        // Optional parameters mirror those in Computer, initialized to default values if necessary
        private String storage = null;
        private String graphicsCard = null;
        private String operatingSystem = "Linux (Default)"; // Default OS
        private boolean hasBluetooth = false;
        private boolean hasWiFi = false;

        /**
         * Constructor for the Builder with required parameters.
         * @param cpu The CPU for the computer.
         * @param ram The RAM for the computer.
         */
        public Builder(String cpu, String ram) {
            if (cpu == null || ram == null) {
                throw new IllegalArgumentException("CPU and RAM are required.");
            }
            this.cpu = cpu;
            this.ram = ram;
        }

        // Setter methods for optional parameters, returning 'this' for fluent interface.

        public Builder setStorage(String storage) {
            this.storage = storage;
            return this;
        }

        public Builder setGraphicsCard(String graphicsCard) {
            this.graphicsCard = graphicsCard;
            return this;
        }

        public Builder setOperatingSystem(String operatingSystem) {
            this.operatingSystem = operatingSystem;
            return this;
        }

        public Builder enableBluetooth(boolean hasBluetooth) {
            this.hasBluetooth = hasBluetooth;
            return this;
        }

        public Builder enableWiFi(boolean hasWiFi) {
            this.hasWiFi = hasWiFi;
            return this;
        }

        /**
         * The build method that constructs and returns the final Computer object.
         * It calls the private constructor of Computer, passing itself (the builder) as the argument.
         * @return A new Computer instance.
         */
        public Computer build() {
            return new Computer(this);
        }
    }
}
