# Composite Pattern

The Composite pattern is a structural design pattern that allows you to compose objects into tree structures to represent part-whole hierarchies. It lets clients treat individual objects (leaves) and compositions of objects (composites) uniformly.

## Purpose

*   **Represent Part-Whole Hierarchies:** Structure objects into a tree where nodes can be either individual items (leaves) or collections of items (composites).
*   **Uniform Treatment:** Enable clients to interact with individual objects and compositions in the same way through a common interface. This simplifies client code, as it doesn't need to distinguish between simple and complex components.

## Use Cases

*   **Hierarchical Structures:** Ideal for representing any system that has a hierarchical structure.
    *   **File Systems:** Directories can contain files or other directories. An operation like calculating size or listing contents can be applied to both.
    *   **GUI Toolkits:** UI elements are often composed. A window might contain panels, which in turn can contain buttons, text fields, or other panels. Operations like drawing or handling events can be applied uniformly.
    *   **Organizational Structures:** An organization consists of departments, which can have sub-departments or individual employees.
    *   **Graphics Applications:** Complex drawings can be built from simple shapes (lines, circles) and compound shapes (groups of simple or other compound shapes).
*   **Operations on Tree Structures:** When you need to perform operations on all elements of a tree structure, such as searching, summing, or displaying.

## Pros

*   **Simplified Client Code:** Clients can treat both individual (leaf) objects and composite objects uniformly through the common component interface. This makes client code simpler and easier to manage.
*   **Ease of Adding New Components:** New types of leaf or composite components can be added easily by implementing the component interface. Existing client code generally doesn't need to change.
*   **Flexible Structure:** Provides a highly flexible structure for representing complex part-whole hierarchies.
*   **Recursive Operations:** Operations on the composite can easily recurse down to its children, simplifying tasks like calculating sums, traversing, or displaying the hierarchy.

## Cons

*   **Overly General Design:** Sometimes the desire for uniformity can make the component interface too general. Leaf classes might be forced to implement methods (e.g., `add`, `remove` for child management) that don't make sense for them. These methods might be implemented to do nothing or throw an `UnsupportedOperationException`.
*   **Restricting Component Types:** It can be difficult to restrict the types of components that can be added to a composite if the component interface is very generic. Type checking might be needed at runtime.
*   **Complexity of Child Management:** The logic for managing children in the composite class can sometimes become complex, especially if there are constraints on the types or number of children.

## Java Example Explanation

The Java example in this directory demonstrates the Composite pattern by modeling a simple file system.

*   **`FileSystemComponent.java` (Component Interface):**
    *   Defines the common interface for all objects in the file system hierarchy.
    *   Declares methods like `getName()`, `getSize()`, and `displayDetails(String indent)`.
    *   This interface allows clients to treat both `File` (leaf) and `Directory` (composite) objects uniformly.

*   **`File.java` (Leaf Class):**
    *   Represents an individual file. It implements the `FileSystemComponent` interface.
    *   `getSize()` returns the size of the file.
    *   `displayDetails()` prints the file's name and size.
    *   As a leaf, it does not contain other components, so child management methods (if they were part of the interface) would typically be no-ops or throw exceptions.

*   **`Directory.java` (Composite Class):**
    *   Represents a directory that can contain other `FileSystemComponent`s (files or other directories). It also implements the `FileSystemComponent` interface.
    *   Maintains a `List<FileSystemComponent>` to store its children.
    *   Implements child management methods: `addComponent()`, `removeComponent()`, `getChild()`.
    *   `getSize()` recursively calculates the total size by summing the sizes of all its children.
    *   `displayDetails()` prints the directory's name and total size, then recursively calls `displayDetails()` on each of its children with increased indentation to show the hierarchy.

*   **`CompositeDemo.java` (Demo Class):**
    *   Builds a sample file system tree structure consisting of several `File` and `Directory` objects.
    *   Demonstrates calling `displayDetails()` on the root directory, which then prints the entire hierarchy along with sizes.
    *   Shows how `getSize()` can be called on individual files or on directories to get their respective sizes, illustrating the uniform treatment of components.

This example highlights how the Composite pattern enables clients to work with complex tree structures of objects as if they were simple individual objects, simplifying client code and providing a flexible way to manage part-whole hierarchies.
