# Builder Pattern

The Builder pattern is a creational design pattern that separates the construction of a complex object from its representation, allowing the same construction process to create different representations. It's particularly useful for objects with many optional parameters or complex setup logic.

## Purpose

*   **Separate Complex Object Construction:** Decouple the step-by-step construction of a complex object from its actual representation.
*   **Allow Different Representations:** Enable the same construction process to produce various forms or configurations of the object.
*   **Control Construction Process:** Provide fine-grained control over how an object is built.
*   **Improve Readability and Reduce Errors:** Avoid "telescopic constructors" (constructors with a long list of parameters, many of which might be optional) and make object creation more understandable and less error-prone.

## Use Cases

*   **Objects with Many Optional Parameters:** When creating an object that has several optional attributes, using a builder makes the instantiation cleaner than having numerous constructors or setter methods.
    *   Example: Building a `Computer` with required CPU and RAM, but optional storage, graphics card, OS, Bluetooth, WiFi, etc.
*   **Complex Object Creation Logic:** When the creation of an object involves multiple steps or requires a specific order of assembly.
*   **Immutable Objects:** Builders are excellent for creating immutable objects because all the necessary information is gathered by the builder before the object itself is constructed via a private constructor.
*   **Creating Different Representations of an Object:** When the construction process can result in different versions or configurations of the product.
    *   Example: A `PizzaBuilder` that can create a `SpicyPizza`, `VeggiePizza`, or `MeatLoversPizza` using the same overall building steps but different ingredients.
*   **Fluent APIs:** The builder pattern is often used to create fluent interfaces, where method calls are chained together to configure the object.
    *   Example: `StringBuilder` in Java (`sb.append("a").append("b").toString();`).
*   **Query Builders:** Constructing complex database queries (e.g., SQL query builders).

## Pros

*   **Improved Readability:** Object creation is more readable as builder methods are named and self-explanatory (e.g., `setStorage("1TB SSD")` instead of a boolean or null in a long constructor parameter list).
*   **Avoids Telescopic Constructors:** Eliminates the need for multiple constructors with different parameter sets.
*   **Parameter Flexibility:** Makes it easy to handle optional parameters; only set what's needed.
*   **Step-by-Step Construction:** Allows for controlled, step-by-step creation of an object. The object is only returned when it's fully constructed via the `build()` method.
*   **Encapsulation:** The internal representation of how the product is assembled is hidden from the client.
*   **Immutability:** Facilitates the creation of immutable objects by collecting all attributes before passing them to a private constructor of the product.

## Cons

*   **Increased Code:** Requires writing a separate Builder class (or a static nested class), which adds more code compared to direct instantiation, especially for simple objects.
*   **Verbosity for Simple Objects:** For objects with few parameters, the builder pattern might feel overly verbose.
*   **Potential for Builder Complexity:** If the builder itself becomes too complex, it might become hard to manage.

## Java Example Explanation

The Java example in this directory demonstrates the Builder pattern using a static nested `Builder` class within the `Computer` product class. This is a common and idiomatic way to implement the Builder pattern in Java.

*   **`Computer.java` (Product):**
    *   This is the complex object we want to build. It has required attributes (`cpu`, `ram`) and several optional attributes (`storage`, `graphicsCard`, `operatingSystem`, `hasBluetooth`, `hasWiFi`).
    *   Its constructor `private Computer(Builder builder)` is private, meaning `Computer` objects can only be created via the `Builder`. It takes the `Builder` instance and copies the values.
    *   Includes a `toString()` method for easy display of the computer's configuration.

*   **`Computer.Builder` (Static Nested Builder / ConcreteBuilder):**
    *   This static nested class is responsible for constructing a `Computer` object.
    *   It has fields that mirror the `Computer`'s attributes. Required fields (`cpu`, `ram`) are set through its constructor.
    *   It provides fluent setter methods for optional attributes (e.g., `setStorage(String storage)`). Each of these methods returns the `Builder` instance (`this`), allowing for method chaining (e.g., `new Computer.Builder("i7", "16GB").setStorage("512GB SSD").setGraphicsCard("RTX 3070").build()`).
    *   The `build()` method calls the private `Computer` constructor, passing itself (`this` builder instance) to it, and returns the fully constructed `Computer` object.

*   **`Demo.java` (Client/Demo):**
    *   Shows how to use the `Computer.Builder` to create different `Computer` configurations:
        *   A basic computer with only required parts (and defaults for optionals like OS).
        *   A high-end gaming computer with many optional parts specified.
        *   An office computer with a different set of optional parts.
    *   It also demonstrates the enforcement of required parameters by catching an `IllegalArgumentException` when trying to build a computer without CPU and RAM.
    *   This client code acts as the "Director" in this setup, as it dictates the construction steps by calling the appropriate builder methods.

This example highlights the flexibility and readability benefits of the Builder pattern, especially for creating objects with multiple optional parameters. The fluent interface provided by the static nested builder makes the construction process clear and intuitive.
