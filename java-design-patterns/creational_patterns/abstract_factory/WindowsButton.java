package creational_patterns.abstract_factory;

/**
 * ConcreteProductA1: Implements the Button interface for Windows style.
 */
public class WindowsButton implements Button {
    @Override
    public void paint() {
        System.out.println("Painting a Windows style button.");
    }
}
