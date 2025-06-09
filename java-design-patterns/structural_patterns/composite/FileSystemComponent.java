package structural_patterns.composite;

/**
 * Component Interface: Defines the common interface for all objects in the composition,
 * both leaves (Files) and composites (Directories).
 */
public interface FileSystemComponent {
    /**
     * Displays the details of the file system component, such as name and size.
     * @param indent The indentation string to use for hierarchical display.
     */
    void displayDetails(String indent);

    /**
     * Calculates the total size of the component.
     * For a file, it's its own size. For a directory, it's the sum of its children's sizes.
     * @return The size of the component in bytes.
     */
    long getSize();

    /**
     * Gets the name of the component.
     * @return The name of the file or directory.
     */
    String getName();

    // Optional: Methods for managing children.
    // These might have default implementations or throw UnsupportedOperationException in the interface
    // if using Java 8+ default methods, or be left for concrete classes to implement.
    // For simplicity, we'll define them in the Composite class (Directory)
    // and Leaf classes (File) will not have them or will have specific behavior if called.
    //
    // default void addComponent(FileSystemComponent component) {
    //     throw new UnsupportedOperationException("Cannot add to a leaf component.");
    // }
    // default void removeComponent(FileSystemComponent component) {
    //     throw new UnsupportedOperationException("Cannot remove from a leaf component.");
    // }
    // default FileSystemComponent getChild(int i) {
    //     throw new UnsupportedOperationException("Cannot get child from a leaf component.");
    // }
}
