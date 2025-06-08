package creational_patterns.prototype;

import java.util.Objects;

/**
 * Prototype: Abstract class defining the cloning method.
 * Implements Cloneable to allow basic shallow copying via Object.clone().
 * Concrete prototypes will extend this class.
 */
public abstract class Shape implements Cloneable {
    private String id;
    protected String type; // e.g., "Circle", "Rectangle"
    private String color; // Example of a mutable field if it were an object, or a simple field

    public Shape(String id) {
        this.id = id;
    }

    // Abstract method to be implemented by concrete shapes
    public abstract void draw();

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Overrides Object.clone().
     * This provides a shallow copy by default.
     * Concrete subclasses might need to override this further for deep copying
     * if they have mutable complex fields.
     */
    @Override
    public Object clone() {
        Object clone = null;
        try {
            clone = super.clone(); // Performs a shallow copy
        } catch (CloneNotSupportedException e) {
            // This should not happen because Shape implements Cloneable
            e.printStackTrace();
        }
        return clone;
    }

    // For deep copy in subclasses, a copy constructor is often a good pattern.
    // This constructor is for use by subclasses during their cloning process.
    public Shape(Shape target) {
        if (target != null) {
            this.id = target.id + "_clone"; // Ensure cloned ID is different for clarity
            this.type = target.type;
            this.color = target.color; // String is immutable, so shallow copy is fine here.
                                       // If color were a mutable object, deep copy would be needed:
                                       // this.color = new MutableColor(target.color.getValues());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shape shape = (Shape) o;
        return Objects.equals(id, shape.id) &&
               Objects.equals(type, shape.type) &&
               Objects.equals(color, shape.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, color);
    }
}
