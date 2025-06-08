package creational_patterns.prototype;

import java.util.Hashtable;

/**
 * PrototypeRegistry: Manages a collection of pre-built, ready-to-clone prototype instances.
 * In this case, it's a cache for Shape objects.
 */
public class ShapeCache {

    // Using Hashtable for thread-safety, though HashMap could be used if not needed.
    private static Hashtable<String, Shape> shapeMap = new Hashtable<>();

    /**
     * Retrieves a clone of a shape from the cache.
     * @param shapeId The ID of the shape to retrieve and clone.
     * @return A clone of the Shape object.
     */
    public static Shape getShape(String shapeId) {
        Shape cachedShape = shapeMap.get(shapeId);
        if (cachedShape != null) {
            // Clone the cached shape and return the clone
            // The clone() method in Shape and its subclasses should handle deep/shallow copy as needed.
            return (Shape) cachedShape.clone();
        }
        return null; // Or throw an exception if the shapeId is not found
    }

    /**
     * Loads initial prototypes into the cache.
     * This would typically be done once, perhaps at application startup.
     */
    public static void loadCache() {
        System.out.println("Loading initial shapes into cache...");

        Circle circle1 = new Circle("circle1", 10);
        circle1.setColor("Red");
        shapeMap.put(circle1.getId(), circle1);

        Rectangle rectangle1 = new Rectangle("rect1", 20, 30);
        rectangle1.setColor("Blue");
        shapeMap.put(rectangle1.getId(), rectangle1);

        Circle circle2 = new Circle("circle2_prototype", 5); // A different circle prototype
        circle2.setColor("Green");
        shapeMap.put(circle2.getId(), circle2);

        System.out.println("Cache loaded with: " + shapeMap.keySet());
        System.out.println("------------------------------------");
    }

    /**
     * Adds a shape to the cache.
     * This allows adding new prototypes dynamically if needed.
     * @param shape The shape to add to the cache.
     */
    public static void addShape(Shape shape) {
        if (shape != null && shape.getId() != null) {
            shapeMap.put(shape.getId(), shape);
            System.out.println("Added shape to cache: " + shape.getId() + " of type " + shape.getType());
        }
    }
}
