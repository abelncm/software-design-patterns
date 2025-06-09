package behavioral_patterns.command;

/**
 * Client Class (Demo): Creates Receiver objects, ConcreteCommand objects (associating them with receivers),
 * and Invoker objects (associating them with commands). It then uses the Invoker to trigger command execution.
 */
public class CommandDemo {
    public static void main(String[] args) {
        System.out.println("--- Command Pattern Demo: Simple Remote Control ---");

        // Create Receiver objects
        Light livingRoomLight = new Light("Living Room");
        Light kitchenLight = new Light("Kitchen");

        // Create ConcreteCommand objects, associating them with Receivers
        Command livingRoomLightOn = new LightOnCommand(livingRoomLight);
        Command livingRoomLightOff = new LightOffCommand(livingRoomLight);
        Command kitchenLightOn = new LightOnCommand(kitchenLight);
        Command kitchenLightOff = new LightOffCommand(kitchenLight);

        // Create an Invoker object
        RemoteControl remote = new RemoteControl();

        // --- Test Living Room Light ---
        System.out.println("\n--- Testing Living Room Light ---");
        // Set the command for turning the living room light on and press the button
        remote.setCommand(livingRoomLightOn);
        remote.pressButton(); // Turns living room light ON
        System.out.println("Living Room Light is currently: " + (livingRoomLight.isOn() ? "ON" : "OFF"));

        // Press undo
        remote.pressUndoButton(); // Turns living room light OFF
        System.out.println("Living Room Light is currently (after undo): " + (livingRoomLight.isOn() ? "ON" : "OFF"));

        // Try to undo again (should do nothing as lastCommand was reset)
        System.out.println("\nAttempting to press undo again without new command execution:");
        remote.pressUndoButton();
        System.out.println("Living Room Light is currently (after second undo attempt): " + (livingRoomLight.isOn() ? "ON" : "OFF"));


        // Set the command for turning the living room light off and press the button
        System.out.println("\nSetting command to turn Living Room Light OFF:");
        remote.setCommand(livingRoomLightOff);
        remote.pressButton(); // Turns living room light OFF (it was already off from undo)
        System.out.println("Living Room Light is currently: " + (livingRoomLight.isOn() ? "ON" : "OFF"));

        // Turn it on first to see off command work properly
        System.out.println("\nManually turning Living Room Light ON for next test:");
        livingRoomLight.turnOn(); // Manually turn it on
        System.out.println("Living Room Light is currently: " + (livingRoomLight.isOn() ? "ON" : "OFF"));

        remote.pressButton(); // Should now turn it OFF via command
        System.out.println("Living Room Light is currently (after OFF command): " + (livingRoomLight.isOn() ? "ON" : "OFF"));

        // Press undo
        remote.pressUndoButton(); // Turns living room light ON
        System.out.println("Living Room Light is currently (after undo): " + (livingRoomLight.isOn() ? "ON" : "OFF"));


        // --- Test Kitchen Light ---
        System.out.println("\n--- Testing Kitchen Light ---");
        remote.setCommand(kitchenLightOn);
        remote.pressButton(); // Turns kitchen light ON
        System.out.println("Kitchen Light is currently: " + (kitchenLight.isOn() ? "ON" : "OFF"));

        remote.setCommand(kitchenLightOff); // Now set remote to Kitchen Light OFF
        remote.pressButton(); // Turns kitchen light OFF
        System.out.println("Kitchen Light is currently: " + (kitchenLight.isOn() ? "ON" : "OFF"));

        // Undo the last command (Kitchen Light OFF)
        remote.pressUndoButton(); // Should turn Kitchen Light ON
        System.out.println("Kitchen Light is currently (after undo): " + (kitchenLight.isOn() ? "ON" : "OFF"));

        System.out.println("\n--- Command Pattern Demo Finished ---");
    }
}
