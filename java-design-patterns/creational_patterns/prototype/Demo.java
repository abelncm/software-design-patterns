package creational_patterns.prototype;

public class Demo {
    public static void main(String[] args) {
        System.out.println("--- Prototype Pattern Demo ---");

        // Load initial prototypes into the cache
        ShapeCache.loadCache();

        // Retrieve and use cloned shapes from the cache
        System.out.println("\nCloning shapes from cache:");

        Shape clonedCircle1 = ShapeCache.getShape("circle1");
        if (clonedCircle1 != null) {
            System.out.println("Cloned Shape (from cache): " + clonedCircle1.getType() + ", ID: " + clonedCircle1.getId() + ", Color: " + clonedCircle1.getColor());
            clonedCircle1.draw();
        }

        Shape clonedRectangle1 = ShapeCache.getShape("rect1");
        if (clonedRectangle1 != null) {
            System.out.println("Cloned Shape (from cache): " + clonedRectangle1.getType() + ", ID: " + clonedRectangle1.getId() + ", Color: " + clonedRectangle1.getColor());
            clonedRectangle1.draw();
        }

        Shape clonedCircle2Prototype = ShapeCache.getShape("circle2_prototype");
        if (clonedCircle2Prototype != null) {
            System.out.println("Cloned Shape (from cache): " + clonedCircle2Prototype.getType() + ", ID: " + clonedCircle2Prototype.getId() + ", Color: " + clonedCircle2Prototype.getColor());
            clonedCircle2Prototype.draw();
        }


        System.out.println("\n--- Modifying Cloned Objects ---");
        // Modify the cloned objects to show they are independent copies.
        // The Shape's copy constructor appends "_clone" to the ID, which already shows a change.

        if (clonedCircle1 != null) {
            clonedCircle1.setColor("Yellow"); // Change color of the clone
            ((Circle) clonedCircle1).setRadius(15); // Change radius of the clone (requires cast)
            System.out.println("\nModified Cloned Circle 1:");
            clonedCircle1.draw();

            // Get the original from cache again to show it's unchanged
            Shape originalCircle1FromCache = ShapeCache.getShape("circle1"); // This itself is a clone
            System.out.println("Original Circle 1 (fresh clone from cache) after modifying first clone:");
            if (originalCircle1FromCache != null) {
                 originalCircle1FromCache.draw(); // Should still be Red, radius 10
                 // Note: The ID of this "original" will also have "_clone" because getShape always clones.
                 // To truly compare with the object IN the cache, you'd need a direct getter (not typical for prototype pattern usage).
            }
        }

        System.out.println("\n--- Direct Cloning Example (without cache) ---");
        Rectangle originalRectangle = new Rectangle("rect_direct", 100, 50);
        originalRectangle.setColor("Purple");
        System.out.println("Original Direct Rectangle:");
        originalRectangle.draw();

        Rectangle clonedDirectRectangle = (Rectangle) originalRectangle.clone();
        System.out.println("Cloned Direct Rectangle (before modification):");
        clonedDirectRectangle.draw(); // ID will be "rect_direct_clone"

        clonedDirectRectangle.setColor("Orange");
        clonedDirectRectangle.setWidth(120);
        System.out.println("Cloned Direct Rectangle (after modification):");
        clonedDirectRectangle.draw();

        System.out.println("Original Direct Rectangle (after cloning and modifying clone - should be unchanged):");
        originalRectangle.draw(); // Should still be Purple, width 100


        System.out.println("\n--- Verifying object independence (hashCode and equals) ---");
        // Get another clone from the cache to represent the "original state" from cache perspective
        Shape originalCircle1FromCacheAgain = ShapeCache.getShape("circle1");
        if (clonedCircle1 != null && originalCircle1FromCacheAgain != null) {
            System.out.println("Is modified clonedCircle1 (" + clonedCircle1.getId() +") same object as a fresh clone from cache (" + originalCircle1FromCacheAgain.getId() + ")? " + (clonedCircle1 == originalCircle1FromCacheAgain)); // Should be false
            // Content comparison will also be false due to modifications (ID, color, radius)
            System.out.println("Is modified clonedCircle1 equal to a fresh clone from cache (content)? " + (clonedCircle1.equals(originalCircle1FromCacheAgain)));
        }

        if (originalRectangle != null && clonedDirectRectangle != null) {
             System.out.println("Is originalRectangle ("+originalRectangle.getId()+") same object as clonedDirectRectangle ("+clonedDirectRectangle.getId()+")? " + (originalRectangle == clonedDirectRectangle)); // Should be false
             // Content comparison will also be false due to modifications (ID, color, width)
             System.out.println("Is originalRectangle equal to clonedDirectRectangle (content)? " + (originalRectangle.equals(clonedDirectRectangle)));
        }


        System.out.println("\n--- Prototype Pattern Demo Finished ---");
    }
}
