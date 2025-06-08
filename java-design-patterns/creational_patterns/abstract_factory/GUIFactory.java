package creational_patterns.abstract_factory;

/**
 * AbstractFactory: Declares an interface for operations that create abstract product objects.
 * It will have methods to create Buttons and Checkboxes.
 */
public interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}
