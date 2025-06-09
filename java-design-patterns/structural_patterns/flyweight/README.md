# Flyweight Pattern

The Flyweight pattern is a structural design pattern that aims to minimize memory usage by sharing as much data as possible with other similar objects. It is used when an application needs to create a large number of fine-grained objects that share common state, by separating intrinsic (shared) state from extrinsic (context-dependent) state.

## Purpose

*   **Minimize Memory Usage:** Reduce the memory footprint when an application needs to support a large number of similar, fine-grained objects.
*   **Share Common State:** Enable sharing of common parts of object state (intrinsic state) among multiple objects, while unique state (extrinsic state) is passed to methods by the client.
*   **Efficiently Support Large Numbers of Objects:** Make it feasible to use objects in large quantities when a simple repeated representation would be too memory-intensive.

## Use Cases

*   **Large Number of Similar Objects:** When an application creates a vast quantity of objects that are largely identical or share significant portions of their state.
*   **High Storage Costs:** When the memory cost of representing each object individually is prohibitively high.
*   **State Separation:** When most of an object's state can be made extrinsic (passed in by the client as parameters to methods) and only a small portion is intrinsic (can be shared).
*   **Identity Irrelevance:** When the application doesn't depend on the unique identity of each object. Since flyweights are shared, multiple conceptual objects might be represented by the same physical flyweight instance.
*   **Examples:**
    *   **Character Rendering in Text Editors:** Each character in a document might have a character code (intrinsic) but its position, font style, and size (extrinsic) can vary. Instead of creating an object for every single character displayed, flyweights for each character type are shared.
    *   **Graphical Objects:** Rendering thousands of similar shapes (lines, circles, icons) in a drawing program. The shape type or color might be intrinsic, while position and size are extrinsic.
    *   **Game Development:** Representing repeating elements like trees, bullets, or tiles in a game world.
    *   **Networked Applications:** Managing connections or user sessions where much of the session object's state can be shared.

## Pros

*   **Significant Memory Savings:** Drastically reduces the number of object instances required by the application, leading to lower memory consumption.
*   **Improved Performance (Potentially):** Fewer object instantiations can lead to faster startup and less garbage collection overhead. Processing shared objects might also be faster.
*   **Centralized Intrinsic State:** Manages the shared (intrinsic) state of many "virtual" objects within a few physical flyweight objects.

## Cons

*   **Increased Code Complexity:** The separation of intrinsic and extrinsic state can make the code more complex. Clients become responsible for managing and providing the extrinsic state to the flyweight's methods.
*   **Runtime Costs:** There might be a slight runtime cost associated with calculating or looking up extrinsic state each time a flyweight method is called.
*   **Clear State Distinction Needed:** The pattern relies on a clear and logical separation between what state is intrinsic (sharable) and what is extrinsic (contextual). This isn't always straightforward.
*   **Singletons for Flyweights:** Flyweight objects are often managed as singletons within the factory for each unique intrinsic state, which can introduce complexities if not handled carefully.

## Java Example Explanation

The Java example in this directory demonstrates the Flyweight pattern by rendering `Circle` shapes. The color of a circle is considered its intrinsic state (and thus shared), while its position (x, y) and radius are extrinsic states provided by the client.

*   **`Shape.java` (Flyweight Interface):**
    *   Defines the interface for flyweight objects.
    *   Declares the `draw(int x, int y, int radius, Graphics graphics)` method, which accepts extrinsic state (x, y, radius, and the graphics context) as parameters.

*   **`Circle.java` (ConcreteFlyweight Class):**
    *   Implements the `Shape` (Flyweight) interface.
    *   Stores the intrinsic state: `private final Color color;`. This is set via its constructor.
    *   The `draw()` method uses its intrinsic `color` and the extrinsic `x`, `y`, and `radius` parameters to render itself. For this console-based demo, it prints details to the console if the `Graphics` object is null.

*   **`ShapeFactory.java` (FlyweightFactory Class):**
    *   Responsible for creating and managing `Circle` flyweight objects.
    *   Maintains a cache (`HashMap<String, Shape>`) to store created flyweights. The key for the cache is derived from the intrinsic state (the color name).
    *   The static method `getCircle(String colorName)`:
        1.  Checks if a `Circle` flyweight with the specified color already exists in the cache.
        2.  If it exists, the cached instance is returned.
        3.  If not, a new `Circle` instance is created with the given color, stored in the cache, and then returned.
        4.  This ensures that for any given color, only one `Circle` object is ever created.

*   **`FlyweightDemo.java` (Client Class):**
    *   Simulates drawing a large number of circles with different colors, positions, and radii.
    *   It repeatedly calls `ShapeFactory.getCircle(colorName)` to obtain `Circle` flyweights.
    *   For each logical circle to be drawn, it provides the extrinsic state (randomly generated x, y, radius) to the `draw()` method of the obtained flyweight.
    *   The demo prints messages indicating when a new flyweight is created versus when an existing one is reused from the cache.
    *   Finally, it shows the total number of distinct flyweight objects created by the factory, which is much smaller than the total number of "logical" circles drawn, demonstrating the memory-saving aspect of the pattern.

This example illustrates how the Flyweight pattern allows an application to support a large number of objects (circles) efficiently by sharing common intrinsic state (color) and passing unique extrinsic state (position, radius) as needed.
