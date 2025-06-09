package structural_patterns.bridge;

/**
 * Demo Class: To demonstrate the use of the Bridge pattern.
 * It shows how Abstractions (Shapes) can work with different Implementors (Colors) independently.
 */
public class BridgeDemo {
    public static void main(String[] args) {
        System.out.println("--- Bridge Pattern Demo ---");

        // Create ConcreteImplementor objects
        Color red = new RedColor();
        Color green = new GreenColor();

        // Create a Red Circle
        System.out.println("\nCreating a Red Circle:");
        Shape redCircle = new Circle(red, 10.0);
        System.out.println(redCircle.draw());
        redCircle.resize(2.0); // New radius should be 20.0

        // Create a Green Circle
        System.out.println("\nCreating a Green Circle:");
        Shape greenCircle = new Circle(green, 5.0);
        System.out.println(greenCircle.draw());
        greenCircle.resize(1.5); // New radius should be 7.5

        // Create a Red Square
        System.out.println("\nCreating a Red Square:");
        Shape redSquare = new Square(red, 7.0);
        System.out.println(redSquare.draw());
        redSquare.resize(0.5); // New side should be 3.5

        // Create a Green Square
        System.out.println("\nCreating a Green Square:");
        Shape greenSquare = new Square(green, 12.0);
        System.out.println(greenSquare.draw());
        greenSquare.resize(3.0); // New side should be 36.0

        System.out.println("\n--- Verifying independent change of implementor ---");
        // We can change the implementor (Color) for an existing abstraction if the abstraction allows it.
        // Our current Shape abstract class takes Color in constructor and doesn't have a setter,
        // so to change color, we'd typically create a new Shape object with the new Color.
        // If Shape had a setColor(Color color) method, we could change it dynamically.
        // For this demo, we'll show creating a new shape with a different color.

        System.out.println("Original redCircle details: " + redCircle.draw());
        // Let's say we want to draw the same conceptual circle (same radius) but in Green
        Circle originallyRedCircleNowGreen = new Circle(green, ((Circle)redCircle).getRadius());
        System.out.println("Same circle, but now with Green color: " + originallyRedCircleNowGreen.draw());


        System.out.println("\n--- Bridge Pattern Demo Finished ---");
    }
}
