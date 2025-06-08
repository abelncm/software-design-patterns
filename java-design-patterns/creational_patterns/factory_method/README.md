# Factory Method Pattern

The Factory Method is a creational design pattern that provides an interface for creating objects in a superclass, but allows subclasses to alter the type of objects that will be created.

## Purpose

*   Define an interface for creating an object, but let subclasses decide which class to instantiate.
*   Factory Method lets a class defer instantiation to subclasses.

## Use Cases

*   **When a class cannot anticipate the class of objects it must create:** If a class creates objects but the exact type of object might vary and is not known beforehand (e.g., determined by configuration or user input at runtime).
*   **When a class wants its subclasses to specify the objects it creates:** This allows subclasses to provide their own implementation of an object. For example, a framework can provide a generic creator class, and users can create subclasses to produce specific product variants.
*   **When you want to provide users of your library or framework with a way to extend its internal components:** Users can subclass your creator class and override the factory method to produce their custom product types that still work with the rest of your library/framework.
*   **Example: Document Editing Application:** A generic `Application` class (Creator) needs to create different types of `Document`s (Products like Word, PDF, Text). The specific document type to be created is determined by subclasses like `WordApplication` or `PdfApplication` (ConcreteCreators), each overriding the factory method to produce `WordDocument` or `PdfDocument` respectively.

## Pros

*   **Avoids Tight Coupling:** The creator (e.g., `DocumentCreator`) is decoupled from concrete products (e.g., `WordDocument`, `PdfDocument`). The creator only needs to know the product interface (`Document`), not the specific implementations.
*   **Promotes Single Responsibility Principle:** Product creation logic is centralized in the factory method within each concrete creator, making the code cleaner and easier to maintain. The creator class itself is not burdened with the instantiation logic of all product variants.
*   **Promotes Open/Closed Principle:** You can introduce new types of products without modifying existing creator code. You simply add new `ConcreteProduct` classes and corresponding `ConcreteCreator` subclasses. The original creator class can remain unchanged.

## Cons

*   **Increased Number of Classes:** The pattern can lead to a proliferation of classes, as a new `ConcreteCreator` subclass is typically needed for each `ConcreteProduct`. This can make the overall design more complex if there are many product types.

## Java Example Explanation

The Java example in this directory demonstrates the Factory Method pattern for creating different types of documents:

*   **`Document.java` (Product Interface):**
    *   Defines the common interface for all document types (e.g., `WordDocument`, `PdfDocument`).
    *   Declares methods like `open()`, `close()`, `save()`, and `getName()`.

*   **`WordDocument.java`, `PdfDocument.java` (ConcreteProducts):**
    *   Implement the `Document` interface, providing specific behavior for Word and PDF documents respectively.

*   **`DocumentCreator.java` (Abstract Creator):**
    *   Declares the abstract factory method `createDocument(String name)` which subclasses must implement to produce a `Document`.
    *   May contain common logic or methods that use the product created by the factory method (e.g., `newDocument()`, `openDocument()`). This shows how the creator relies on its subclasses to define the actual product.

*   **`WordDocumentCreator.java`, `PdfDocumentCreator.java` (ConcreteCreators):**
    *   Extend `DocumentCreator`.
    *   Each overrides the `createDocument(String name)` factory method to return a specific concrete product instance (e.g., `WordDocumentCreator` returns a `WordDocument`).

*   **`Demo.java` (Client/Demo):**
    *   Shows how to use the pattern.
    *   It instantiates `ConcreteCreator`s (`WordDocumentCreator`, `PdfDocumentCreator`).
    *   It then calls the factory method (either directly or indirectly via methods like `newDocument` in the `DocumentCreator`) on these creators to get `Document` objects.
    *   The client code operates on the `Document` interface, unaware of the concrete types being instantiated, demonstrating the decoupling achieved by the pattern. The choice of which document type to create is delegated to the specific creator subclass.

This example illustrates how the `DocumentCreator` defers the responsibility of instantiating a `Document` to its subclasses (`WordDocumentCreator`, `PdfDocumentCreator`), allowing the system to be easily extended with new document types without changing the `DocumentCreator`'s core logic.
