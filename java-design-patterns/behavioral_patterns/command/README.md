# Command Pattern

The Command pattern is a behavioral design pattern that encapsulates a request as an object, thereby allowing for parameterization of clients with different requests, queuing or logging of requests, and support for undoable operations.

## Purpose

*   **Encapsulate Request as Object:** Turn a request into a stand-alone object that contains all information about the request. This includes the method to call, the object (Receiver) that owns the method, and the values for the method parameters.
*   **Decouple Sender and Receiver:** Decouple the object that invokes the operation (Invoker) from the object that actually performs the operation (Receiver).
*   **Support Undo/Redo, Logging, Queuing:** Enable advanced features like undoing/redoing operations, logging command history, or queuing commands for later execution.

## Use Cases

*   **Parameterizing Objects with Actions:** When you want to configure an object (e.g., a UI button, a menu item) to perform a specific action (command) when an event occurs.
*   **Queuing and Scheduling Requests:** When requests need to be executed at different times or in a specific order (e.g., a task queue in an application).
*   **Undoable Operations:** When you need to support undo and redo functionality. Each command object can store the state necessary to reverse its action.
*   **Logging and Transactional Systems:** Commands can be logged to a persistent store, allowing for recovery or auditing. In transactional systems, a sequence of commands can be executed as a single transaction.
*   **Macro Recording:** Recording a sequence of user actions as commands and then replaying them.
*   **Examples:**
    *   **Remote Controls:** A remote control (Invoker) has buttons, and each button can be assigned a command (e.g., `LightOnCommand`, `TVOffCommand`) that operates on a specific device (Receiver).
    *   **GUI Buttons and Menu Items:** Clicking a button or menu item triggers a command object associated with it.
    *   **Text Editors:** Operations like "cut", "copy", "paste" are often implemented as commands to support undo/redo.
    *   **Task Schedulers:** Tasks are encapsulated as command objects and executed by a scheduler.

## Pros

*   **Decoupling:** The Invoker is decoupled from the Receiver. The Invoker only needs to know the `Command` interface, not how the command is implemented or who the receiver is.
*   **First-Class Objects:** Commands are objects, so they can be stored, passed around, and manipulated like any other object (e.g., stored in a list for history).
*   **Extensibility:** Easy to add new commands by creating new classes that implement the `Command` interface, without changing existing client or invoker code.
*   **Support for Advanced Operations:** Simplifies the implementation of undo/redo, logging, transactions, and command queues.
*   **Composition of Commands:** Multiple commands can be grouped together to form a composite command (Macro Command).

## Cons

*   **Increased Number of Classes:** Can lead to a proliferation of command classes, especially if there are many different actions or variations of actions in the system. This might make the design more complex.
*   **Potential for Complexity:** Each command needs to store its receiver and any arguments, which might increase memory usage if commands are numerous or complex. The logic for managing command history for undo/redo can also add complexity.
*   **Boilerplate Code:** For simple operations, creating a separate command class might seem like overkill and introduce boilerplate.

## Java Example Explanation

The Java example in this directory demonstrates the Command pattern using a simple remote control for a light.

*   **`Light.java` (Receiver Class):**
    *   This class knows how to perform the actual operations: `turnOn()` and `turnOff()`. It also maintains its state (whether it's on or off) and a location identifier.

*   **`Command.java` (Command Interface):**
    *   Declares the interface for all command objects.
    *   It includes an `execute()` method to perform the action and an `undo()` method to reverse it.

*   **`LightOnCommand.java`, `LightOffCommand.java` (ConcreteCommand Classes):**
    *   These classes implement the `Command` interface.
    *   Each concrete command holds a reference to a `Light` object (its Receiver), which is passed in the constructor.
    *   `LightOnCommand.execute()` calls `light.turnOn()`, and its `undo()` calls `light.turnOff()`.
    *   `LightOffCommand.execute()` calls `light.turnOff()`, and its `undo()` calls `light.turnOn()`.

*   **`RemoteControl.java` (Invoker Class):**
    *   This class acts as the invoker. It has a slot to hold a `Command` object.
    *   The `setCommand(Command command)` method allows the client to assign a command to the remote's button.
    *   The `pressButton()` method calls `command.execute()`.
    *   It also keeps track of the `lastCommandExecuted` to support a simple `pressUndoButton()` functionality, which calls `lastCommandExecuted.undo()`.
    *   Includes a nested `NoCommand` class (Null Object pattern) to handle cases where no command is set or for initializing `lastCommandExecuted`.

*   **`CommandDemo.java` (Client Class):**
    *   Sets up the scenario:
        1.  Creates `Light` receiver objects (e.g., for Living Room, Kitchen).
        2.  Creates `ConcreteCommand` instances (`LightOnCommand`, `LightOffCommand`), associating each with a specific `Light` object.
        3.  Creates a `RemoteControl` invoker instance.
        4.  Assigns commands to the remote control using `remote.setCommand()`.
        5.  Simulates button presses (`remote.pressButton()`, `remote.pressUndoButton()`) to execute and undo commands.
    *   The demo shows how the client can change the command associated with the remote and how the invoker (RemoteControl) is decoupled from the specifics of the Light actions.

This example illustrates how the Command pattern encapsulates requests as objects, allowing for parameterized clients, undoable operations, and decoupling of the request initiator from the request performer.
