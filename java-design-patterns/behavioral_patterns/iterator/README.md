# Iterator Pattern

The Iterator pattern is a behavioral design pattern that provides a way to access the elements of an aggregate object (a collection) sequentially without exposing its underlying representation (e.g., array, list, tree).

## Purpose

*   **Sequential Access:** Provide a standard way to traverse through a collection of objects.
*   **Hide Internal Structure:** Decouple clients from the specific implementation details of the collection. The client uses the iterator and doesn't need to know how the collection stores its elements.
*   **Support Multiple Traversals:** Allow multiple iterators to traverse the same collection independently.
*   **Uniform Traversal Interface:** Offer a common interface for iterating over different types of aggregate structures.

## Use Cases

*   **Abstracting Traversal:** When you need to access the elements of a collection without wanting to expose how the collection is structured (e.g., whether it's an `ArrayList`, `LinkedList`, `HashSet`, or a custom data structure).
*   **Multiple Traversal Algorithms:** When you want to support different ways of traversing a collection (e.g., forward, backward, filtered iteration) without bloating the collection's interface. Different iterators can implement different traversal strategies.
*   **Uniformity Across Collections:** When you have various types of collections and want to provide a single, uniform way for clients to iterate over them. This is precisely what Java's `Iterable` and `Iterator` interfaces achieve.
*   **Examples:**
    *   Java's Collections Framework: All standard collections (`List`, `Set`, `Queue`) implement `java.lang.Iterable` and provide `java.util.Iterator` to traverse their elements.
    *   Database Result Sets: Iterating over rows returned from a database query.
    *   Streaming Data: Processing elements from a stream one by one.

## Pros

*   **Simplifies Aggregate Interface:** The aggregate object itself doesn't need to provide a wide range of traversal methods; it just needs a method to create an iterator.
*   **Supports Multiple Independent Traversals:** Multiple iterators can exist for the same aggregate object, each maintaining its own traversal state.
*   **Decoupling:** The client code is decoupled from the internal structure of the aggregate. Algorithms that use iterators can work with any aggregate that provides an iterator.
*   **Clean Separation of Concerns:** The responsibility of traversal is moved from the aggregate object to the iterator object.

## Cons

*   **Overhead for Simple Collections:** For very simple collections where only basic forward iteration is needed, creating a separate iterator class might seem like overkill if the collection's internal structure is already simple to expose.
*   **Concurrency Issues:** If the underlying collection is modified while an iterator is active (by a different thread or even by the same thread directly manipulating the collection outside the iterator's `remove()` method), it can lead to unpredictable behavior. Java iterators, for instance, are often fail-fast and may throw a `ConcurrentModificationException`.
*   **Limited Functionality by Default:** Basic iterators usually provide only sequential access. More complex traversal (e.g., tree traversal algorithms) might require specialized iterators.

## Java Example Explanation

The Java example in this directory demonstrates the Iterator pattern using a custom `BookCollection` that stores `Book` objects. Custom `CustomIterator` and `CustomIterable` interfaces are defined for pedagogical clarity, though in typical Java development, the built-in `java.util.Iterator` and `java.lang.Iterable` interfaces are used.

*   **`Book.java` (Element Class):**
    *   A simple class representing a book with a title and author. This is the object type stored in our collection.

*   **`CustomIterator<T>.java` (Iterator Interface - Custom):**
    *   Defines the standard methods for an iterator:
        *   `boolean hasNext()`: Returns `true` if the iteration has more elements.
        *   `T next()`: Returns the next element in the iteration.

*   **`CustomIterable<T>.java` (Aggregate/Iterable Interface - Custom):**
    *   Defines the factory method for creating an iterator:
        *   `CustomIterator<T> createIterator()`: Returns an iterator for the aggregate.

*   **`BookCollection.java` (ConcreteAggregate Class):**
    *   Implements the `CustomIterable<Book>` interface.
    *   Internally stores `Book` objects in a `List<Book>`.
    *   Provides methods like `addBook()` to manage the collection.
    *   The `createIterator()` method returns a new instance of `BookIteratorImpl`.
    *   **`BookIteratorImpl` (ConcreteIterator Class - Inner Class):**
        *   This private inner class implements the `CustomIterator<Book>` interface.
        *   It holds a reference to the `BookCollection` it iterates over and maintains the `currentIndex` of the traversal.
        *   `hasNext()` checks if `currentIndex` is within the bounds of the collection.
        *   `next()` retrieves the book at the `currentIndex` and then increments the index. It throws a `NoSuchElementException` if `next()` is called when `hasNext()` is false.

*   **`IteratorDemo.java` (Client Class):**
    *   Creates a `BookCollection` instance and adds several `Book` objects to it.
    *   Obtains an iterator from the collection by calling `bookCollection.createIterator()`.
    *   Uses a `while` loop with `iterator.hasNext()` and `iterator.next()` to traverse the collection and print details of each book.
    *   Demonstrates that calling `next()` when `hasNext()` is false throws a `NoSuchElementException`.
    *   Shows that multiple iterators can be created for the same collection, each maintaining its own state.
    *   Illustrates behavior with an empty collection.

This example clearly separates the responsibility of iterating over the `BookCollection` from the collection itself, allowing clients to access its elements sequentially without needing to know about the internal `List` used for storage. It also mirrors the fundamental design of Java's own `Iterable` and `Iterator`.
