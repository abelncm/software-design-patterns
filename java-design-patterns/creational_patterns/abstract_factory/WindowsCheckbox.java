package creational_patterns.abstract_factory;

/**
 * ConcreteProductB1: Implements the Checkbox interface for Windows style.
 */
public class WindowsCheckbox implements Checkbox {
    @Override
    public void render() {
        System.out.println("Rendering a Windows style checkbox.");
    }
}
