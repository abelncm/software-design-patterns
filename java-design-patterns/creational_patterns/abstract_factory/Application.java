package creational_patterns.abstract_factory;

/**
 * Client: Uses interfaces declared by AbstractFactory and AbstractProduct classes.
 * The Application class is configured with a concrete factory and then uses it
 * to create UI elements without knowing their concrete types.
 */
public class Application {
    private Button button;
    private Checkbox checkbox;
    private GUIFactory factory;

    /**
     * Constructor for the Application.
     * It takes a GUIFactory to determine the family of UI elements to create.
     * @param factory A concrete factory (e.g., WindowsFactory, MacOSFactory).
     */
    public Application(GUIFactory factory) {
        this.factory = factory;
    }

    /**
     * Creates the UI elements using the provided factory.
     */
    public void createUI() {
        this.button = factory.createButton();
        this.checkbox = factory.createCheckbox();
    }

    /**
     * Simulates painting the button.
     */
    public void paintButton() {
        if (button != null) {
            button.paint();
        } else {
            System.out.println("Button not created yet.");
        }
    }

    /**
     * Simulates rendering the checkbox.
     */
    public void renderCheckbox() {
        if (checkbox != null) {
            checkbox.render();
        } else {
            System.out.println("Checkbox not created yet.");
        }
    }

    public static void main(String[] args) {
        System.out.println("--- Abstract Factory Demo ---");

        Application app;
        GUIFactory factory;
        String osName = System.getProperty("os.name", "generic").toLowerCase();

        // Determine which factory to use based on OS (simplified example)
        // In a real app, this might come from a config file or user setting.
        if (osName.contains("win")) {
            System.out.println("Detected Windows OS, using WindowsFactory.");
            factory = new WindowsFactory();
        } else if (osName.contains("mac")) {
            System.out.println("Detected MacOS, using MacOSFactory.");
            factory = new MacOSFactory();
        } else {
            // Default or for other OS (e.g., Linux) - let's default to Windows for this demo
            System.out.println("OS not specifically supported, defaulting to WindowsFactory for demo purposes.");
            factory = new WindowsFactory();
        }

        // Create the application with the chosen factory
        app = new Application(factory);
        app.createUI(); // Create the UI elements

        // Use the created UI elements
        System.out.println("\nUsing the created UI elements:");
        app.paintButton();
        app.renderCheckbox();

        System.out.println("\n--- Switching factory to demonstrate flexibility ---");
        // Demonstrate with MacOS factory explicitly
        System.out.println("Configuring with MacOSFactory...");
        factory = new MacOSFactory();
        app = new Application(factory);
        app.createUI();
        app.paintButton();
        app.renderCheckbox();

        System.out.println("\n--- Switching factory to WindowsFactory explicitly ---");
        // Demonstrate with Windows factory explicitly
        System.out.println("Configuring with WindowsFactory...");
        factory = new WindowsFactory();
        app = new Application(factory);
        app.createUI();
        app.paintButton();
        app.renderCheckbox();

        System.out.println("\n--- Abstract Factory Demo Finished ---");
    }
}
