package creational_patterns.abstract_factory;

/**
 * ConcreteProductB2: Implements the Checkbox interface for MacOS style.
 */
public class MacOSCheckbox implements Checkbox {
    @Override
    public void render() {
        System.out.println("Rendering a MacOS style checkbox.");
    }
}
