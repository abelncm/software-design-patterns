# Chain of Responsibility Pattern

The Chain of Responsibility pattern is a behavioral design pattern that allows an object to send a command without knowing which object will receive and handle it. The request is passed along a chain of potential handlers until one of them handles it or the chain ends.

## Purpose

*   **Decouple Sender and Receiver:** Avoid coupling the sender of a request to its specific receiver.
*   **Multiple Handlers:** Give more than one object a chance to handle the request.
*   **Dynamic Handling:** Allow the chain of handlers and their order to be configured dynamically.

## Use Cases

*   **Hierarchical Request Handling:** When a request needs to be processed by one of several objects, and the specific handler is not known in advance, or when the handler can be determined based on the request's properties.
    *   Example: An expense approval system where different management levels (Manager, Director, VP) can approve expenses up to certain limits. A request is passed up the chain until an appropriate approver is found.
*   **Event Handling in GUI Systems:** UI events (like mouse clicks or key presses) might be processed by a chain of UI elements (e.g., a button, then its containing panel, then the window).
*   **Logging Systems:** Log messages of different severity levels (INFO, DEBUG, WARNING, ERROR) can be processed by a chain of loggers, where each logger handles messages of a certain level or passes them on.
*   **Servlet Filters in Java Web Applications:** Incoming HTTP requests pass through a chain of filters, where each filter can process the request (e.g., for authentication, logging, data transformation) before passing it to the next filter or the target servlet.
*   **Middleware Processing:** Systems where requests pass through a series of processing units, each performing a specific task.

## Pros

*   **Reduced Coupling:** The sender of a request does not need to know who will handle it. The handlers also don't need to know about the sender directly, only about the request and the next handler in the chain.
*   **Increased Flexibility:** The chain of handlers can be modified or reordered at runtime, allowing for flexible assignment of responsibilities.
*   **Single Responsibility Principle:** Each handler is responsible for processing a specific type of request or a specific part of the processing logic.
*   **Implicit Receiver:** The receiver of the request is determined implicitly by its position and capability within the chain.

## Cons

*   **Request Not Guaranteed to Be Handled:** If the chain is not configured correctly or if no handler in the chain is capable of processing a particular request, the request might go unhandled (unless a default handler is implemented at the end of the chain).
*   **Debugging Complexity:** Tracing a request through a long or complex chain can sometimes be difficult for debugging purposes.
*   **Potential Performance Impact:** If the chain is very long, there might be a performance overhead as the request traverses multiple handlers.
*   **Chain Structure Management:** Care must be taken to ensure the chain is structured correctly and that all links are properly set up.

## Java Example Explanation

The Java example in this directory demonstrates the Chain of Responsibility pattern using an expense approval system for purchase requests.

*   **`PurchaseRequest.java` (Request Class):**
    *   Encapsulates the details of a purchase request, including its number, amount, purpose, and approval status (`isApproved`, `approvedBy`).

*   **`Approver.java` (Handler Abstract Class):**
    *   Defines the interface for all handlers in the chain.
    *   It holds a reference to the `nextApprover` in the chain and the `approverName`.
    *   The `setNextApprover(Approver nextApprover)` method is used to build the chain.
    *   Declares an abstract method `processRequest(PurchaseRequest request)` that concrete handlers must implement.
    *   Provides a helper method `passToNext(PurchaseRequest request)` to forward the request if the current handler cannot process it and a next handler exists.

*   **`Manager.java`, `Director.java`, `VicePresident.java` (ConcreteHandler Classes):**
    *   These classes extend `Approver` and implement `processRequest()`.
    *   Each concrete approver has a specific approval limit:
        *   `Manager`: Approves requests up to $500.
        *   `Director`: Approves requests up to $5,000.
        *   `VicePresident`: Approves requests up to $25,000.
    *   If a handler can approve the request, it marks the request as approved and sets its name as the approver.
    *   If it cannot approve the request due to the amount exceeding its limit, it calls `passToNext()` to forward the request to the next approver in the chain.
    *   If a request exceeds the VP's limit or if the VP is the last in the chain and cannot handle it, the request may remain unapproved.

*   **`ChainOfResponsibilityDemo.java` (Client Class):**
    *   Creates instances of the concrete approvers (`Manager`, `Director`, `VicePresident`).
    *   Builds the chain of responsibility by linking them: `manager.setNextApprover(director); director.setNextApprover(vp);`.
    *   Creates several `PurchaseRequest` objects with varying amounts.
    *   Sends these requests to the first handler in the chain (`manager`).
    *   The demo output shows how each request is processed: either handled by an approver or passed along the chain until it's handled or the chain ends.

This example illustrates how the Chain of Responsibility pattern allows a request to be passed through a series of potential handlers, decoupling the sender from the specific handler and providing a flexible way to manage request processing.
