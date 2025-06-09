package structural_patterns.bridge;

/**
 * RefinedAbstraction A: Extends the Shape abstraction and implements its methods,
 * possibly adding more specific logic but still delegating the core
 * implementation work related to the Implementor (Color).
 */
public class Circle extends Shape {

    private double radius;

    /**
     * Constructor for Circle.
     * @param color The Color implementor.
     * @param radius The radius of the circle.
     */
    public Circle(Color color, double radius) {
        super(color); // Pass the implementor to the superclass constructor
        this.radius = radius;
    }

    /**
     * Implements the draw method for a Circle.
     * It uses the Color implementor to specify the color aspect of drawing.
     * @return A string describing the drawing operation.
     */
    @Override
    public String draw() {
        return "Drawing Circle with radius " + radius + ". Color: " + color.applyColor() + ".";
    }

    // Optionally, override resize or add other Circle-specific methods
    @Override
    public void resize(double factor) {
        this.radius *= factor;
        System.out.println("Circle resized. New radius: " + this.radius + ". Color: " + color.applyColor() + ".");
    }

    public double getRadius() {
        return radius;
    }
}
