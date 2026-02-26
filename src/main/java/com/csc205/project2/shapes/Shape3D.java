package com.csc205.project2.shapes;

/**
 * Abstract base class for all three-dimensional shapes.
 * <p>
 * This class implements the {@link ThreeDimensionalShape} interface and
 * provides common fields, validation, and formatting logic shared by
 * all 3D shapes.
 */
public abstract class Shape3D implements ThreeDimensionalShape {

    /** Name of the shape (e.g., "Sphere", "Cube"). */
    private String name;

    /** Color of the shape. */
    private String color;

    /**
     * Constructs a Shape3D with a name and color.
     *
     * @param name  the name of the shape
     * @param color the color of the shape
     * @throws IllegalArgumentException if name or color is null or blank
     */
    public Shape3D(String name, String color) {
        setName(name);
        setColor(color);
    }

    /**
     * Default constructor.
     * Initializes name and color to "Unknown".
     */
    public Shape3D() {
        this("Unknown", "Unknown");
    }

    /**
     * Returns the surface area of the shape.
     *
     * @return surface area
     */
    @Override
    public double getSurfaceArea() {
        return calculateSurfaceArea();
    }

    /**
     * Returns the volume of the shape.
     *
     * @return volume
     */
    @Override
    public double getVolume() {
        return calculateVolume();
    }

    /**
     * Calculates the surface area of the shape.
     * Must be implemented by subclasses.
     *
     * @return surface area
     */
    protected abstract double calculateSurfaceArea();

    /**
     * Calculates the volume of the shape.
     * Must be implemented by subclasses.
     *
     * @return volume
     */
    protected abstract double calculateVolume();

    /**
     * Returns the name of the shape.
     *
     * @return shape name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the shape.
     *
     * @param name the shape name
     * @throws IllegalArgumentException if name is null or blank
     */
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Shape name cannot be null or blank.");
        }
        this.name = name.trim();
    }

    /**
     * Returns the color of the shape.
     *
     * @return shape color
     */
    public String getColor() {
        return color;
    }

    /**
     * Sets the color of the shape.
     *
     * @param color the shape color
     * @throws IllegalArgumentException if color is null or blank
     */
    public void setColor(String color) {
        if (color == null || color.trim().isEmpty()) {
            throw new IllegalArgumentException("Shape color cannot be null or blank.");
        }
        this.color = color.trim();
    }

    /**
     * Returns a formatted string representation of the shape.
     *
     * @return formatted shape description
     */
    @Override
    public String toString() {
        return String.format(
                "%s [Color=%s, Surface Area=%.2f, Volume=%.2f]",
                name,
                color,
                getSurfaceArea(),
                getVolume()
        );
    }
}