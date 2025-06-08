package creational_patterns.abstract_factory;

/**
 * ConcreteFactory1: Implements the operations to create concrete product objects for Windows.
 * It creates WindowsButton and WindowsCheckbox.
 */
public class WindowsFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}
