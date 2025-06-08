package creational_patterns.abstract_factory;

/**
 * ConcreteProductA2: Implements the Button interface for MacOS style.
 */
public class MacOSButton implements Button {
    @Override
    public void paint() {
        System.out.println("Painting a MacOS style button.");
    }
}
