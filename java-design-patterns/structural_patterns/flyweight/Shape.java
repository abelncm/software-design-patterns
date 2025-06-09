package structural_patterns.flyweight;

import java.awt.Graphics; // Using AWT for a simple graphics context example

/**
 * Flyweight Interface: Declares the method(s) that clients will call to use the flyweight object.
 * These methods will accept extrinsic state (context-dependent data) as parameters.
 * In this example, a Shape that can be drawn.
 */
public interface Shape {
    /**
     * Draws the shape at a given position with a given size.
     * @param x The x-coordinate (extrinsic state).
     * @param y The y-coordinate (extrinsic state).
     * @param radius The radius of the shape (extrinsic state, specific to circle for this example).
     * @param graphics The graphics context to draw on (another piece of extrinsic state, or environment).
     */
    void draw(int x, int y, int radius, Graphics graphics);

    // Note: For a more general Shape flyweight, 'radius' might be replaced by more generic
    // 'width' and 'height', or a 'ShapeContext' object could be passed.
    // For this example, we'll focus on circles.
}
