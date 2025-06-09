package behavioral_patterns.command;

/**
 * Receiver Class: Knows how to perform the operations associated with carrying out a request.
 * Any class can serve as a Receiver.
 * In this example, a simple Light with on and off operations.
 */
public class Light {
    private String location; // e.g., "Living Room", "Kitchen"
    private boolean isOn = false;

    public Light(String location) {
        this.location = location;
    }

    public void turnOn() {
        if (!isOn) {
            isOn = true;
            System.out.println(location + " Light is ON");
        } else {
            System.out.println(location + " Light is already ON");
        }
    }

    public void turnOff() {
        if (isOn) {
            isOn = false;
            System.out.println(location + " Light is OFF");
        } else {
            System.out.println(location + " Light is already OFF");
        }
    }

    public boolean isOn() {
        return isOn;
    }

    public String getLocation() {
        return location;
    }
}
