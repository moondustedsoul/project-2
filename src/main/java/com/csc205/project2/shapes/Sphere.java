/**
 * AI GENERATION DOCUMENTATION
 * ===========================
 * AI Tool Used: ChatGPT, GPT-5.2
 * Generation Date: 2/26/2026
 *
 * Original Prompt:
 * "Create Sphere.java to create a sphere object. This class
 * includes a radius property. It must extend Shape3D, implement
 * the abstract methods from ThreeDimensionalShape, include
 * proper constructors with validation, override the toString()
 * with shape-specific formatting, and include any other
 * shape-specific methods as needed."
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
 * Represents a three-dimensional sphere.
 * <p>
 * A sphere is defined by its radius and provides implementations
 * for calculating surface area and volume.
 */
public class Sphere extends Shape3D {

    /** Radius of the sphere */
    private double radius;

    /**
     * Constructs a Sphere with a specified radius, name, and color.
     *
     * @param radius radius of the sphere
     * @param name   name of the shape
     * @param color  color of the shape
     * @throws IllegalArgumentException if radius is not positive
     */
    public Sphere(double radius, String name, String color) {
        super(name, color);
        setRadius(radius);
    }

    /**
     * Constructs a Sphere with a specified radius.
     * Name defaults to "Sphere" and color to "Unknown".
     *
     * @param radius radius of the sphere
     * @throws IllegalArgumentException if radius is not positive
     */
    public Sphere(double radius) {
        this(radius, "Sphere", "Unknown");
    }

    /**
     * Returns the radius of the sphere.
     *
     * @return radius
     */
    public double getRadius() {
        return radius;
    }

    /**
     * Sets the radius of the sphere.
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
     * Calculates the surface area of the sphere.
     *
     * @return surface area
     */
    @Override
    protected double calculateSurfaceArea() {
        return 4 * Math.PI * radius * radius;
    }

    /**
     * Calculates the volume of the sphere.
     *
     * @return volume
     */
    @Override
    protected double calculateVolume() {
        return (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
    }

    /**
     * Returns a formatted string representation of the sphere.
     *
     * @return formatted sphere description
     */
    @Override
    public String toString() {
        return String.format(
                "%s [Radius=%.2f, Color=%s, Surface Area=%.2f, Volume=%.2f]",
                getName(),
                radius,
                getColor(),
                getSurfaceArea(),
                getVolume()
        );
    }
}