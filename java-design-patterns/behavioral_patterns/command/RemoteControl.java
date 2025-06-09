package behavioral_patterns.command;

/**
 * Invoker Class: Holds one or more command objects and asks the command to carry out the request.
 * In this example, a simple remote control with one slot and an undo button.
 */
public class RemoteControl {
    private Command command; // A single command slot
    private Command lastCommandExecuted; // To keep track for undo functionality

    public RemoteControl() {
        // Initialize with a "do nothing" command or null,
        // for this example, we'll just leave it null until set.
        this.lastCommandExecuted = new NoCommand(); // Default to a null object pattern for undo
        this.command = new NoCommand(); // Default for the active slot
        System.out.println("RemoteControl: Initialized. Ready to accept commands.");
    }

    /**
     * Sets the command for the remote's button.
     * @param command The command to be set.
     */
    public void setCommand(Command command) {
        if (command == null) {
            this.command = new NoCommand(); // Avoid null pointer if command is null
            System.out.println("RemoteControl: Command slot cleared (set to NoCommand).");
        } else {
            this.command = command;
            System.out.println("RemoteControl: Command slot set to " + command.getClass().getSimpleName());
        }
    }

    /**
     * Simulates pressing the button, which executes the currently set command.
     */
    public void pressButton() {
        System.out.println("RemoteControl: Button pressed.");
        command.execute();
        lastCommandExecuted = command; // Store for undo
    }

    /**
     * Simulates pressing the undo button, which undoes the last executed command.
     */
    public void pressUndoButton() {
        System.out.println("RemoteControl: Undo button pressed.");
        lastCommandExecuted.undo();
        // Reset lastCommandExecuted to NoCommand to prevent multiple undos of the same command
        // without a new command execution in between (simple undo model).
        lastCommandExecuted = new NoCommand();
    }

    /**
     * NoCommand is a Null Object pattern implementation for Command.
     * It does nothing when executed or undone. Useful for unassigned slots or default undo.
     */
    private static class NoCommand implements Command {
        @Override
        public void execute() {
            System.out.println("NoCommand: Doing nothing (execute).");
        }
        @Override
        public void undo() {
            System.out.println("NoCommand: Doing nothing (undo).");
        }
    }
}
