package behavioral_patterns.command;

/**
 * ConcreteCommand A: Implements the Command interface to turn a light on.
 * It holds a reference to a Receiver object (Light) and calls its action.
 */
public class LightOnCommand implements Command {
    private Light light; // The Receiver of the request

    /**
     * Constructor for LightOnCommand.
     * @param light The Light object (Receiver) this command will operate on.
     */
    public LightOnCommand(Light light) {
        if (light == null) {
            throw new IllegalArgumentException("Light receiver cannot be null.");
        }
        this.light = light;
    }

    /**
     * Executes the command by calling the turnOn() action on the Light receiver.
     */
    @Override
    public void execute() {
        System.out.println("LightOnCommand: Executing -> turning light ON for " + light.getLocation());
        light.turnOn();
    }

    /**
     * Undoes the command by calling the turnOff() action on the Light receiver.
     */
    @Override
    public void undo() {
        System.out.println("LightOnCommand: Undoing -> turning light OFF for " + light.getLocation());
        light.turnOff();
    }
}
