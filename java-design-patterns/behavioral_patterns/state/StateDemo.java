package behavioral_patterns.state;

/**
 * Client Class (Demo): Creates a Context object (PackageContext) and
 * then invokes methods on it, which causes state transitions and
 * changes in behavior as defined by the current state.
 */
public class StateDemo {
    public static void main(String[] args) {
        System.out.println("--- State Pattern Demo: Package Delivery ---");

        // 1. Create a Context object (Package)
        PackageContext myPackage = new PackageContext("PKG12345");
        myPackage.printCurrentStatus(); // Should be Ordered

        // 2. Trigger actions that cause state transitions
        // Action: Order placed, proceed to ship
        myPackage.proceedToNextStatus(); // From Ordered -> Shipped
        // myPackage.printCurrentStatus(); // Already printed by proceedToNextStatus

        // Action: Package shipped, proceed to deliver
        myPackage.proceedToNextStatus(); // From Shipped -> Delivered
        // myPackage.printCurrentStatus();

        // Action: Package delivered, attempt further action
        myPackage.proceedToNextStatus(); // From Delivered -> No further state change (as per DeliveredState logic)
        // myPackage.printCurrentStatus();

        System.out.println("\n--- Trying with another package to show independent states ---");
        PackageContext anotherPackage = new PackageContext("PKG98765");
        anotherPackage.printCurrentStatus(); // Should be Ordered

        anotherPackage.proceedToNextStatus(); // Ordered -> Shipped
        // At this point, myPackage is Delivered, anotherPackage is Shipped.
        System.out.println("\nStatus Check:");
        System.out.print("  "); myPackage.printCurrentStatus();
        System.out.print("  "); anotherPackage.printCurrentStatus();


        System.out.println("\n--- State Pattern Demo Finished ---");
    }
}
