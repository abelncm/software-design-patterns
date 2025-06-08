package creational_patterns.singleton;

public class Demo {
    public static void main(String[] args) {
        // Get the Singleton instance
        Singleton instance1 = Singleton.getInstance();
        instance1.showMessage();

        // Get the Singleton instance again
        Singleton instance2 = Singleton.getInstance();
        instance2.showMessage();

        // Verify that both instances are the same
        if (instance1 == instance2) {
            System.out.println("Both instance1 and instance2 are the same instance. Singleton confirmed!");
        } else {
            System.out.println("Different instances were created. Singleton pattern failed!");
        }

        System.out.println("Hash code of instance1: " + instance1.hashCode());
        System.out.println("Hash code of instance2: " + instance2.hashCode());
    }
}
