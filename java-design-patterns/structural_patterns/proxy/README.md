# Proxy Pattern

The Proxy pattern is a structural design pattern that provides a surrogate or placeholder for another object to control access to it. This control can be for various reasons, such as managing resource-intensive objects, adding security, enabling remote access, or logging. The proxy object has the same interface as the real object it represents, allowing clients to interact with the proxy transparently.

## Purpose

*   **Control Access:** Act as an intermediary to control access to another object (the RealSubject).
*   **Placeholder/Surrogate:** Stand in for the RealSubject, potentially adding functionality or managing its lifecycle.
*   **Manage RealSubject:** The proxy can be responsible for creating, initializing, and deleting the RealSubject.

## Use Cases

The Proxy pattern is versatile and can be used in various scenarios, often categorized by the type of control or functionality the proxy provides:

*   **Virtual Proxy:** Delays the creation and initialization of expensive objects until they are actually needed (lazy initialization). This can improve application startup time and reduce resource consumption if the object is never used.
    *   Example: Loading high-resolution images only when they become visible or when `display()` is called.
*   **Protection Proxy (Security Proxy):** Controls access to the methods or data of the RealSubject based on the client's permissions or other security criteria.
    *   Example: A user with "admin" rights can execute all database operations, while a "guest" user can only perform read operations.
*   **Remote Proxy:** Represents an object that resides in a different address space (e.g., on a remote server). The proxy handles the communication details (serialization, network calls) making the remote object appear local to the client.
    *   Example: Java RMI (Remote Method Invocation) stubs.
*   **Logging Proxy:** Intercepts calls to the RealSubject to log information about the requests, such as method names, parameters, or execution time.
*   **Caching Proxy:** Stores the results of expensive operations performed by the RealSubject and returns cached results for subsequent identical requests, improving performance.
*   **Smart Proxy (Smart Reference):** Performs additional actions when an object is accessed, such as reference counting for garbage collection or loading a persistent object into memory.

## Pros

*   **Controlled Access:** Provides a level of indirection when accessing an object, allowing for various forms of control (lazy loading, security, logging, etc.).
*   **Lifecycle Management:** The proxy can manage the lifecycle of the RealSubject, including its creation and deletion, often transparently to the client.
*   **Enhanced Functionality:** Can add behavior (e.g., security checks, logging, caching) before or after delegating calls to the RealSubject without modifying the RealSubject's code.
*   **Improved Performance:** Virtual proxies can improve performance by deferring the creation of expensive objects. Caching proxies can improve performance by reusing results.
*   **Decoupling:** The client interacts with the Subject interface and is often unaware of whether it's dealing with a proxy or the real object, promoting loose coupling.

## Cons

*   **Increased Indirection:** Introduces an extra layer of indirection, which can add complexity to the design and potentially a slight performance overhead for simple operations.
*   **Delayed Response (for some proxies):** For virtual proxies, the first access to the RealSubject might involve a delay while the proxy initializes it.
*   **Class Proliferation:** Can lead to an increase in the number of classes in the system if many different types of proxies are needed for various subjects.
*   **Potential for Misuse:** If not designed carefully, proxies can become bottlenecks or introduce subtle bugs related to object state or lifecycle.

## Java Example Explanation

The Java example in this directory demonstrates the **Virtual Proxy** type. It simulates loading and displaying images, where loading an image from disk is an expensive operation.

*   **`Image.java` (Subject Interface):**
    *   Defines the common interface for both the `RealImage` (RealSubject) and `ProxyImage` (Proxy).
    *   Declares methods `display()` and `getFileName()`. This allows the client to treat proxy and real image objects uniformly.

*   **`RealImage.java` (RealSubject Class):**
    *   Represents the actual image object that performs the core task (loading from disk and displaying).
    *   The constructor takes a `fileName`.
    *   The `loadFromDisk()` method simulates an expensive operation (e.g., reading a large image file). This method is called internally by `display()` only if the image hasn't been loaded yet.
    *   The `display()` method ensures the image is loaded and then "displays" it.

*   **`ProxyImage.java` (Proxy Class):**
    *   Implements the `Image` interface.
    *   Holds a reference to a `RealImage` instance, which is initially `null`.
    *   Stores the `fileName`.
    *   The `display()` method implements the lazy loading logic:
        1.  If the `realImage` instance is `null` (meaning it's the first call to `display()` for this proxy instance), it creates a new `RealImage` object.
        2.  It then delegates the `display()` call to the `realImage` object. The `RealImage` itself will handle the actual disk loading if it's its first time being displayed.
    *   The `getFileName()` method can return the file name without needing to instantiate or load the `RealImage`.

*   **`ProxyDemo.java` (Client Class):**
    *   Demonstrates the behavior of the Virtual Proxy:
        1.  Creates several `ProxyImage` instances. At this point, no actual images are loaded from disk.
        2.  When `display()` is called on a `ProxyImage` for the first time, the proxy instantiates `RealImage`, and `RealImage` loads the image data (simulated by a delay and console messages).
        3.  Subsequent calls to `display()` on the same `ProxyImage` instance use the already loaded `RealImage` and display the image immediately without reloading.
        4.  The demo shows that different proxy instances (even for the same file name) manage their own `RealImage` loading independently in this simple setup.

This example effectively shows how a Virtual Proxy can defer the cost of creating and initializing a resource-intensive object (`RealImage`) until it is actually required, improving application performance and resource management.
