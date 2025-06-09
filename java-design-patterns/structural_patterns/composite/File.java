package structural_patterns.composite;

/**
 * Leaf Class: Represents an individual, non-composite object in the composition.
 * In this example, a File.
 * Leaf objects do not have children.
 */
public class File implements FileSystemComponent {
    private String name;
    private long size; // Size in bytes

    /**
     * Constructor for File.
     * @param name The name of the file.
     * @param size The size of the file in bytes.
     */
    public File(String name, long size) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("File name cannot be null or empty.");
        }
        if (size < 0) {
            throw new IllegalArgumentException("File size cannot be negative.");
        }
        this.name = name;
        this.size = size;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public long getSize() {
        return size;
    }

    @Override
    public void displayDetails(String indent) {
        System.out.println(indent + "- File: " + getName() + ", Size: " + getSize() + " bytes");
    }

    // Leaf nodes do not support adding/removing components.
    // If these methods were part of the FileSystemComponent interface with default
    // exceptions, we wouldn't need to explicitly override them here unless we wanted
    // different behavior. For now, assuming they are not in the interface directly
    // or will be handled by callers checking instance type.
    //
    // public void addComponent(FileSystemComponent component) {
    //     System.out.println("Cannot add to a file. Operation not supported.");
    // }
    // public void removeComponent(FileSystemComponent component) {
    //     System.out.println("Cannot remove from a file. Operation not supported.");
    // }
}
