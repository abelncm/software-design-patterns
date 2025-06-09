package behavioral_patterns.command;

/**
 * Command Interface: Declares a method for executing a particular action.
 * Optionally, an undo() method can also be declared.
 */
public interface Command {
    /**
     * Executes the command.
     */
    void execute();

    /**
     * Undoes the command.
     * (Optional, but good for demonstrating undoable operations)
     */
    void undo();
}
