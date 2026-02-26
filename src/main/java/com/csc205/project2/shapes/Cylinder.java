/**
 * AI GENERATION DOCUMENTATION
 * ===========================
 * AI Tool Used: ChatGPT, GPT-5.2
 * Generation Date: 2/26/2026
 *
 * Original Prompt:
 * "Create Cylinder.java with properties radius and height.
 * It must extend Shape3D, implement the abstract methods
 * from ThreeDimensionalShape, include proper constructors with
 * validation, override the toString() with shape-specific
 * formatting, and include any other shape-specific methods as
 * needed."
 *
 * Follow-up Prompts (if any):
 * 1. "[Refinement prompt 1]"
 * 2. "[Refinement prompt 2]"
 *
 * Manual Modifications:
 * - [List any changes you made to the AI output]
 * - [Explain why changes were necessary]
 *
 * Formula Verification:
 * - Volume formula verified against: README.md
 * - Surface area formula verified against: README.md
 */

package com.csc205.project2.shapes;

/**
 * Represents a three-dimensional cylinder.
 * <p>
 * A cylinder is defined by a circular base (radius) and a height and
 * provides implementations for calculating surface area and volume.
 */
public class Cylinder extends Shape3D {

    /** Radius of the circular base */
    private double radius;

    /** Height of the cylinder */
    private double height;

    /**
     * Constructs a Cylinder with specified radius, height, name, and color.
     *
     * @param radius radius of the base
     * @param height height of the cylinder
     * @param name   name of the shape
     * @param color  color of the shape
     * @throws IllegalArgumentException if radius or height is not positive
     */
    public Cylinder(double radius, double height, String name, String color) {
        super(name, color);
        setRadius(radius);
        setHeight(height);
    }

    /**
     * Constructs a Cylinder with specified radius and height.
     * Name defaults to "Cylinder" and color to "Unknown".
     *
     * @param radius radius of the base
     * @param height height of the cylinder
     * @throws IllegalArgumentException if radius or height is not positive
     */
    public Cylinder(double radius, double height) {
        this(radius, height, "Cylinder", "Unknown");
    }

    /**
     * Returns the radius of the cylinder.
     *
     * @return radius
     */
    public double getRadius() {
        return radius;
    }

    /**
     * Sets the radius of the cylinder.
     *
     * @param radius radius value
     * @throws IllegalArgumentException if radius is not positive
     */
    public void setRadius(double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("Radius must be greater than zero.");
        }
        this.radius = radius;
    }

    /**
     * Returns the height of the cylinder.
     *
     * @return height
     */
    public double getHeight() {
        return height;
    }

    /**
     * Sets the height of the cylinder.
     *
     * @param height height value
     * @throws IllegalArgumentException if height is not positive
     */
    public void setHeight(double height) {
        if (height <= 0) {
            throw new IllegalArgumentException("Height must be greater than zero.");
        }
        this.height = height;
    }

    /**
     * Calculates the surface area of the cylinder.
     *
     * @return surface area
     */
    @Override
    protected double calculateSurfaceArea() {
        return 2 * Math.PI * radius * (radius + height);
    }

    /**
     * Calculates the volume of the cylinder.
     *
     * @return volume
     */
    @Override
    protected double calculateVolume() {
        return Math.PI * radius * radius * height;
    }

    /**
     * Returns the lateral (side) surface area of the cylinder.
     *
     * @return lateral surface area
     */
    public double getLateralSurfaceArea() {
        return 2 * Math.PI * radius * height;
    }

    /**
     * Returns a formatted string representation of the cylinder.
     *
     * @return formatted cylinder description
     */
    @Override
    public String toString() {
        return String.format(
                "%s [Radius=%.2f, Height=%.2f, Color=%s, Surface Area=%.2f, Volume=%.2f]",
                getName(),
                radius,
                height,
                getColor(),
                getSurfaceArea(),
                getVolume()
        );
    }
}