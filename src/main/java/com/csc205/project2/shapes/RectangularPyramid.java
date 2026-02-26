/**
 * AI GENERATION DOCUMENTATION
 * ===========================
 * AI Tool Used: ChatGPT, GPT-5.2
 * Generation Date: 2/26/2026
 *
 * Original Prompt:
 * "Create RectangularPyramid.java with properties baseWidth
 * and baseHeight. It must extend Shape3D, implement the abstract
 * methods from ThreeDimensionalShape, include proper constructors
 * with validation, override the toString() with shape-specific
 * formatting, and include any other shape-specific methods as
 * needed."
 *
 * Follow-up Prompts (if any):
 * 1. "Sorry, the included properties in RectangularPyramid.java
 * should instead be baseLength, baseWidth, and height, where
 * baseLength is the length of the rectangular base, baseWidth is
 * the width of the rectangular base, and height is the height of
 * the pyramid. Please rewrite the class to correct this."
 * 2. "[Refinement prompt 2]"
 *
 * Manual Modifications:
 * - [List any changes you made to the AI output]
 * - [Explain why changes were necessary]
 *
 * Formula Verification:
 * - Volume formula verified against: https://testbook.com/maths/rectangular-pyramid
 * - Surface area formula verified against: https://testbook.com/maths/rectangular-pyramid
 */

package com.csc205.project2.shapes;

/**
 * Represents a three-dimensional rectangular pyramid.
 * <p>
 * A rectangular pyramid is defined by the length and width of its
 * rectangular base and its vertical height.
 */
public class RectangularPyramid extends Shape3D {

    /** Length of the rectangular base */
    private double baseLength;

    /** Width of the rectangular base */
    private double baseWidth;

    /** Vertical height of the pyramid */
    private double height;

    /**
     * Constructs a RectangularPyramid with specified dimensions, name, and color.
     *
     * @param baseLength length of the rectangular base
     * @param baseWidth  width of the rectangular base
     * @param height     vertical height of the pyramid
     * @param name       name of the shape
     * @param color      color of the shape
     * @throws IllegalArgumentException if any dimension is not positive
     */
    public RectangularPyramid(double baseLength, double baseWidth, double height,
                              String name, String color) {
        super(name, color);
        setBaseLength(baseLength);
        setBaseWidth(baseWidth);
        setHeight(height);
    }

    /**
     * Constructs a RectangularPyramid with specified dimensions.
     * Name defaults to "Rectangular Pyramid" and color to "Unknown".
     *
     * @param baseLength length of the rectangular base
     * @param baseWidth  width of the rectangular base
     * @param height     vertical height of the pyramid
     * @throws IllegalArgumentException if any dimension is not positive
     */
    public RectangularPyramid(double baseLength, double baseWidth, double height) {
        this(baseLength, baseWidth, height, "Rectangular Pyramid", "Unknown");
    }

    /**
     * Returns the base length of the pyramid.
     *
     * @return base length
     */
    public double getBaseLength() {
        return baseLength;
    }

    /**
     * Sets the base length of the pyramid.
     *
     * @param baseLength base length value
     * @throws IllegalArgumentException if baseLength is not positive
     */
    public void setBaseLength(double baseLength) {
        if (baseLength <= 0) {
            throw new IllegalArgumentException("Base length must be greater than zero.");
        }
        this.baseLength = baseLength;
    }

    /**
     * Returns the base width of the pyramid.
     *
     * @return base width
     */
    public double getBaseWidth() {
        return baseWidth;
    }

    /**
     * Sets the base width of the pyramid.
     *
     * @param baseWidth base width value
     * @throws IllegalArgumentException if baseWidth is not positive
     */
    public void setBaseWidth(double baseWidth) {
        if (baseWidth <= 0) {
            throw new IllegalArgumentException("Base width must be greater than zero.");
        }
        this.baseWidth = baseWidth;
    }

    /**
     * Returns the height of the pyramid.
     *
     * @return height
     */
    public double getHeight() {
        return height;
    }

    /**
     * Sets the height of the pyramid.
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
     * Calculates the slant height of the pyramid faces along the length.
     *
     * @return slant height along length
     */
    public double getSlantHeightLength() {
        return Math.sqrt(Math.pow(baseWidth / 2, 2) + Math.pow(height, 2));
    }

    /**
     * Calculates the slant height of the pyramid faces along the width.
     *
     * @return slant height along width
     */
    public double getSlantHeightWidth() {
        return Math.sqrt(Math.pow(baseLength / 2, 2) + Math.pow(height, 2));
    }

    /**
     * Calculates the surface area of the rectangular pyramid.
     *
     * @return surface area
     */
    @Override
    protected double calculateSurfaceArea() {
        double baseArea = baseLength * baseWidth;
        double lateralArea =
                baseLength * getSlantHeightLength() +
                        baseWidth * getSlantHeightWidth();
        return baseArea + lateralArea;
    }

    /**
     * Calculates the volume of the rectangular pyramid.
     *
     * @return volume
     */
    @Override
    protected double calculateVolume() {
        return (1.0 / 3.0) * baseLength * baseWidth * height;
    }

    /**
     * Returns a formatted string representation of the rectangular pyramid.
     *
     * @return formatted pyramid description
     */
    @Override
    public String toString() {
        return String.format(
                "%s [Base Length=%.2f, Base Width=%.2f, Height=%.2f, Color=%s, Surface Area=%.2f, Volume=%.2f]",
                getName(),
                baseLength,
                baseWidth,
                height,
                getColor(),
                getSurfaceArea(),
                getVolume()
        );
    }
}