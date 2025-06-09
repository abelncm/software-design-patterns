# State Pattern

The State pattern is a behavioral design pattern that allows an object to alter its behavior when its internal state changes. The object will appear to change its class because its behavior is delegated to different state objects.

## Purpose

*   **Alter Behavior with State Change:** Enable an object (the Context) to change its behavior dynamically when its internal state changes.
*   **State-Specific Behavior:** Encapsulate state-specific logic into separate classes (ConcreteStates).
*   **Simplify Conditionals:** Avoid complex conditional statements (if/else or switch) within the Context object by delegating behavior to state objects. The Context's methods call methods on the current state object, and each state object knows what to do in that particular state.

## Components

1.  **Context:**
    *   Maintains an instance of a `ConcreteState` subclass that defines the current state.
    *   Delegates state-dependent requests to the current `ConcreteState` object.
    *   Provides a setter method that allows `ConcreteState` objects to change the Context's current state, thus facilitating state transitions.

2.  **State (Interface or Abstract Class):**
    *   Defines a common interface for all concrete states.
    *   This interface declares methods that represent actions or operations whose behavior will vary depending on the current state of the Context.
    *   These methods typically accept the `Context` object as a parameter, allowing the state to interact with the context (e.g., to transition the context to a new state).

3.  **ConcreteState (Classes):**
    *   Implement the `State` interface.
    *   Each `ConcreteState` class provides the actual behavior associated with a particular state of the `Context`.
    *   A `ConcreteState` object is responsible for handling requests delegated by the `Context`.
    *   It can also decide when and how to transition the `Context` to a different state (e.g., after performing an action, it might call `context.setState(new AnotherConcreteState())`).

## Use Cases

*   **State-Dependent Behavior:** When an object's behavior depends heavily on its current state, and this behavior needs to change at runtime as the state changes.
*   **Complex Conditional Logic:** When an object's methods contain large conditional statements (if/else or switch blocks) that select behavior based on the current state. The State pattern refactors these conditionals into separate state classes.
*   **Workflow and Process Management:** Modeling objects that go through various stages in a lifecycle or workflow, where each stage has distinct behaviors and transitions.
    *   Example: Managing the state of a package in a delivery system (e.g., Ordered, Shipped, InTransit, Delivered, Returned).
    *   Example: TCP connection states (e.g., Listening, SYN-Sent, Established, FIN-Wait, Closed).
    *   Example: Document states in an approval process (e.g., Draft, InReview, Approved, Rejected, Published).
*   **Vending Machines or ATMs:** The behavior of the machine changes based on its current state (e.g., no coins inserted, coins inserted, item selected, item dispensed, out of stock).
*   **Game Character States:** A game character might have states like Standing, Walking, Running, Jumping, Attacking, each with different actions and responses to input.

## Pros

*   **Localizes State-Specific Behavior:** Organizes code related to particular states into separate classes, making it cleaner and easier to understand than monolithic conditional blocks. Each state has its own well-defined responsibilities.
*   **Makes State Transitions Explicit:** State transitions are clearly defined within the state classes, making the state machine logic more transparent.
*   **Improved Extensibility:** Easy to add new states and transitions by creating new `ConcreteState` classes without significantly altering existing state classes or the `Context` class (Open/Closed Principle).
*   **Shared State Objects:** If concrete state objects do not have any instance-specific fields (i.e., they are flyweights), they can be shared among multiple context objects, reducing memory usage.

## Cons

*   **Increased Number of Classes:** Can lead to a proliferation of state classes if the object has many states or if the state transitions are very granular, potentially increasing the complexity of the design.
*   **Boilerplate Code:** If states are very simple or have minimal behavior, the overhead of creating separate classes for each might seem like boilerplate.
*   **Context Dependency:** State objects are often tightly coupled to the Context object because they need to call its `setState` method and possibly access other context data.

## Java Example Explanation

The Java example in this directory demonstrates the State pattern using a package delivery system. A `PackageContext` object transitions through different states (`OrderedState`, `ShippedState`, `DeliveredState`).

*   **`PackageState.java` (State Interface):**
    *   Defines the common interface for all package states.
    *   Declares `updateState(PackageContext ctx)` which concrete states implement to handle actions and transitions.
    *   Declares `getStatus()` to get a string representation of the current state.

*   **`OrderedState.java`, `ShippedState.java`, `DeliveredState.java` (ConcreteState Classes):**
    *   Each class implements `PackageState` and represents a specific state of the package.
    *   `OrderedState`: When `updateState` is called, it simulates processing the order for shipping and transitions the `PackageContext` to `ShippedState`.
    *   `ShippedState`: When `updateState` is called, it simulates the package being in transit and transitions the `PackageContext` to `DeliveredState`.
    *   `DeliveredState`: When `updateState` is called, it indicates the package is delivered and typically represents a final state in this simple model (no further transitions).
    *   Each state class prints a message upon entry (in its constructor for this demo) and when its `updateState` method is called.

*   **`PackageContext.java` (Context Class):**
    *   Maintains the `currentState` of the package (an instance of a `PackageState`).
    *   It is initialized with an `OrderedState`.
    *   Provides `setCurrentState(PackageState state)` which is called by the concrete state objects to change the current state of the package.
    *   The `proceedToNextStatus()` method is the primary way clients interact with the package. This method delegates the action to the `updateState()` method of the `currentState` object.

*   **`StateDemo.java` (Client Class):**
    *   Creates a `PackageContext` object (e.g., `myPackage`).
    *   Calls `myPackage.proceedToNextStatus()` multiple times.
    *   The output demonstrates how the behavior of `proceedToNextStatus()` changes as the `myPackage` object transitions from `OrderedState` to `ShippedState`, and then to `DeliveredState`. Each call to `proceedToNextStatus()` triggers the logic within the current state, which includes performing an action and potentially transitioning the context to the next state.
    *   It also shows that different `PackageContext` instances maintain their states independently.

This example illustrates how the State pattern allows an object (`PackageContext`) to change its behavior when its internal state changes, by delegating requests to different state objects (`OrderedState`, `ShippedState`, `DeliveredState`).
