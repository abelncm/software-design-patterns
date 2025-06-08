package creational_patterns.prototype;

import java.util.Objects;

/**
 * ConcretePrototype: Implements the Shape prototype for a Rectangle.
 */
public class Rectangle extends Shape {
    private int width;
    private int height;

    public Rectangle(String id, int width, int height) {
        super(id);
        this.type = "Rectangle";
        this.width = width;
        this.height = height;
        System.out.println("Rectangle created with id: " + id + ", width: " + width + ", height: " + height);
    }

    /**
     * Copy constructor for Rectangle.
     * @param target The Rectangle object to copy.
     */
    public Rectangle(Rectangle target) {
        super(target); // Calls Shape's copy constructor
        if (target != null) {
            this.width = target.width;
            this.height = target.height;
            System.out.println("Rectangle cloned from id: " + target.getId() + " to new id: " + this.getId());
        }
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public void draw() {
        System.out.println("Drawing a Rectangle with width " + width + ", height " + height + ", color " + getColor() + ", ID: " + getId());
    }

    /**
     * Clone method specific to Rectangle.
     * Uses the copy constructor for proper copying.
     */
    @Override
    public Shape clone() {
        return new Rectangle(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Rectangle rectangle = (Rectangle) o;
        return width == rectangle.width && height == rectangle.height;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), width, height);
    }
}
