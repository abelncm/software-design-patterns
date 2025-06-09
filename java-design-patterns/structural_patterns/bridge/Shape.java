package structural_patterns.bridge;

/**
 * Abstraction: Defines the abstraction's interface and maintains a reference
 * to an object of type Implementor (Color).
 * It delegates the actual work to the Implementor.
 */
public abstract class Shape {
    // Reference to the Implementor interface
    protected Color color;

    /**
     * Constructor that accepts an Implementor (Color).
     * @param color The Color implementor.
     */
    public Shape(Color color) {
        if (color == null) {
            throw new IllegalArgumentException("Color implementor cannot be null.");
        }
        this.color = color;
    }

    /**
     * Abstract method for drawing the shape.
     * RefinedAbstractions will implement this.
     * It will typically use the Implementor (color) in its implementation.
     */
    public abstract String draw();

    /**
     * An example of another operation that the abstraction might have.
     * This can also be extended by refined abstractions.
     * @param factor The factor by which to resize.
     */
    public void resize(double factor) {
        System.out.println(this.getClass().getSimpleName() + " resized by a factor of " + factor + " with " + color.applyColor() + " color.");
    }

    // Getter for the color implementor, might be useful for some operations or testing
    public Color getColorImplementor() {
        return color;
    }
}
