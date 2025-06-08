package creational_patterns.factory_method;

/**
 * Product interface: Defines the interface for objects the factory method creates.
 */
public interface Document {
    void open();
    void close();
    void save();
    String getName();
}
