package structural_patterns.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * Composite Class: Represents a composite object that can contain other components
 * (leaves or other composites). In this example, a Directory.
 */
public class Directory implements FileSystemComponent {
    private String name;
    private List<FileSystemComponent> children = new ArrayList<>();

    /**
     * Constructor for Directory.
     * @param name The name of the directory.
     */
    public Directory(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Directory name cannot be null or empty.");
        }
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    /**
     * Calculates the total size of the directory by summing the sizes of its children.
     * @return The total size of the directory and its contents in bytes.
     */
    @Override
    public long getSize() {
        long totalSize = 0;
        for (FileSystemComponent component : children) {
            totalSize += component.getSize();
        }
        return totalSize;
    }

    /**
     * Displays the details of the directory and recursively displays details of its children.
     * @param indent The indentation string for hierarchical display.
     */
    @Override
    public void displayDetails(String indent) {
        System.out.println(indent + "+ Directory: " + getName() + " (Total Size: " + getSize() + " bytes)");
        String childIndent = indent + "  "; // Increase indent for children
        for (FileSystemComponent component : children) {
            component.displayDetails(childIndent);
        }
    }

    /**
     * Adds a component (file or subdirectory) to this directory.
     * @param component The FileSystemComponent to add.
     */
    public void addComponent(FileSystemComponent component) {
        if (component != null) {
            children.add(component);
        }
    }

    /**
     * Removes a component from this directory.
     * @param component The FileSystemComponent to remove.
     * @return true if the component was removed, false otherwise.
     */
    public boolean removeComponent(FileSystemComponent component) {
        return children.remove(component);
    }

    /**
     * Gets a child component by index.
     * @param index The index of the child component.
     * @return The FileSystemComponent at the specified index, or null if index is out of bounds.
     */
    public FileSystemComponent getChild(int index) {
        if (index >= 0 && index < children.size()) {
            return children.get(index);
        }
        return null;
    }

    /**
     * Gets all children of this directory.
     * @return A list of child components.
     */
    public List<FileSystemComponent> getChildren() {
        return new ArrayList<>(children); // Return a copy to prevent external modification
    }
}
