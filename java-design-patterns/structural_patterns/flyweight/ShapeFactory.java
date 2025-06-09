package structural_patterns.flyweight;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

/**
 * FlyweightFactory: Responsible for creating and managing flyweight objects.
 * It maintains a pool of existing flyweights.
 */
public class ShapeFactory {
    // Pool of flyweights. Key is the intrinsic state (Color as a string for simplicity here).
    private static final Map<String, Shape> circleCache = new HashMap<>();

    /**
     * Gets a Circle flyweight. If a circle with the specified color already exists in the cache,
     * it returns the existing instance; otherwise, it creates a new one, stores it, and returns it.
     * @param colorName The name of the color (e.g., "Red", "Green", "Blue").
     * @return A Shape (Circle) flyweight.
     */
    public static Shape getCircle(String colorName) {
        String normalizedColorName = colorName.trim().toUpperCase();
        Shape circle = circleCache.get(normalizedColorName);

        if (circle == null) {
            // Convert color name string to actual Color object for intrinsic state
            Color actualColor;
            switch (normalizedColorName) {
                case "RED":
                    actualColor = Color.RED;
                    break;
                case "GREEN":
                    actualColor = Color.GREEN;
                    break;
                case "BLUE":
                    actualColor = Color.BLUE;
                    break;
                case "YELLOW":
                    actualColor = Color.YELLOW;
                    break;
                case "BLACK":
                    actualColor = Color.BLACK;
                    break;
                default:
                    System.out.println("ShapeFactory: Color " + colorName + " not recognized, defaulting to BLACK.");
                    actualColor = Color.BLACK;
                    // Update normalizedColorName if we default, to ensure cache key matches actualColor
                    normalizedColorName = "BLACK";
                    // Re-check cache for default color, in case it was already created
                    circle = circleCache.get(normalizedColorName);
                    if (circle != null) {
                        return circle;
                    }
            }

            // Create a new Circle flyweight with the intrinsic state (color)
            circle = new Circle(actualColor);
            // Store it in the cache
            circleCache.put(normalizedColorName, circle);
            System.out.println("ShapeFactory: Caching new Circle of color " + normalizedColorName + ".");
        } else {
            System.out.println("ShapeFactory: Reusing Circle of color " + normalizedColorName + " from cache.");
        }
        return circle;
    }

    /**
     * Gets the number of distinct flyweight objects created.
     * @return The size of the flyweight cache.
     */
    public static int getCacheSize() {
        return circleCache.size();
    }
}
