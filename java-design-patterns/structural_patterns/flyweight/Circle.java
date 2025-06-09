package structural_patterns.flyweight;

import java.awt.Color; // For color
import java.awt.Graphics; // For drawing

/**
 * ConcreteFlyweight: Implements the Flyweight interface (Shape) and stores intrinsic state.
 * Intrinsic state is shared, context-independent data (e.g., the color of the circle).
 * Extrinsic state (position, radius) is passed to methods like draw().
 */
public class Circle implements Shape {
    // Intrinsic state: shared among many "virtual" circles
    private final Color color; // The color of the circle is intrinsic

    /**
     * Constructor for Circle.
     * @param color The intrinsic color of this circle flyweight.
     */
    public Circle(Color color) {
        this.color = color;
        System.out.println("Creating Circle flyweight with color: " + color);
        // Simulate some resource-intensive creation for this flyweight
        try {
            Thread.sleep(50); // Small delay to simulate expensive creation
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    /**
     * Draws the circle using its intrinsic color and the provided extrinsic state.
     * @param x The x-coordinate (extrinsic).
     * @param y The y-coordinate (extrinsic).
     * @param radius The radius (extrinsic).
     * @param g The graphics context (extrinsic/environment).
     */
    @Override
    public void draw(int x, int y, int radius, Graphics g) {
        if (g == null) {
            // In a real application, you'd have a proper graphics context.
            // For this console demo, we'll just print if Graphics is null.
            System.out.println("Drawing Circle [Color: " + color +
                               ", X: " + x + ", Y: " + y + ", Radius: " + radius + "] (No Graphics context)");
            return;
        }

        // Set the color (intrinsic state)
        g.setColor(this.color);
        // Draw the circle (oval for circle) using extrinsic state
        g.fillOval(x - radius, y - radius, 2 * radius, 2 * radius);

        // For console output in demo when Graphics context is real but not visible
        System.out.println("Graphics: Drawing Circle [Color: " + this.color.toString() +
                           ", X: " + x + ", Y: " + y + ", Radius: " + radius + "]");
    }

    public Color getColor() {
        return color;
    }
}
