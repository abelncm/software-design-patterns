package creational_patterns.prototype;

import java.util.Objects;

/**
 * ConcretePrototype: Implements the Shape prototype for a Circle.
 */
public class Circle extends Shape {
    private int radius;
    // Example of a mutable object field that would require deep copying if modified after cloning.
    // For simplicity, we'll keep it as a primitive for now, but illustrate the point.
    // private SomeMutableObject complexField;

    public Circle(String id, int radius) {
        super(id);
        this.type = "Circle";
        this.radius = radius;
        // this.complexField = new SomeMutableObject();
        System.out.println("Circle created with id: " + id + ", radius: " + radius);
    }

    /**
     * Copy constructor: Used for creating a new instance from an existing one.
     * This is a common pattern for managing the cloning process, especially for deep copies.
     * @param target The Circle object to copy.
     */
    public Circle(Circle target) {
        super(target); // Calls Shape's copy constructor to copy common fields (id, type, color)
        if (target != null) {
            this.radius = target.radius;
            // For deep copy of mutable fields:
            // this.complexField = new SomeMutableObject(target.complexField.getValues());
            System.out.println("Circle cloned from id: " + target.getId() + " to new id: " + this.getId());
        }
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("Drawing a Circle with radius " + radius + ", color " + getColor() + ", ID: " + getId());
    }

    /**
     * Clone method specific to Circle.
     * It uses the copy constructor to ensure proper copying of Circle's fields.
     * If Shape.clone() was sufficient (e.g., only primitive/immutable fields and shallow copy is OK),
     * this explicit override might not be strictly necessary if super.clone() is called and cast.
     * However, using the copy constructor makes the intent clear and handles deep copy logic if needed.
     */
    @Override
    public Shape clone() {
        // For a simple case where Shape.clone() (shallow copy) is enough for Shape's fields,
        // and Circle only has primitive/immutable fields, super.clone() could be used and then cast.
        // However, using a copy constructor is more robust for potential deep copy needs.
        return new Circle(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false; // Check superclass fields
        Circle circle = (Circle) o;
        return radius == circle.radius;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), radius);
    }
}
