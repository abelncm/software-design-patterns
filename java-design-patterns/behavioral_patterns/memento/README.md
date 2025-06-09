# Memento Pattern

The Memento pattern is a behavioral design pattern that, without violating encapsulation, captures and externalizes an object's internal state so that the object can be restored to this state later. This is useful for implementing undo/redo mechanisms, checkpoints, or transactions.

## Purpose

*   **Capture and Externalize State:** Allow saving the internal state of an object (the Originator) from outside the object itself.
*   **Restore Previous State:** Allow the object to be reverted to a previously saved state.
*   **Preserve Encapsulation:** Achieve this state capture and restoration without exposing the internal structure or private members of the Originator to the outside world (specifically, to the Caretaker that manages the history of states).

## Components

1.  **Originator:**
    *   The object whose state needs to be saved.
    *   Creates a Memento object containing a snapshot of its current internal state.
    *   Uses a Memento object passed by the Caretaker to restore its internal state.

2.  **Memento:**
    *   Stores the internal state of the Originator object.
    *   The Memento's interface to its state is typically restricted. Ideally, only the Originator that created the Memento should be able to access its state (to restore itself). The Caretaker should only hold and pass Mementos, not inspect their content. This can be achieved by making the Memento an inner class of the Originator, or by using package-private visibility for state access methods if Originator and Memento are in the same package.
    *   It essentially protects against access by objects other than the originator.

3.  **Caretaker:**
    *   Responsible for keeping track of Memento objects.
    *   It never operates on or examines the contents of a Memento. It acts as a custodian.
    *   It requests a Memento from the Originator to save a state and passes a Memento back to the Originator to restore a state (e.g., for undo operations).
    *   Can store multiple Mementos, for example, in a stack or list to manage a history of states.

## Use Cases

*   **Undo/Redo Mechanisms:** Common in applications like text editors, graphics editors, or any system where users might want to revert actions.
*   **Checkpoints and Snapshots:** Saving the state of a long-running computation or process at certain points to allow recovery in case of failure or to roll back to a stable state.
*   **Transactional Operations:** Ensuring that a series of operations can be rolled back if any part of the transaction fails. The state before the transaction can be saved in a Memento.
*   **Game Saving:** Saving the current state of a game (player position, score, inventory) so it can be resumed later.
*   **Database State Management:** Rolling back transactions or restoring database snapshots.

## Pros

*   **Preserves Encapsulation:** The internal state of the Originator is not exposed to other objects (like the Caretaker). The Memento itself might have a restricted interface for accessing its stored state, typically only allowing the Originator to do so.
*   **Simplifies Originator:** The Originator doesn't need to manage the history of its states or the mechanisms for saving/restoring them; this responsibility is delegated to the Caretaker and the Memento.
*   **Atomic State Changes:** Facilitates atomic state changes by allowing a rollback to a previous valid state if an operation fails partway through.

## Cons

*   **Potentially High Memory Consumption:** If the Originator's state is large, creating and storing many Mementos can consume a significant amount of memory, especially if the history is long.
*   **Caretaker Complexity:** The Caretaker needs to manage the Mementos (e.g., when to save, when to discard, storage limits), which can add complexity to the Caretaker's logic.
*   **Dynamic Class Definitions:** If the Originator's class structure changes (e.g., fields are added or removed) after Mementos have been created (and possibly persisted), restoring from older Mementos might become problematic or require versioning strategies for Mementos.
*   **Cost of State Transfer:** Copying the state from the Originator to the Memento and back can be time-consuming if the state is large or complex.

## Java Example Explanation

The Java example in this directory demonstrates the Memento pattern using a simple `TextEditor` application that supports undo functionality.

*   **`EditorMemento.java` (Memento Class):**
    *   Stores the state of the `TextEditor`, which includes its `content` (text), `fontName`, and `fontSize`.
    *   Its constructor (`EditorMemento(String content, String fontName, int fontSize)`) is package-private, intended to be called only by the `TextEditor` (Originator) when saving its state.
    *   Getter methods (`getContent()`, `getFontName()`, `getFontSize()`) are also package-private, allowing only the `TextEditor` to retrieve the state when restoring. This maintains encapsulation.

*   **`TextEditor.java` (Originator Class):**
    *   This is the object whose state we want to save and restore. It has attributes like `content`, `fontName`, and `fontSize`.
    *   `saveStateToMemento()`: Creates a new `EditorMemento` instance, passing its current state (content, font name, font size) to the memento's constructor.
    *   `restoreStateFromMemento(EditorMemento memento)`: Takes an `EditorMemento` and restores its own state from the values stored in the memento.
    *   Methods like `type(String text)`, `delete(int chars)`, and `setFont(...)` modify the editor's state.

*   **`EditorHistory.java` (Caretaker Class):**
    *   Manages the history of saved states (Mementos).
    *   Uses a `Stack<EditorMemento>` to store `EditorMemento` objects, which is suitable for undo (Last-In, First-Out) operations.
    *   `addMemento(EditorMemento memento)`: Pushes a memento onto the history stack.
    *   `undo()`: Pops the most recent memento from the stack and returns it. If the stack is empty, it returns `null`.

*   **`MementoDemo.java` (Client Class):**
    *   Creates instances of `TextEditor` (Originator) and `EditorHistory` (Caretaker).
    *   Simulates user actions:
        1.  The initial state of the editor is saved.
        2.  The user types text, and the state is saved again.
        3.  The user types more text, and the state is saved.
        4.  The user changes the font, and the state is saved.
        5.  The user types even more text, and this final state is also saved.
    *   Then, it demonstrates the undo functionality by repeatedly calling `history.undo()` and `editor.restoreStateFromMemento()` to revert the editor to its previous states, stepping back through the saved history.

This example shows how the Memento pattern allows an object (`TextEditor`) to have its state captured and restored without exposing its internal details to the history management logic (`EditorHistory`), thus preserving encapsulation while enabling features like undo.
