package behavioral_patterns.command;

/**
 * ConcreteCommand B: Implements the Command interface to turn a light off.
 * It holds a reference to a Receiver object (Light) and calls its action.
 */
public class LightOffCommand implements Command {
    private Light light; // The Receiver of the request

    /**
     * Constructor for LightOffCommand.
     * @param light The Light object (Receiver) this command will operate on.
     */
    public LightOffCommand(Light light) {
        if (light == null) {
            throw new IllegalArgumentException("Light receiver cannot be null.");
        }
        this.light = light;
    }

    /**
     * Executes the command by calling the turnOff() action on the Light receiver.
     */
    @Override
    public void execute() {
        System.out.println("LightOffCommand: Executing -> turning light OFF for " + light.getLocation());
        light.turnOff();
    }

    /**
     * Undoes the command by calling the turnOn() action on the Light receiver.
     */
    @Override
    public void undo() {
        System.out.println("LightOffCommand: Undoing -> turning light ON for " + light.getLocation());
        light.turnOn();
    }
}
