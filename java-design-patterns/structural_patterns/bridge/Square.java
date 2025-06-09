package structural_patterns.bridge;

/**
 * RefinedAbstraction B: Extends the Shape abstraction for a Square.
 */
public class Square extends Shape {

    private double side;

    /**
     * Constructor for Square.
     * @param color The Color implementor.
     * @param side The side length of the square.
     */
    public Square(Color color, double side) {
        super(color);
        this.side = side;
    }

    /**
     * Implements the draw method for a Square.
     * It uses the Color implementor.
     * @return A string describing the drawing operation.
     */
    @Override
    public String draw() {
        return "Drawing Square with side " + side + ". Color: " + color.applyColor() + ".";
    }

    @Override
    public void resize(double factor) {
        this.side *= factor;
        System.out.println("Square resized. New side: " + this.side + ". Color: " + color.applyColor() + ".");
    }

    public double getSide() {
        return side;
    }
}
