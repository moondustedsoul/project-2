/**
 * AI GENERATION DOCUMENTATION
 * ===========================
 * AI Tool Used: ChatGPT, GPT-5.2
 * Generation Date: 2/26/2026
 *
 * Original Prompt:
 * "Create RectangularPrism.java with properties length, width,
 * and height. It must extend Shape3D, implement the abstract methods
 * from ThreeDimensionalShape, include proper constructors with
 * validation, override the toString() with shape-specific formatting,
 * and include any other shape-specific methods as needed."
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
 * Represents a three-dimensional rectangular prism.
 * <p>
 * A rectangular prism is defined by its length, width, and height and
 * provides implementations for calculating surface area and volume.
 */
public class RectangularPrism extends Shape3D {

    /** Length of the prism */
    private double length;

    /** Width of the prism */
    private double width;

    /** Height of the prism */
    private double height;

    /**
     * Constructs a RectangularPrism with specified dimensions, name, and color.
     *
     * @param length length of the prism
     * @param width  width of the prism
     * @param height height of the prism
     * @param name   name of the shape
     * @param color  color of the shape
     * @throws IllegalArgumentException if any dimension is not positive
     */
    public RectangularPrism(double length, double width, double height,
                            String name, String color) {
        super(name, color);
        setLength(length);
        setWidth(width);
        setHeight(height);
    }

    /**
     * Constructs a RectangularPrism with specified dimensions.
     * Name defaults to "Rectangular Prism" and color to "Unknown".
     *
     * @param length length of the prism
     * @param width  width of the prism
     * @param height height of the prism
     * @throws IllegalArgumentException if any dimension is not positive
     */
    public RectangularPrism(double length, double width, double height) {
        this(length, width, height, "Rectangular Prism", "Unknown");
    }

    /**
     * Returns the length of the prism.
     *
     * @return length
     */
    public double getLength() {
        return length;
    }

    /**
     * Sets the length of the prism.
     *
     * @param length length value
     * @throws IllegalArgumentException if length is not positive
     */
    public void setLength(double length) {
        if (length <= 0) {
            throw new IllegalArgumentException("Length must be greater than zero.");
        }
        this.length = length;
    }

    /**
     * Returns the width of the prism.
     *
     * @return width
     */
    public double getWidth() {
        return width;
    }

    /**
     * Sets the width of the prism.
     *
     * @param width width value
     * @throws IllegalArgumentException if width is not positive
     */
    public void setWidth(double width) {
        if (width <= 0) {
            throw new IllegalArgumentException("Width must be greater than zero.");
        }
        this.width = width;
    }

    /**
     * Returns the height of the prism.
     *
     * @return height
     */
    public double getHeight() {
        return height;
    }

    /**
     * Sets the height of the prism.
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
     * Calculates the surface area of the rectangular prism.
     *
     * @return surface area
     */
    @Override
    protected double calculateSurfaceArea() {
        return 2 * (length * width + length * height + width * height);
    }

    /**
     * Calculates the volume of the rectangular prism.
     *
     * @return volume
     */
    @Override
    protected double calculateVolume() {
        return length * width * height;
    }

    /**
     * Returns the area of one face of the prism given its dimensions.
     *
     * @param face specifies the face ("LW", "LH", or "WH")
     * @return face area
     * @throws IllegalArgumentException if face is invalid
     */
    public double getFaceArea(String face) {
        switch (face.toUpperCase()) {
            case "LW":
                return length * width;
            case "LH":
                return length * height;
            case "WH":
                return width * height;
            default:
                throw new IllegalArgumentException(
                        "Face must be \"LW\", \"LH\", or \"WH\"."
                );
        }
    }

    /**
     * Returns a formatted string representation of the rectangular prism.
     *
     * @return formatted rectangular prism description
     */
    @Override
    public String toString() {
        return String.format(
                "%s [Length=%.2f, Width=%.2f, Height=%.2f, Color=%s, Surface Area=%.2f, Volume=%.2f]",
                getName(),
                length,
                width,
                height,
                getColor(),
                getSurfaceArea(),
                getVolume()
        );
    }
}