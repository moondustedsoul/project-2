/**
 * AI GENERATION DOCUMENTATION
 * ===========================
 * AI Tool Used: ChatGPT, GPT-5.2
 * Generation Date: 2/26/2026
 *
 * Original Prompt:
 * "Create Cube.java with property sideLength. It must extend
 * Shape3D, implement the abstract methods from ThreeDimensionalShape,
 * include proper constructors with validation, override the toString()
 * with shape-specific formatting, and include any other shape-specific
 * methods as needed."
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
 * Represents a three-dimensional cube.
 * <p>
 * A cube is defined by the length of its sides and provides
 * implementations for calculating surface area and volume.
 */
public class Cube extends Shape3D {

    /** Length of one side of the cube */
    private double sideLength;

    /**
     * Constructs a Cube with a specified side length, name, and color.
     *
     * @param sideLength length of each side of the cube
     * @param name       name of the shape
     * @param color      color of the shape
     * @throws IllegalArgumentException if sideLength is not positive
     */
    public Cube(double sideLength, String name, String color) {
        super(name, color);
        setSideLength(sideLength);
    }

    /**
     * Constructs a Cube with a specified side length.
     * Name defaults to "Cube" and color to "Unknown".
     *
     * @param sideLength length of each side of the cube
     * @throws IllegalArgumentException if sideLength is not positive
     */
    public Cube(double sideLength) {
        this(sideLength, "Cube", "Unknown");
    }

    /**
     * Returns the side length of the cube.
     *
     * @return side length
     */
    public double getSideLength() {
        return sideLength;
    }

    /**
     * Sets the side length of the cube.
     *
     * @param sideLength length value
     * @throws IllegalArgumentException if sideLength is not positive
     */
    public void setSideLength(double sideLength) {
        if (sideLength <= 0) {
            throw new IllegalArgumentException("Side length must be greater than zero.");
        }
        this.sideLength = sideLength;
    }

    /**
     * Calculates the surface area of the cube.
     *
     * @return surface area
     */
    @Override
    protected double calculateSurfaceArea() {
        return 6 * sideLength * sideLength;
    }

    /**
     * Calculates the volume of the cube.
     *
     * @return volume
     */
    @Override
    protected double calculateVolume() {
        return Math.pow(sideLength, 3);
    }

    /**
     * Returns a formatted string representation of the cube.
     *
     * @return formatted cube description
     */
    @Override
    public String toString() {
        return String.format(
                "%s [Side Length=%.2f, Color=%s, Surface Area=%.2f, Volume=%.2f]",
                getName(),
                sideLength,
                getColor(),
                getSurfaceArea(),
                getVolume()
        );
    }
}