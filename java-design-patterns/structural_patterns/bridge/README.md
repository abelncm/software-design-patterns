# Bridge Pattern

The Bridge pattern is a structural design pattern that decouples an abstraction from its implementation so that the two can vary independently. This is achieved by creating two separate hierarchies: one for abstractions and one for implementations, and then "bridging" them together.

## Purpose

*   **Decouple Abstraction and Implementation:** Allow an abstraction and its implementation to be developed and modified independently of each other.
*   **Independent Variation:** Enable changes in the abstraction without affecting the implementation, and vice-versa.
*   **Runtime Binding (Optional):** Facilitate the selection or switching of implementations at runtime.

## Use Cases

*   **Independent Hierarchies:** When you have both abstractions and their implementations that can evolve independently. For example, graphical user interface (GUI) frameworks might have window abstractions that need to work across different operating system implementations (Windowing APIs).
*   **Runtime Implementation Choice:** When the specific implementation details are not known at compile time and need to be chosen or switched at runtime.
*   **Shared Implementation, Multiple Abstractions:** When multiple abstractions need to use a shared implementation, but possibly in different ways.
*   **Avoiding Proliferation of Classes:** When you would otherwise have a large number of subclasses resulting from combining all possible variations of an abstraction and its implementation (e.g., `RedCircle`, `BlueCircle`, `RedSquare`, `BlueSquare`). The Bridge pattern avoids this by creating two smaller hierarchies.
*   **Example: Shapes and Drawing APIs/Colors:** A `Shape` abstraction (like Circle, Square) needs to be drawn. The drawing mechanism itself (the "implementation") could be different drawing APIs (like Windows API, Linux API) or different rendering attributes like colors. The type of shape and the way it's drawn (its color or drawing API) can vary independently.

## Pros

*   **Decoupling:** Achieves complete decoupling between the interface (Abstraction) and its implementation (Implementor).
*   **Improved Extensibility:** You can extend the Abstraction hierarchy and the Implementor hierarchy independently without affecting each other. This adheres to the Open/Closed Principle.
*   **Hides Implementation Details:** Clients interact with the Abstraction and are unaware of the specific Implementor being used.
*   **Reduced Class Explosion:** Avoids a combinatorial explosion of classes that would occur if trying to combine all variations through inheritance.
*   **Flexibility:** Allows for changing the implementation (e.g., `Color` or `DrawingAPI`) at runtime if the Abstraction provides a mechanism to do so (e.g., a `setColor()` method).

## Cons

*   **Increased Complexity:** Introduces more classes and objects (Abstraction, RefinedAbstractions, Implementor, ConcreteImplementors), which can increase the initial complexity of the system.
*   **One-to-One Mapping:** The pattern is most effective when there's a clear one-to-one mapping between an Abstraction and an Implementor at a conceptual level, even if they vary independently. If the relationship is more complex, the bridge might become cumbersome.
*   **Design Overhead:** Can be harder to understand and design correctly compared to simpler patterns if the problem doesn't clearly fit the two-sided hierarchy model.

## Java Example Explanation

The Java example in this directory demonstrates the Bridge pattern by decoupling `Shape` abstractions from `Color` implementations. A shape can be drawn with various colors, and new shapes or new colors can be added independently.

*   **`Color.java` (Implementor Interface):**
    *   Defines the interface for the implementation part. In this case, it's for applying a color.
    *   Declares the `applyColor()` method.

*   **`RedColor.java`, `GreenColor.java` (ConcreteImplementors):**
    *   Implement the `Color` interface, providing concrete color application logic.
    *   `RedColor.applyColor()` returns "Red".
    *   `GreenColor.applyColor()` returns "Green".

*   **`Shape.java` (Abstract Abstraction):**
    *   Defines the high-level control interface for shapes.
    *   It holds a reference to a `Color` (Implementor) object, passed via its constructor.
    *   Declares an abstract `draw()` method, which will be implemented by refined abstractions.
    *   May include other common operations like `resize(double factor)`, which also utilize the implementor.

*   **`Circle.java`, `Square.java` (RefinedAbstractions):**
    *   Extend the `Shape` abstraction.
    *   They implement the `draw()` method, delegating the color-specific part to the `Color` implementor (e.g., "Drawing Circle... Color: " + `color.applyColor()`).
    *   They can also override or add other methods specific to their type (e.g., `Circle` has a `radius`, `Square` has a `side`).

*   **`BridgeDemo.java` (Demo Class):**
    *   Shows how to use the Bridge pattern:
        1.  Creates instances of `ConcreteImplementor`s (`RedColor`, `GreenColor`).
        2.  Creates instances of `RefinedAbstraction`s (`Circle`, `Square`), "bridging" them with a specific `Color` instance at construction time.
        3.  Calls methods like `draw()` and `resize()` on these shape objects. The output demonstrates that the shape's operation (e.g., drawing or resizing message) correctly incorporates the behavior of its associated `Color` implementor.
        4.  Illustrates that to change the implementor for a conceptual abstraction (e.g., draw a red circle as green), a new abstraction instance is created with the new implementor, showcasing the decoupling.

This example highlights how the `Shape` (Abstraction) can evolve independently from the `Color` (Implementor). We could add new shapes without changing color code, or add new colors without changing shape code.
