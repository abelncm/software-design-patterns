package structural_patterns.flyweight;

// No AWT Graphics in a simple command-line demo, so we'll pass null.
// The Circle.draw() method is designed to handle a null Graphics object by printing to console.
// import java.awt.Graphics; // Only needed if we were in a GUI environment

/**
 * Client Class (Demo): Uses the FlyweightFactory to get flyweight objects (Shapes)
 * and then calls methods on them, passing the extrinsic state.
 */
public class FlyweightDemo {

    private static final String[] colors = {"Red", "Green", "Blue", "Yellow", "Black", "Red", "Blue"};
    private static final int NUM_CIRCLES_TO_DRAW = 15;

    public static void main(String[] args) {
        System.out.println("--- Flyweight Pattern Demo: Drawing Shapes ---");

        System.out.println("\nAttempting to draw " + NUM_CIRCLES_TO_DRAW + " circles with various colors, positions, and radii...");
        System.out.println("Note how Circle objects with the same color are shared (reused from cache).\n");

        for (int i = 0; i < NUM_CIRCLES_TO_DRAW; i++) {
            // Get a color randomly from the predefined list
            String color = getRandomColor();

            // Get a Circle flyweight from the factory based on its intrinsic state (color)
            Shape circle = ShapeFactory.getCircle(color);

            // Generate random extrinsic state (position and radius)
            int x = getRandomCoordinate();
            int y = getRandomCoordinate();
            int radius = getRandomRadius();

            // Call the draw method on the flyweight, passing extrinsic state.
            // We pass null for Graphics as this is a console demo.
            // The Circle.draw() method will print to console if Graphics is null.
            System.out.print("Client: Drawing logical circle " + (i + 1) + " -> ");
            circle.draw(x, y, radius, null);
        }

        System.out.println("\n--------------------------------------------------");
        System.out.println("Total number of distinct Circle flyweight objects created and cached: " + ShapeFactory.getCacheSize());
        System.out.println("Compare this to the " + NUM_CIRCLES_TO_DRAW + " 'logical' circles drawn.");
        System.out.println("--- Flyweight Pattern Demo Finished ---");
    }

    private static String getRandomColor() {
        return colors[(int) (Math.random() * colors.length)];
    }

    private static int getRandomCoordinate() {
        return (int) (Math.random() * 200); // Arbitrary range for x, y
    }

    private static int getRandomRadius() {
        return (int) (Math.random() * 50) + 5; // Radius between 5 and 54
    }
}
