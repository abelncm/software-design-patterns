# Decorator Pattern

The Decorator pattern is a structural design pattern that allows behavior to be added to an individual object, either statically or dynamically, without affecting the behavior of other objects from the same class. It involves a set of decorator classes that are used to wrap concrete components.

## Purpose

*   **Attach Additional Responsibilities Dynamically:** Add new functionalities to objects at runtime by wrapping them with decorator objects.
*   **Flexible Alternative to Subclassing:** Provide a way to extend functionality without resorting to creating numerous subclasses. Subclassing adds behavior at compile time, and the change affects all instances of the original class; decorators can add behavior to individual objects at runtime.
*   **Transparent Enclosure:** Decorators conform to the interface of the component they decorate, so clients can treat decorated and undecorated objects uniformly.

## Use Cases

*   **Adding Responsibilities Dynamically:** When you want to add features to objects dynamically and transparently, without affecting other objects of the same class.
*   **Withdrawable Responsibilities:** When the added responsibilities can be removed or changed.
*   **Impractical Subclassing:** When extending functionality through subclassing is impractical due to:
    *   A large number of independent extensions needed (leading to a class explosion).
    *   A class definition being hidden or otherwise unavailable for subclassing (e.g., third-party or final classes).
*   **Examples:**
    *   **Coffee Shop:** Adding toppings or condiments (milk, sugar, whipped cream, sprinkles) to a basic coffee. Each addition modifies the description and cost.
    *   **GUI Toolkits:** Adding borders, scrollability, or other visual enhancements to UI components like text views or windows.
    *   **Java I/O Streams:** `java.io.InputStream`, `OutputStream`, `Reader`, and `Writer` classes are classic examples. A `FileInputStream` can be wrapped by a `BufferedInputStream` for buffering, which can then be wrapped by a `DataInputStream` for reading primitive data types.

## Pros

*   **Flexibility over Static Inheritance:** Responsibilities can be added to and removed from objects at runtime, offering more flexibility than subclassing.
*   **Avoids Feature-Bloated Superclasses:** Functionality is added by composing objects with decorators, rather than trying to include all possible features in a single complex class high up the hierarchy.
*   **Combinable Functionality:** Decorators can be combined in various ways to achieve complex behaviors. For instance, a coffee can be decorated with milk, then sugar, then whipped cream.
*   **Single Responsibility Principle:** Each decorator class is focused on a single aspect or responsibility it adds to the component.

## Cons

*   **Many Small Objects:** Can lead to a system with a lot of small, similar-looking objects (the decorators), which can be hard to manage or understand if overused or if the decoration chain becomes very long.
*   **Decorator and Component Not Identical:** While decorators conform to the component's interface, they are not the same type as the underlying component. `instanceof` checks for the concrete component type will fail if you are holding a reference to a decorator. This means client code should generally rely only on the component interface.
*   **Complexity in Configuration:** Setting up the initial chain of decorators for a specific component can sometimes be complex for the client.
*   **Order of Decoration Matters:** The order in which decorators are applied can be significant, which might not always be intuitive.

## Java Example Explanation

The Java example in this directory demonstrates the Decorator pattern using a coffee ordering system where different condiments can be added to a basic coffee.

*   **`Coffee.java` (Component Interface):**
    *   Defines the common interface for all coffee objects, whether simple or decorated.
    *   Declares methods `getCost()` and `getDescription()`.

*   **`SimpleCoffee.java` (ConcreteComponent):**
    *   Represents a basic, unadorned coffee. It implements the `Coffee` interface.
    *   `getCost()` returns the base price of a simple coffee.
    *   `getDescription()` returns "Simple Coffee".

*   **`CoffeeDecorator.java` (Abstract Decorator):**
    *   An abstract class that also implements the `Coffee` interface.
    *   It holds a reference to a `Coffee` object (the `decoratedCoffee`), which is the component it wraps. This reference is initialized via the constructor.
    *   It delegates calls to `getCost()` and `getDescription()` to the `decoratedCoffee` by default. Concrete decorators will override these methods to add their specific behavior.

*   **`MilkDecorator.java`, `SugarDecorator.java` (ConcreteDecorators):**
    *   Extend `CoffeeDecorator`.
    *   Each concrete decorator adds a specific condiment:
        *   `MilkDecorator`: Adds the cost of milk to `super.getCost()` and appends ", Milk" to `super.getDescription()`.
        *   `SugarDecorator`: Adds the cost of sugar to `super.getCost()` and appends ", Sugar" to `super.getDescription()`.

*   **`DecoratorDemo.java` (Demo Class):**
    *   Illustrates how to use the decorators:
        1.  A `SimpleCoffee` object is created.
        2.  To get a coffee with milk, the `SimpleCoffee` object is wrapped with a `MilkDecorator`.
        3.  To get a coffee with milk and sugar, the `MilkDecorator` (which already wraps `SimpleCoffee`) is further wrapped with a `SugarDecorator`.
        4.  The demo shows how the `getCost()` and `getDescription()` methods are called on the outermost decorator, and these calls are then delegated down the chain, with each decorator adding its contribution.
        5.  It also demonstrates stacking multiple decorators (e.g., double milk).

This example shows how the Decorator pattern allows for dynamically adding responsibilities (condiments) to a `Coffee` object without altering its class structure, providing a flexible way to create various coffee combinations.
