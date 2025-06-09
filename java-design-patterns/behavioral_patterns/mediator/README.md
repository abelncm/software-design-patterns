# Mediator Pattern

The Mediator pattern is a behavioral design pattern that defines an object (the mediator) that encapsulates how a set of other objects (colleagues) interact. It promotes loose coupling by preventing colleagues from referring to each other explicitly, and it allows their interaction to be varied independently.

## Purpose

*   **Centralize Complex Interactions:** Manage complex communication and control logic between multiple objects by centralizing it in a single mediator object.
*   **Reduce Coupling:** Decouple colleague objects from each other. Colleagues only need to know about the mediator, not about every other colleague. This reduces direct dependencies.
*   **Simplify Communication:** Instead of many-to-many connections between colleagues, each colleague communicates with the mediator, which then coordinates with other relevant colleagues.
*   **Independent Variation of Interaction:** The way colleagues interact can be changed by modifying the mediator without altering the colleagues themselves.

## Use Cases

*   **Complex Inter-Object Communication:** When a system consists of a set of objects that communicate in complex but well-defined ways, and direct communication would lead to a tangled web of relationships (high coupling).
*   **Reusability of Colleagues:** When colleague objects need to be reusable independently, and direct coupling would hinder this.
*   **Centralized Control:** When you want to centralize control or decision-making logic that affects multiple objects.
*   **Examples:**
    *   **Chat Applications:** Users (Colleagues) in a chat room send messages through a central chat room server (Mediator), which then distributes the messages to other users.
    *   **Air Traffic Control Systems:** Aircraft (Colleagues) communicate with an air traffic control tower (Mediator) to coordinate takeoffs, landings, and flight paths, rather than communicating directly with each other.
    *   **GUI Dialogs:** In a graphical user interface, various widgets (buttons, text fields, checkboxes - Colleagues) within a dialog box might interact. The dialog box itself can act as a mediator, handling events from one widget and updating others accordingly (e.g., enabling a "Save" button only when a text field is not empty).
    *   **Workflow Systems:** Coordinating different services or components in a business process.

## Pros

*   **Reduced Coupling:** Colleagues are decoupled from each other, as they only interact with the mediator. This reduces dependencies and makes the system easier to maintain and extend.
*   **Centralized Interaction Logic:** The logic for how objects interact is centralized in the mediator, making it easier to understand, manage, and modify these interactions.
*   **Simplified Colleague Protocols:** Colleague objects become simpler as they no longer need to manage direct relationships with numerous other colleagues.
*   **Improved Reusability:** Individual colleague components are easier to reuse because they are not tightly coupled to others.
*   **Promotes Single Responsibility Principle:** The mediator takes on the responsibility for interaction, allowing colleagues to focus on their own tasks.

## Cons

*   **Mediator Complexity (God Object):** The mediator itself can become overly complex if it tries to manage too many colleagues or incorporates too much logic. This can turn the mediator into a "god object" that is difficult to maintain.
*   **Potential Performance Bottleneck:** If all communication flows through a single mediator, it could potentially become a performance bottleneck in high-throughput systems, although this is often not an issue for typical use cases.
*   **Reduced Direct Control:** May limit direct, potentially more efficient, communication between colleagues when such direct interaction is actually simple and safe.
*   **Understanding System Behavior:** While individual colleagues are simpler, understanding the overall behavior of the system might require understanding the complex logic within the mediator.

## Java Example Explanation

The Java example in this directory demonstrates the Mediator pattern using a simple chat room application.

*   **`ChatMediator.java` (Mediator Interface):**
    *   Defines the interface for communication between `User` colleagues.
    *   Declares methods like `sendMessage(String message, User sender)` for users to send messages, and `addUser(User user)` / `removeUser(User user)` for managing users in the chat.

*   **`User.java` (Abstract Colleague Class):**
    *   An abstract class representing a user in the chat system.
    *   Each `User` holds a reference to a `ChatMediator` instance (passed in the constructor) and has a `name` and `id`.
    *   Declares abstract methods `send(String message)` (for the user to initiate sending a message through the mediator) and `receive(String message, String senderName)` (for the mediator to deliver a message to this user).

*   **`ChatUser.java` (ConcreteColleague Class):**
    *   Extends `User` and provides concrete implementations for `send()` and `receive()`.
    *   `send(String message)`: Calls `mediator.sendMessage(message, this)`.
    *   `receive(String message, String senderName)`: Prints the received message to the console.

*   **`ChatRoomMediatorImpl.java` (ConcreteMediator Class):**
    *   Implements the `ChatMediator` interface.
    *   Maintains a `List<User>` to keep track of all users currently in the chat room.
    *   `addUser()` and `removeUser()` methods manage this list.
    *   `sendMessage(String message, User sender)`: When a user sends a message, this method iterates through the list of registered users and calls the `receive()` method on every *other* user in the room, effectively broadcasting the message.

*   **`MediatorDemo.java` (Client Class):**
    *   Sets up the chat room scenario:
        1.  Creates an instance of `ChatRoomMediatorImpl`.
        2.  Creates several `ChatUser` instances, associating them with the chat room mediator.
        3.  Adds users to the chat room using `chatRoom.addUser()`.
        4.  Simulates users sending messages by calling their `send()` method.
    *   The demo output shows that messages sent by one user are received by all other users currently in the chat room, facilitated by the mediator. It also demonstrates users being added and removed, affecting who receives subsequent messages.

This example illustrates how the Mediator pattern centralizes communication logic, allowing `ChatUser` objects to interact without having direct references to each other, thereby promoting looser coupling.
