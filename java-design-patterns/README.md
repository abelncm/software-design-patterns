# Java Design Pattern Examples

This repository provides practical Java implementations of common software design patterns. The goal is to offer clear and concise examples to help understand and apply these patterns effectively.

## Structure

The design patterns are categorized according to their intent:

*   **Creational Patterns:** Deal with object creation mechanisms, trying to create objects in a manner suitable to the situation.
*   **Structural Patterns (Planned):** Ease the design by identifying a simple way to realize relationships between entities.
*   **Behavioral Patterns (Planned):** Identify common communication patterns between objects and realize these patterns.

Each pattern is implemented in its own subdirectory within the respective category (e.g., `creational_patterns/Singleton/`).

## Implemented Creational Patterns

The following creational design patterns have been implemented:

*   **[Singleton](./creational_patterns/singleton/)**: Ensures a class only has one instance and provides a global point of access to it.
*   **[Factory Method](./creational_patterns/factory_method/)**: Defines an interface for creating an object, but lets subclasses decide which class to instantiate.
*   **[Abstract Factory](./creational_patterns/abstract_factory/)**: Provides an interface for creating families of related or dependent objects without specifying their concrete classes.
*   **[Builder](./creational_patterns/builder/)**: Separates the construction of a complex object from its representation so that the same construction process can create different representations.
*   **[Prototype](./creational_patterns/prototype/)**: Specifies the kinds of objects to create using a prototypical instance, and creates new objects by copying this prototype.

## How to Use

Navigate into each pattern's directory (linked above) to find:

*   **Java Source Code:** The `.java` files demonstrating the pattern.
*   **`README.md`:** A detailed explanation of the pattern, including its purpose, use cases, pros, cons, and a description of the specific Java example provided.

You can compile and run the `Demo.java` or similarly named main class within each pattern's directory to see the pattern in action. Typically, commands like `javac *.java` followed by `java <package_path>.Demo` (executed from the correct base directory) will work.

## Future Additions

Implementations for Structural and Behavioral patterns are planned and will be added in the future.

## Contributing

This collection aims to be a community resource. If you'd like to contribute, please refer to the main project's contribution guidelines (if available) or consider forking the repository, adding new patterns or improving existing ones, and submitting a pull request.
