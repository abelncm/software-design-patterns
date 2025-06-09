package behavioral_patterns.memento;

import java.util.Stack; // Using Stack for LIFO behavior typical for undo

/**
 * Caretaker Class: Responsible for keeping track of multiple Memento objects.
 * It does not operate on or examine the contents of a Memento.
 * It acts as a custodian for the mementos.
 */
public class EditorHistory {
    // A stack to store mementos, allowing easy undo (pop) functionality.
    private Stack<EditorMemento> history;

    public EditorHistory() {
        this.history = new Stack<>();
        System.out.println("EditorHistory: Initialized. Memento history is empty.");
    }

    /**
     * Adds a Memento to the history.
     * This is typically called after the Originator's state changes and is saved.
     * @param memento The EditorMemento to save.
     */
    public void addMemento(EditorMemento memento) {
        if (memento != null) {
            history.push(memento);
            System.out.println("EditorHistory: Memento saved. History size: " + history.size());
            // System.out.println("EditorHistory: Current memento on top: " + memento.toString());
        }
    }

    /**
     * Retrieves the most recent Memento from history (for an undo operation)
     * and removes it from the history stack.
     * @return The most recent EditorMemento, or null if history is empty.
     */
    public EditorMemento undo() {
        if (!history.isEmpty()) {
            EditorMemento memento = history.pop();
            System.out.println("EditorHistory: Popped memento for undo. History size now: " + history.size());
            // System.out.println("EditorHistory: Memento being restored: " + memento.toString());
            return memento;
        } else {
            System.out.println("EditorHistory: No mementos in history to undo.");
            return null;
        }
    }

    /**
     * Peeks at the most recent Memento without removing it.
     * (Optional, could be useful for debugging or specific scenarios)
     * @return The most recent EditorMemento, or null if history is empty.
     */
    public EditorMemento peekLastMemento() {
        if (!history.isEmpty()) {
            return history.peek();
        }
        return null;
    }

    public boolean hasHistory() {
        return !history.isEmpty();
    }

    public int getHistorySize() {
        return history.size();
    }
}
