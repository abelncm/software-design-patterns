package creational_patterns.singleton;

public class Singleton {

    // Private constructor to prevent instantiation from other classes.
    private Singleton() {
        // Optional: Add any initialization logic here.
        System.out.println("Singleton instance created.");
    }

    // Static inner helper class to hold the instance of the Singleton.
    // This class is not loaded into memory until getInstance() is called.
    private static class SingletonHelper {
        private static final Singleton INSTANCE = new Singleton();
    }

    // Public static method to get the instance of the Singleton class.
    // This method is globally accessible.
    public static Singleton getInstance() {
        return SingletonHelper.INSTANCE;
    }

    // Example method to demonstrate Singleton functionality.
    public void showMessage() {
        System.out.println("Hello from Singleton! Instance: " + this.hashCode());
    }
}
