package creational_patterns.abstract_factory;

/**
 * ConcreteFactory2: Implements the operations to create concrete product objects for MacOS.
 * It creates MacOSButton and MacOSCheckbox.
 */
public class MacOSFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new MacOSButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacOSCheckbox();
    }
}
