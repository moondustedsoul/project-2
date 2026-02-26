# AI Interaction Log

This document serves as a log of interactions with AI systems, capturing prompts, responses, and reflections on the outcomes. It is intended to help users track their engagements with AI and improve future interactions.

## Shape3D.java
**Prompt:**
> I am given the following Java Interface:  
> 
> package com.csc205.project2.shapes;  
> 
> public interface ThreeDimensionalShape {  
> 
> double getSurfaceArea();  
> double getVolume();  
> 
> }  
> 
> Using this Interface, create Shape3D.java that implements the interface, creates concrete implementations of getVolume() and getSurfaceArea() that call abstract methods, includes common private properties name (a String) and color (a String) with public getters and setters, includes constructors for initialization, implements a toString() method to format output consistently, and includes getter and setter methods where appropriate. Please also include proper JavaDoc documentation and input validation where appropriate.

**Response:**
> Below is a clean, well-documented **abstract base class** `Shape3D.java` that implements your `ThreeDimensionalShape` interface exactly as requested.
>
> Key design choices (briefly explained after the code):
>
> * `getSurfaceArea()` and `getVolume()` are **concrete** and delegate to **abstract** methods.
> * Common fields `name` and `color` are private with validation.
> * Multiple constructors are provided.
> * `toString()` is standardized and reusable by subclasses.
> * JavaDoc is included throughout.
>
> ---
>
> ### `Shape3D.java`
>
> ```java
> package com.csc205.project2.shapes;
>
> /**
> * Abstract base class for all three-dimensional shapes.
> * <p>
> * This class implements the {@link ThreeDimensionalShape} interface and
> * provides common fields, validation, and formatting logic shared by
> * all 3D shapes.
> */
> public abstract class Shape3D implements ThreeDimensionalShape {
>
>    /** Name of the shape (e.g., "Sphere", "Cube"). */
>    private String name;
>
>    /** Color of the shape. */
>    private String color;
>
>    /**
>     * Constructs a Shape3D with a name and color.
>     *
>     * @param name  the name of the shape
>     * @param color the color of the shape
>     * @throws IllegalArgumentException if name or color is null or blank
>     */
>    public Shape3D(String name, String color) {
>        setName(name);
>        setColor(color);
>    }
>
>    /**
>     * Default constructor.
>     * Initializes name and color to "Unknown".
>     */
>    public Shape3D() {
>        this("Unknown", "Unknown");
>    }
>
>    /**
>     * Returns the surface area of the shape.
>     *
>     * @return surface area
>     */
>    @Override
>    public double getSurfaceArea() {
>        return calculateSurfaceArea();
>    }
>
>    /**
>     * Returns the volume of the shape.
>     *
>     * @return volume
>     */
>    @Override
>    public double getVolume() {
>        return calculateVolume();
>    }
>
>    /**
>     * Calculates the surface area of the shape.
>     * Must be implemented by subclasses.
>     *
>     * @return surface area
>     */
>    protected abstract double calculateSurfaceArea();
>
>    /**
>     * Calculates the volume of the shape.
>     * Must be implemented by subclasses.
>     *
>     * @return volume
>     */
>    protected abstract double calculateVolume();
>
>    /**
>     * Returns the name of the shape.
>     *
>     * @return shape name
>     */
>    public String getName() {
>        return name;
>    }
>
>    /**
>     * Sets the name of the shape.
>     *
>     * @param name the shape name
>     * @throws IllegalArgumentException if name is null or blank
>     */
>    public void setName(String name) {
>        if (name == null || name.trim().isEmpty()) {
>            throw new IllegalArgumentException("Shape name cannot be null or blank.");
>        }
>        this.name = name.trim();
>    }
>
>    /**
>     * Returns the color of the shape.
>     *
>     * @return shape color
>     */
>    public String getColor() {
>        return color;
>    }
>
>    /**
>     * Sets the color of the shape.
>     *
>     * @param color the shape color
>     * @throws IllegalArgumentException if color is null or blank
>     */
>    public void setColor(String color) {
>        if (color == null || color.trim().isEmpty()) {
>            throw new IllegalArgumentException("Shape color cannot be null or blank.");
>        }
>        this.color = color.trim();
>    }
>
>    /**
>     * Returns a formatted string representation of the shape.
>     *
>     * @return formatted shape description
>     */
>    @Override
>    public String toString() {
>        return String.format(
>                "%s [Color=%s, Surface Area=%.2f, Volume=%.2f]",
>                name,
>                color,
>                getSurfaceArea(),
>                getVolume()
>        );
>    }
> }
> ```
>
> ---
>
> ### Why this design works well
>
> * **Template Method pattern**: shared logic in `getSurfaceArea()` / `getVolume()`, shape-specific math in subclasses.
> * **Validation centralized**: prevents invalid state early.
> * **Reusable formatting**: consistent output across all shapes.
> * **Instructor-friendly**: follows standard OOP conventions often expected in CSC coursework.
>
> If you want, I can also:
>
> * Create an example subclass (Sphere, Cube, Cylinder)
> * Adjust formatting to match a specific assignment output
> * Remove setters to make it immutable
> * Add unit tests
>
> Just say the word 🙂

## Shapes

### Sphere.java
**Prompt:**
> Create Sphere.java to create a sphere object. This class includes a radius property. It must extend Shape3D, implement the abstract methods from ThreeDimensionalShape, inlcude proper constructors with validation, override the toString() with shape-specific formatting, and include any other shape-specific methods as needed.

**Response:**
> Below is a complete, **clean**, and **assignment-ready** implementation of `Sphere.java` that extends your `Shape3D` abstract class and fulfills all stated requirements.
>
> ---
>
> ### `Sphere.java`
>
> ```java
> package com.csc205.project2.shapes;  
>   
> /**  
>  * Represents a three-dimensional sphere.  
>  * <p>  
>  * A sphere is defined by its radius and provides implementations  
>  * for calculating surface area and volume.  
>  */  
> public class Sphere extends Shape3D {  
>   
>     /** Radius of the sphere */  
>     private double radius;  
>   
>     /**  
>      * Constructs a Sphere with a specified radius, name, and color.  
>      *  
>      * @param radius radius of the sphere  
>      * @param name   name of the shape  
>      * @param color  color of the shape  
>      * @throws IllegalArgumentException if radius is not positive  
>      */  
>     public Sphere(double radius, String name, String color) {  
>         super(name, color);  
>         setRadius(radius);  
>     }  
>   
>     /**  
>      * Constructs a Sphere with a specified radius.  
>      * Name defaults to "Sphere" and color to "Unknown".  
>      *  
>      * @param radius radius of the sphere  
>      * @throws IllegalArgumentException if radius is not positive  
>      */  
>     public Sphere(double radius) {  
>         this(radius, "Sphere", "Unknown");  
>     }  
>   
>     /**  
>      * Returns the radius of the sphere.  
>      *  
>      * @return radius  
>      */  
>     public double getRadius() {  
>         return radius;  
>     }  
>   
>     /**  
>      * Sets the radius of the sphere.  
>      *  
>      * @param radius radius value  
>      * @throws IllegalArgumentException if radius is not positive  
>      */  
>     public void setRadius(double radius) {  
>         if (radius <= 0) {  
>             throw new IllegalArgumentException("Radius must be greater than zero.");  
>         }  
>         this.radius = radius;  
>     }  
>   
>     /**  
>      * Calculates the surface area of the sphere.  
>      *  
>      * @return surface area  
>      */  
>     @Override  
>     protected double calculateSurfaceArea() {  
>         return 4 * Math.PI * radius * radius;  
>     }  
>   
>     /**  
>      * Calculates the volume of the sphere.  
>      *  
>      * @return volume  
>      */  
>     @Override  
>     protected double calculateVolume() {  
>         return (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);  
>     }  
>   
>     /**  
>      * Returns a formatted string representation of the sphere.  
>      *  
>      * @return formatted sphere description  
>      */  
>     @Override  
>     public String toString() {  
>         return String.format(  
>                 "%s [Radius=%.2f, Color=%s, Surface Area=%.2f, Volume=%.2f]",  
>                 getName(),  
>                 radius,  
>                 getColor(),  
>                 getSurfaceArea(),  
>                 getVolume()  
>         );  
>     }  
> }  
> ```
>
> ---
>
> ### Notes on design
>
> * ✔ **Extends `Shape3D`** and implements required abstract methods
> * ✔ **Input validation** prevents invalid radius values
> * ✔ **Overrides `toString()`** with sphere-specific formatting
> * ✔ **Multiple constructors** for flexibility
> * ✔ Uses `Math.PI` and `Math.pow()` for clarity and correctness
>
> If you want, I can:
>
> * Match a *specific output format* your professor requires
> * Create additional shapes (Cube, Cylinder, Cone)
> * Add unit tests or a driver (`Main.java`)
> * Make the class immutable (no setters)
>
> Just let me know.

### Cube.java
**Prompt:**
> Create Cube.java with property sideLength. It must extend Shape3D, implement the abstract methods from ThreeDimensionalShape, include proper constructors with validation, override the toString() with shape-specific formatting, and include any other shape-specific methods as needed.

**Response:**
> Here is a **complete and consistent `Cube.java` implementation** that matches your `Shape3D` and `Sphere` design, follows good OOP practices, and should integrate cleanly into your project.
>
> ---
>
> ### `Cube.java`
>
> ```java
> package com.csc205.project2.shapes;  
>   
> /**  
>  * Represents a three-dimensional cube.  
>  * <p>  
>  * A cube is defined by the length of its sides and provides  
>  * implementations for calculating surface area and volume.  
>  */  
> public class Cube extends Shape3D {  
>   
>     /** Length of one side of the cube */  
>     private double sideLength;  
>   
>     /**  
>      * Constructs a Cube with a specified side length, name, and color.  
>      *  
>      * @param sideLength length of each side of the cube  
>      * @param name       name of the shape  
>      * @param color      color of the shape  
>      * @throws IllegalArgumentException if sideLength is not positive  
>      */  
>     public Cube(double sideLength, String name, String color) {  
>         super(name, color);  
>         setSideLength(sideLength);  
>     }  
>   
>     /**  
>      * Constructs a Cube with a specified side length.  
>      * Name defaults to "Cube" and color to "Unknown".  
>      *  
>      * @param sideLength length of each side of the cube  
>      * @throws IllegalArgumentException if sideLength is not positive  
>      */  
>     public Cube(double sideLength) {  
>         this(sideLength, "Cube", "Unknown");  
>     }  
>   
>     /**  
>      * Returns the side length of the cube.  
>      *  
>      * @return side length  
>      */  
>     public double getSideLength() {  
>         return sideLength;  
>     }  
>   
>     /**  
>      * Sets the side length of the cube.  
>      *  
>      * @param sideLength length value  
>      * @throws IllegalArgumentException if sideLength is not positive  
>      */  
>     public void setSideLength(double sideLength) {  
>         if (sideLength <= 0) {  
>             throw new IllegalArgumentException("Side length must be greater than zero.");  
>         }  
>         this.sideLength = sideLength;  
>     }  
>   
>     /**  
>      * Calculates the surface area of the cube.  
>      *  
>      * @return surface area  
>      */  
>     @Override  
>     protected double calculateSurfaceArea() {  
>         return 6 * sideLength * sideLength;  
>     }  
>   
>     /**  
>      * Calculates the volume of the cube.  
>      *  
>      * @return volume  
>      */  
>     @Override  
>     protected double calculateVolume() {  
>         return Math.pow(sideLength, 3);  
>     }  
>   
>     /**  
>      * Returns a formatted string representation of the cube.  
>      *  
>      * @return formatted cube description  
>      */  
>     @Override  
>     public String toString() {  
>         return String.format(  
>                 "%s [Side Length=%.2f, Color=%s, Surface Area=%.2f, Volume=%.2f]",  
>                 getName(),  
>                 sideLength,  
>                 getColor(),  
>                 getSurfaceArea(),  
>                 getVolume()  
>         );  
>     }  
> }  
> ```
>
> ---
>
> ### Why this fits perfectly with your project
>
> * ✔ Consistent with `Shape3D`, `Sphere`, and interface design
> * ✔ Strong validation for shape dimensions
> * ✔ Clear JavaDoc for grading and maintainability
> * ✔ Shape-specific `toString()` formatting
> * ✔ Easy to extend later (e.g., `getFaceArea()` if needed)
>
> If you’d like, I can:
>
> * Add a `Cylinder` or `Cone`
> * Create a test driver to print all shapes
> * Refactor `toString()` formats to exactly match assignment output
> * Help package everything for submission
>
> Just tell me what’s next 👍

### Cylinder.java
**Prompt:**
> Create Cylinder.java with properties radius and height. It must extend Shape3D, implement the abstract methods from ThreeDimensionalShape, include proper constructors with validation, override the toString() with shape-specific formatting, and include any other shape-specific methods as needed.

**Response:**
> Here is a **complete `Cylinder.java` implementation** that fits seamlessly with your existing `Shape3D`, `Sphere`, and `Cube` classes and follows the same conventions and formatting style.
>
> ---
>
> ### `Cylinder.java`
>
> ```java
> package com.csc205.project2.shapes;  
>   
> /**  
>  * Represents a three-dimensional cylinder.  
>  * <p>  
>  * A cylinder is defined by a circular base (radius) and a height and  
>  * provides implementations for calculating surface area and volume.  
>  */  
> public class Cylinder extends Shape3D {  
>   
>     /** Radius of the circular base */  
>     private double radius;  
>   
>     /** Height of the cylinder */  
>     private double height;  
>   
>     /**  
>      * Constructs a Cylinder with specified radius, height, name, and color.  
>      *  
>      * @param radius radius of the base  
>      * @param height height of the cylinder  
>      * @param name   name of the shape  
>      * @param color  color of the shape  
>      * @throws IllegalArgumentException if radius or height is not positive  
>      */  
>     public Cylinder(double radius, double height, String name, String color) {  
>         super(name, color);  
>         setRadius(radius);  
>         setHeight(height);  
>     }  
>   
>     /**  
>      * Constructs a Cylinder with specified radius and height.  
>      * Name defaults to "Cylinder" and color to "Unknown".  
>      *  
>      * @param radius radius of the base  
>      * @param height height of the cylinder  
>      * @throws IllegalArgumentException if radius or height is not positive  
>      */  
>     public Cylinder(double radius, double height) {  
>         this(radius, height, "Cylinder", "Unknown");  
>     }  
>   
>     /**  
>      * Returns the radius of the cylinder.  
>      *  
>      * @return radius  
>      */  
>     public double getRadius() {  
>         return radius;  
>     }  
>   
>     /**  
>      * Sets the radius of the cylinder.  
>      *  
>      * @param radius radius value  
>      * @throws IllegalArgumentException if radius is not positive  
>      */  
>     public void setRadius(double radius) {  
>         if (radius <= 0) {  
>             throw new IllegalArgumentException("Radius must be greater than zero.");  
>         }  
>         this.radius = radius;  
>     }  
>   
>     /**  
>      * Returns the height of the cylinder.  
>      *  
>      * @return height  
>      */  
>     public double getHeight() {  
>         return height;  
>     }  
>   
>     /**  
>      * Sets the height of the cylinder.  
>      *  
>      * @param height height value  
>      * @throws IllegalArgumentException if height is not positive  
>      */  
>     public void setHeight(double height) {  
>         if (height <= 0) {  
>             throw new IllegalArgumentException("Height must be greater than zero.");  
>         }  
>         this.height = height;  
>     }  
>   
>     /**  
>      * Calculates the surface area of the cylinder.  
>      *  
>      * @return surface area  
>      */  
>     @Override  
>     protected double calculateSurfaceArea() {  
>         return 2 * Math.PI * radius * (radius + height);  
>     }  
>   
>     /**  
>      * Calculates the volume of the cylinder.  
>      *  
>      * @return volume  
>      */  
>     @Override  
>     protected double calculateVolume() {  
>         return Math.PI * radius * radius * height;  
>     }  
>   
>     /**  
>      * Returns the lateral (side) surface area of the cylinder.  
>      *  
>      * @return lateral surface area  
>      */  
>     public double getLateralSurfaceArea() {  
>         return 2 * Math.PI * radius * height;  
>     }  
>   
>     /**  
>      * Returns a formatted string representation of the cylinder.  
>      *  
>      * @return formatted cylinder description  
>      */  
>     @Override  
>     public String toString() {  
>         return String.format(  
>                 "%s [Radius=%.2f, Height=%.2f, Color=%s, Surface Area=%.2f, Volume=%.2f]",  
>                 getName(),  
>                 radius,  
>                 height,  
>                 getColor(),  
>                 getSurfaceArea(),  
>                 getVolume()  
>         );  
>     }  
> }  
> ```
>
> ---
>
> ### Consistency check with your project
>
> * ✔ Matches `Shape3D` abstraction and method signatures
> * ✔ Uses consistent validation patterns with `Sphere` and `Cube`
> * ✔ Includes a **shape-specific method** (`getLateralSurfaceArea()`)
> * ✔ Uses clear, grader-friendly JavaDoc
> * ✔ Consistent `toString()` formatting across all shapes
>
> If you want, the next logical steps could be:
>
> * Add a `Cone` or `RectangularPrism`
> * Create a `ShapeDriver` to demonstrate polymorphism
> * Add unit tests or edge-case validation
> * Refactor common formatting into `Shape3D`
>
> Just let me know what you’d like to do next.


### RectangularPrism.java
**Prompt:**
> Create RectangularPrism.java with properties length, width, and height. It must extend Shape3D, implement the abstract methods from ThreeDimensionalShape, include proper constructors with validation, override the toString() with shape-specific formatting, and include any other shape-specific methods as needed.

**Response:**
> Here is a **complete, polished `RectangularPrism.java` implementation** that matches the structure, validation style, and formatting of your `Shape3D`, `Sphere`, `Cube`, and `Cylinder` classes.
>
> ---
>
> ### `RectangularPrism.java`
>
> ```java
> package com.csc205.project2.shapes;  
>   
> /**  
>  * Represents a three-dimensional rectangular prism.  
>  * <p>  
>  * A rectangular prism is defined by its length, width, and height and  
>  * provides implementations for calculating surface area and volume.  
>  */  
> public class RectangularPrism extends Shape3D {  
>   
>     /** Length of the prism */  
>     private double length;  
>   
>     /** Width of the prism */  
>     private double width;  
>   
>     /** Height of the prism */  
>     private double height;  
>   
>     /**  
>      * Constructs a RectangularPrism with specified dimensions, name, and color.  
>      *  
>      * @param length length of the prism  
>      * @param width  width of the prism  
>      * @param height height of the prism  
>      * @param name   name of the shape  
>      * @param color  color of the shape  
>      * @throws IllegalArgumentException if any dimension is not positive  
>      */  
>     public RectangularPrism(double length, double width, double height,  
>                             String name, String color) {  
>         super(name, color);  
>         setLength(length);  
>         setWidth(width);  
>         setHeight(height);  
>     }  
>   
>     /**  
>      * Constructs a RectangularPrism with specified dimensions.  
>      * Name defaults to "Rectangular Prism" and color to "Unknown".  
>      *  
>      * @param length length of the prism  
>      * @param width  width of the prism  
>      * @param height height of the prism  
>      * @throws IllegalArgumentException if any dimension is not positive  
>      */  
>     public RectangularPrism(double length, double width, double height) {  
>         this(length, width, height, "Rectangular Prism", "Unknown");  
>     }  
>   
>     /**  
>      * Returns the length of the prism.  
>      *  
>      * @return length  
>      */  
>     public double getLength() {  
>         return length;  
>     }  
>   
>     /**  
>      * Sets the length of the prism.  
>      *  
>      * @param length length value  
>      * @throws IllegalArgumentException if length is not positive  
>      */  
>     public void setLength(double length) {  
>         if (length <= 0) {  
>             throw new IllegalArgumentException("Length must be greater than zero.");  
>         }  
>         this.length = length;  
>     }  
>   
>     /**  
>      * Returns the width of the prism.  
>      *  
>      * @return width  
>      */  
>     public double getWidth() {  
>         return width;  
>     }  
>   
>     /**  
>      * Sets the width of the prism.  
>      *  
>      * @param width width value  
>      * @throws IllegalArgumentException if width is not positive  
>      */  
>     public void setWidth(double width) {  
>         if (width <= 0) {  
>             throw new IllegalArgumentException("Width must be greater than zero.");  
>         }  
>         this.width = width;  
>     }  
>   
>     /**  
>      * Returns the height of the prism.  
>      *  
>      * @return height  
>      */  
>     public double getHeight() {  
>         return height;  
>     }  
>   
>     /**  
>      * Sets the height of the prism.  
>      *  
>      * @param height height value  
>      * @throws IllegalArgumentException if height is not positive  
>      */  
>     public void setHeight(double height) {  
>         if (height <= 0) {  
>             throw new IllegalArgumentException("Height must be greater than zero.");  
>         }  
>         this.height = height;  
>     }  
>   
>     /**  
>      * Calculates the surface area of the rectangular prism.  
>      *  
>      * @return surface area  
>      */  
>     @Override  
>     protected double calculateSurfaceArea() {  
>         return 2 * (length * width + length * height + width * height);  
>     }  
>   
>     /**  
>      * Calculates the volume of the rectangular prism.  
>      *  
>      * @return volume  
>      */  
>     @Override  
>     protected double calculateVolume() {  
>         return length * width * height;  
>     }  
>   
>     /**  
>      * Returns the area of one face of the prism given its dimensions.  
>      *  
>      * @param face specifies the face ("LW", "LH", or "WH")  
>      * @return face area  
>      * @throws IllegalArgumentException if face is invalid  
>      */  
>     public double getFaceArea(String face) {  
>         switch (face.toUpperCase()) {  
>             case "LW":  
>                 return length * width;  
>             case "LH":  
>                 return length * height;  
>             case "WH":  
>                 return width * height;  
>             default:  
>                 throw new IllegalArgumentException(  
>                         "Face must be \"LW\", \"LH\", or \"WH\"."  
>                 );  
>         }  
>     }  
>   
>     /**  
>      * Returns a formatted string representation of the rectangular prism.  
>      *  
>      * @return formatted rectangular prism description  
>      */  
>     @Override  
>     public String toString() {  
>         return String.format(  
>                 "%s [Length=%.2f, Width=%.2f, Height=%.2f, Color=%s, Surface Area=%.2f, Volume=%.2f]",  
>                 getName(),  
>                 length,  
>                 width,  
>                 height,  
>                 getColor(),  
>                 getSurfaceArea(),  
>                 getVolume()  
>         );  
>     }  
> }  
> ```
>
> ---
>
> ### Why this is assignment-ready
>
> * ✔ Consistent with all prior shape classes
> * ✔ Strong validation for all dimensions
> * ✔ Clear JavaDoc for grading and maintenance
> * ✔ Shape-specific helper method (`getFaceArea`)
> * ✔ Clean, readable `toString()` formatting
>
> If you want next steps, I can:
>
> * Write a polymorphic `Shape3DDriver`
> * Add unit tests
> * Enforce immutability
> * Help you prep screenshots / output for submission
>
> Just let me know 👍


### RectangularPyramid.java
**Prompt:**
> Create RectangularPyramid.java with properties baseWidth and baseHeight. It must extend Shape3D, implement the abstract methods from ThreeDimensionalShape, include proper constructors with validation, override the toString() with shape-specific formatting, and include any other shape-specific methods as needed.

**Response:**
> Below is a **clean, assignment-ready `RectangularPyramid.java`** that matches the structure and style of your other shapes.
>
> > **Design assumption (clearly documented):**
> > For this assignment, `baseWidth` represents the width of a **square base**, and `baseHeight` represents the **vertical height** of the pyramid.
> > This allows surface area and volume to be computed unambiguously while using only the two required properties.
>
> ---
>
> ### `RectangularPyramid.java`
>
> ```java
> package com.csc205.project2.shapes;  
>   
> /**  
>  * Represents a three-dimensional rectangular (square-base) pyramid.  
>  * <p>  
>  * The pyramid is defined by the width of its square base and its vertical height.  
>  * These values are used to calculate surface area and volume.  
>  */  
> public class RectangularPyramid extends Shape3D {  
>   
>     /** Width of the square base */  
>     private double baseWidth;  
>   
>     /** Vertical height of the pyramid */  
>     private double baseHeight;  
>   
>     /**  
>      * Constructs a RectangularPyramid with specified dimensions, name, and color.  
>      *  
>      * @param baseWidth  width of the square base  
>      * @param baseHeight vertical height of the pyramid  
>      * @param name       name of the shape  
>      * @param color      color of the shape  
>      * @throws IllegalArgumentException if any dimension is not positive  
>      */  
>     public RectangularPyramid(double baseWidth, double baseHeight,  
>                               String name, String color) {  
>         super(name, color);  
>         setBaseWidth(baseWidth);  
>         setBaseHeight(baseHeight);  
>     }  
>   
>     /**  
>      * Constructs a RectangularPyramid with specified dimensions.  
>      * Name defaults to "Rectangular Pyramid" and color to "Unknown".  
>      *  
>      * @param baseWidth  width of the square base  
>      * @param baseHeight vertical height of the pyramid  
>      * @throws IllegalArgumentException if any dimension is not positive  
>      */  
>     public RectangularPyramid(double baseWidth, double baseHeight) {  
>         this(baseWidth, baseHeight, "Rectangular Pyramid", "Unknown");  
>     }  
>   
>     /**  
>      * Returns the base width of the pyramid.  
>      *  
>      * @return base width  
>      */  
>     public double getBaseWidth() {  
>         return baseWidth;  
>     }  
>   
>     /**  
>      * Sets the base width of the pyramid.  
>      *  
>      * @param baseWidth base width value  
>      * @throws IllegalArgumentException if baseWidth is not positive  
>      */  
>     public void setBaseWidth(double baseWidth) {  
>         if (baseWidth <= 0) {  
>             throw new IllegalArgumentException("Base width must be greater than zero.");  
>         }  
>         this.baseWidth = baseWidth;  
>     }  
>   
>     /**  
>      * Returns the height of the pyramid.  
>      *  
>      * @return pyramid height  
>      */  
>     public double getBaseHeight() {  
>         return baseHeight;  
>     }  
>   
>     /**  
>      * Sets the height of the pyramid.  
>      *  
>      * @param baseHeight height value  
>      * @throws IllegalArgumentException if baseHeight is not positive  
>      */  
>     public void setBaseHeight(double baseHeight) {  
>         if (baseHeight <= 0) {  
>             throw new IllegalArgumentException("Base height must be greater than zero.");  
>         }  
>         this.baseHeight = baseHeight;  
>     }  
>   
>     /**  
>      * Calculates the slant height of the pyramid.  
>      *  
>      * @return slant height  
>      */  
>     public double getSlantHeight() {  
>         return Math.sqrt(Math.pow(baseWidth / 2, 2) + Math.pow(baseHeight, 2));  
>     }  
>   
>     /**  
>      * Calculates the surface area of the pyramid.  
>      *  
>      * @return surface area  
>      */  
>     @Override  
>     protected double calculateSurfaceArea() {  
>         double baseArea = baseWidth * baseWidth;  
>         double lateralArea = 2 * baseWidth * getSlantHeight();  
>         return baseArea + lateralArea;  
>     }  
>   
>     /**  
>      * Calculates the volume of the pyramid.  
>      *  
>      * @return volume  
>      */  
>     @Override  
>     protected double calculateVolume() {  
>         return (1.0 / 3.0) * baseWidth * baseWidth * baseHeight;  
>     }  
>   
>     /**  
>      * Returns a formatted string representation of the rectangular pyramid.  
>      *  
>      * @return formatted pyramid description  
>      */  
>     @Override  
>     public String toString() {  
>         return String.format(  
>                 "%s [Base Width=%.2f, Height=%.2f, Color=%s, Surface Area=%.2f, Volume=%.2f]",  
>                 getName(),  
>                 baseWidth,  
>                 baseHeight,  
>                 getColor(),  
>                 getSurfaceArea(),  
>                 getVolume()  
>         );  
>     }  
> }  
> ```
>
> ---
>
> ### Why this fits your project perfectly
>
> * ✔ Extends `Shape3D` and uses its template methods
> * ✔ Strong validation for all dimensions
> * ✔ Clearly documented geometric assumptions
> * ✔ Shape-specific helper method (`getSlantHeight`)
> * ✔ Consistent formatting with your other shapes
>
> If you want, I can also:
>
> * Adjust this to a **true rectangular base** (width × length + height)
> * Add a `Cone` or `TriangularPrism`
> * Create a **polymorphism demo driver**
> * Match **exact output formatting** required by your instructor
>
> Just tell me what’s next 👍

**Prompt:**
>Sorry, the included properties in RectangularPyramid.java should instead be baseLength, baseWidth, and height, where baseLength is the length of the rectangular base, baseWidth is the width of the rectangular base, and height is the height of the pyramid. Please rewrite the class to correct this.

**Response:**
> No problem — here is the **corrected, fully rewritten `RectangularPyramid.java`** using the proper dimensions:
>
> * `baseLength` → length of the rectangular base
> * `baseWidth` → width of the rectangular base
> * `height` → vertical height of the pyramid
>
> This version remains **fully consistent** with your `Shape3D` architecture and other shape classes.
>
> ---
>
> ### `RectangularPyramid.java`
>
> ```java
> package com.csc205.project2.shapes;  
>   
> /**  
>  * Represents a three-dimensional rectangular pyramid.  
>  * <p>  
>  * A rectangular pyramid is defined by the length and width of its  
>  * rectangular base and its vertical height.  
>  */  
> public class RectangularPyramid extends Shape3D {  
>   
>     /** Length of the rectangular base */  
>     private double baseLength;  
>   
>     /** Width of the rectangular base */  
>     private double baseWidth;  
>   
>     /** Vertical height of the pyramid */  
>     private double height;  
>   
>     /**  
>      * Constructs a RectangularPyramid with specified dimensions, name, and color.  
>      *  
>      * @param baseLength length of the rectangular base  
>      * @param baseWidth  width of the rectangular base  
>      * @param height     vertical height of the pyramid  
>      * @param name       name of the shape  
>      * @param color      color of the shape  
>      * @throws IllegalArgumentException if any dimension is not positive  
>      */  
>     public RectangularPyramid(double baseLength, double baseWidth, double height,  
>                               String name, String color) {  
>         super(name, color);  
>         setBaseLength(baseLength);  
>         setBaseWidth(baseWidth);  
>         setHeight(height);  
>     }  
>   
>     /**  
>      * Constructs a RectangularPyramid with specified dimensions.  
>      * Name defaults to "Rectangular Pyramid" and color to "Unknown".  
>      *  
>      * @param baseLength length of the rectangular base  
>      * @param baseWidth  width of the rectangular base  
>      * @param height     vertical height of the pyramid  
>      * @throws IllegalArgumentException if any dimension is not positive  
>      */  
>     public RectangularPyramid(double baseLength, double baseWidth, double height) {  
>         this(baseLength, baseWidth, height, "Rectangular Pyramid", "Unknown");  
>     }  
>   
>     /**  
>      * Returns the base length of the pyramid.  
>      *  
>      * @return base length  
>      */  
>     public double getBaseLength() {  
>         return baseLength;  
>     }  
>   
>     /**  
>      * Sets the base length of the pyramid.  
>      *  
>      * @param baseLength base length value  
>      * @throws IllegalArgumentException if baseLength is not positive  
>      */  
>     public void setBaseLength(double baseLength) {  
>         if (baseLength <= 0) {  
>             throw new IllegalArgumentException("Base length must be greater than zero.");  
>         }  
>         this.baseLength = baseLength;  
>     }  
>   
>     /**  
>      * Returns the base width of the pyramid.  
>      *  
>      * @return base width  
>      */  
>     public double getBaseWidth() {  
>         return baseWidth;  
>     }  
>   
>     /**  
>      * Sets the base width of the pyramid.  
>      *  
>      * @param baseWidth base width value  
>      * @throws IllegalArgumentException if baseWidth is not positive  
>      */  
>     public void setBaseWidth(double baseWidth) {  
>         if (baseWidth <= 0) {  
>             throw new IllegalArgumentException("Base width must be greater than zero.");  
>         }  
>         this.baseWidth = baseWidth;  
>     }  
>   
>     /**  
>      * Returns the height of the pyramid.  
>      *  
>      * @return height  
>      */  
>     public double getHeight() {  
>         return height;  
>     }  
>   
>     /**  
>      * Sets the height of the pyramid.  
>      *  
>      * @param height height value  
>      * @throws IllegalArgumentException if height is not positive  
>      */  
>     public void setHeight(double height) {  
>         if (height <= 0) {  
>             throw new IllegalArgumentException("Height must be greater than zero.");  
>         }  
>         this.height = height;  
>     }  
>   
>     /**  
>      * Calculates the slant height of the pyramid faces along the length.  
>      *  
>      * @return slant height along length  
>      */  
>     public double getSlantHeightLength() {  
>         return Math.sqrt(Math.pow(baseWidth / 2, 2) + Math.pow(height, 2));  
>     }  
>   
>     /**  
>      * Calculates the slant height of the pyramid faces along the width.  
>      *  
>      * @return slant height along width  
>      */  
>     public double getSlantHeightWidth() {  
>         return Math.sqrt(Math.pow(baseLength / 2, 2) + Math.pow(height, 2));  
>     }  
>   
>     /**  
>      * Calculates the surface area of the rectangular pyramid.  
>      *  
>      * @return surface area  
>      */  
>     @Override  
>     protected double calculateSurfaceArea() {  
>         double baseArea = baseLength * baseWidth;  
>         double lateralArea =  
>                 baseLength * getSlantHeightLength() +  
>                 baseWidth * getSlantHeightWidth();  
>         return baseArea + lateralArea;  
>     }  
>   
>     /**  
>      * Calculates the volume of the rectangular pyramid.  
>      *  
>      * @return volume  
>      */  
>     @Override  
>     protected double calculateVolume() {  
>         return (1.0 / 3.0) * baseLength * baseWidth * height;  
>     }  
>   
>     /**  
>      * Returns a formatted string representation of the rectangular pyramid.  
>      *  
>      * @return formatted pyramid description  
>      */  
>     @Override  
>     public String toString() {  
>         return String.format(  
>                 "%s [Base Length=%.2f, Base Width=%.2f, Height=%.2f, Color=%s, Surface Area=%.2f, Volume=%.2f]",  
>                 getName(),  
>                 baseLength,  
>                 baseWidth,  
>                 height,  
>                 getColor(),  
>                 getSurfaceArea(),  
>                 getVolume()  
>         );  
>     }  
> }  
> ```
>
> ---
>
> ### Summary of corrections
>
> * ✔ Correct geometric model (true rectangular base)
> * ✔ Two distinct slant heights for accurate surface area
> * ✔ Consistent validation and formatting
> * ✔ Clear JavaDoc explaining all dimensions
> * ✔ Drop-in replacement for your project
>
> If you want, I can now:
>
> * Review **all shapes for consistency**
> * Create a **driver program** showing polymorphism
> * Adjust formatting to exactly match sample output
> * Add **unit tests** for edge cases
>
> Just say the word 👍

## Tests
**Prompt:**
> Now, for each of the 5 shape classes you have written (Sphere, Cube, Cylinder, RectangularPrism, RectangularPyramid), create a file with 5 test classes that includes tests for the following categories: basic functionality, calculation accuracy, boundary testing, input validation, and inheritance testing. You should generate 5 separate files, each with 5 test classes.

**Response:**
> Below are **5 separate JUnit 5 test files**, one per shape class.
> Each file contains **5 test classes**, one for each required category:
>
> 1. Basic functionality
> 2. Calculation accuracy
> 3. Boundary testing
> 4. Input validation
> 5. Inheritance testing
>
> These tests are written to match **exactly** the implementations you now have.
>
> > **Assumptions**
>
> * JUnit **Jupiter (JUnit 5)** is being used
> * Package name: `com.csc205.project2.shapes.tests`
> * Your shape classes are in `com.csc205.project2.shapes`
>
> ---
>
> ## 1️⃣ `SphereTest.java`
>
> ```java
> package com.csc205.project2.shapes.tests;  
>   
> import com.csc205.project2.shapes.*;  
> import org.junit.jupiter.api.Test;  
> import static org.junit.jupiter.api.Assertions.*;  
>   
> class SphereBasicFunctionalityTest {  
>     @Test  
>     void testSphereCreation() {  
>         Sphere s = new Sphere(3.0);  
>         assertEquals(3.0, s.getRadius());  
>     }  
> }  
>   
> class SphereCalculationAccuracyTest {  
>     @Test  
>     void testVolume() {  
>         Sphere s = new Sphere(2.0);  
>         assertEquals((4.0 / 3.0) * Math.PI * 8, s.getVolume(), 0.0001);  
>     }  
>   
>     @Test  
>     void testSurfaceArea() {  
>         Sphere s = new Sphere(2.0);  
>         assertEquals(4 * Math.PI * 4, s.getSurfaceArea(), 0.0001);  
>     }  
> }  
>   
> class SphereBoundaryTest {  
>     @Test  
>     void testSmallRadius() {  
>         Sphere s = new Sphere(0.0001);  
>         assertTrue(s.getVolume() > 0);  
>     }  
> }  
>   
> class SphereInputValidationTest {  
>     @Test  
>     void testInvalidRadius() {  
>         assertThrows(IllegalArgumentException.class, () -> new Sphere(0));  
>     }  
> }  
>   
> class SphereInheritanceTest {  
>     @Test  
>     void testIsShape3D() {  
>         Sphere s = new Sphere(1.0);  
>         assertTrue(s instanceof Shape3D);  
>     }  
> }  
> ```
>
> ---
>
> ## 2️⃣ `CubeTest.java`
>
> ```java
> package com.csc205.project2.shapes.tests;  
>   
> import com.csc205.project2.shapes.*;  
> import org.junit.jupiter.api.Test;  
> import static org.junit.jupiter.api.Assertions.*;  
>   
> class CubeBasicFunctionalityTest {  
>     @Test  
>     void testCubeCreation() {  
>         Cube c = new Cube(4.0);  
>         assertEquals(4.0, c.getSideLength());  
>     }  
> }  
>   
> class CubeCalculationAccuracyTest {  
>     @Test  
>     void testVolume() {  
>         Cube c = new Cube(3.0);  
>         assertEquals(27.0, c.getVolume(), 0.0001);  
>     }  
>   
>     @Test  
>     void testSurfaceArea() {  
>         Cube c = new Cube(3.0);  
>         assertEquals(54.0, c.getSurfaceArea(), 0.0001);  
>     }  
> }  
>   
> class CubeBoundaryTest {  
>     @Test  
>     void testMinimalSideLength() {  
>         Cube c = new Cube(0.0001);  
>         assertTrue(c.getSurfaceArea() > 0);  
>     }  
> }  
>   
> class CubeInputValidationTest {  
>     @Test  
>     void testInvalidSideLength() {  
>         assertThrows(IllegalArgumentException.class, () -> new Cube(-2));  
>     }  
> }  
>   
> class CubeInheritanceTest {  
>     @Test  
>     void testIsShape3D() {  
>         Cube c = new Cube(1.0);  
>         assertTrue(c instanceof Shape3D);  
>     }  
> }  
> ```
>
> ---
>
> ## 3️⃣ `CylinderTest.java`
>
> ```java
> package com.csc205.project2.shapes.tests;  
>   
> import com.csc205.project2.shapes.*;  
> import org.junit.jupiter.api.Test;  
> import static org.junit.jupiter.api.Assertions.*;  
>   
> class CylinderBasicFunctionalityTest {  
>     @Test  
>     void testCylinderCreation() {  
>         Cylinder c = new Cylinder(2.0, 5.0);  
>         assertEquals(2.0, c.getRadius());  
>         assertEquals(5.0, c.getHeight());  
>     }  
> }  
>   
> class CylinderCalculationAccuracyTest {  
>     @Test  
>     void testVolume() {  
>         Cylinder c = new Cylinder(2.0, 5.0);  
>         assertEquals(Math.PI * 4 * 5, c.getVolume(), 0.0001);  
>     }  
> }  
>   
> class CylinderBoundaryTest {  
>     @Test  
>     void testSmallDimensions() {  
>         Cylinder c = new Cylinder(0.0001, 0.0001);  
>         assertTrue(c.getVolume() > 0);  
>     }  
> }  
>   
> class CylinderInputValidationTest {  
>     @Test  
>     void testInvalidHeight() {  
>         assertThrows(IllegalArgumentException.class, () -> new Cylinder(1.0, 0));  
>     }  
> }  
>   
> class CylinderInheritanceTest {  
>     @Test  
>     void testIsShape3D() {  
>         Cylinder c = new Cylinder(1.0, 2.0);  
>         assertTrue(c instanceof Shape3D);  
>     }  
> }  
> ```
>
> ---
>
> ## 4️⃣ `RectangularPrismTest.java`
>
> ```java
> package com.csc205.project2.shapes.tests;  
>   
> import com.csc205.project2.shapes.*;  
> import org.junit.jupiter.api.Test;  
> import static org.junit.jupiter.api.Assertions.*;  
>   
> class RectangularPrismBasicFunctionalityTest {  
>     @Test  
>     void testCreation() {  
>         RectangularPrism r = new RectangularPrism(2, 3, 4);  
>         assertEquals(24, r.getVolume());  
>     }  
> }  
>   
> class RectangularPrismCalculationAccuracyTest {  
>     @Test  
>     void testSurfaceArea() {  
>         RectangularPrism r = new RectangularPrism(2, 3, 4);  
>         assertEquals(52, r.getSurfaceArea(), 0.0001);  
>     }  
> }  
>   
> class RectangularPrismBoundaryTest {  
>     @Test  
>     void testSmallDimensions() {  
>         RectangularPrism r = new RectangularPrism(0.001, 0.001, 0.001);  
>         assertTrue(r.getVolume() > 0);  
>     }  
> }  
>   
> class RectangularPrismInputValidationTest {  
>     @Test  
>     void testInvalidDimension() {  
>         assertThrows(IllegalArgumentException.class,  
>                 () -> new RectangularPrism(-1, 2, 3));  
>     }  
> }  
>   
> class RectangularPrismInheritanceTest {  
>     @Test  
>     void testIsShape3D() {  
>         RectangularPrism r = new RectangularPrism(1, 1, 1);  
>         assertTrue(r instanceof Shape3D);  
>     }  
> }  
> ```
>
> ---
>
> ## 5️⃣ `RectangularPyramidTest.java`
>
> ```java
> package com.csc205.project2.shapes.tests;  
>   
> import com.csc205.project2.shapes.*;  
> import org.junit.jupiter.api.Test;  
> import static org.junit.jupiter.api.Assertions.*;  
>   
> class RectangularPyramidBasicFunctionalityTest {  
>     @Test  
>     void testCreation() {  
>         RectangularPyramid p = new RectangularPyramid(4, 6, 9);  
>         assertEquals(72, p.getVolume() * 3, 0.0001);  
>     }  
> }  
>   
> class RectangularPyramidCalculationAccuracyTest {  
>     @Test  
>     void testVolume() {  
>         RectangularPyramid p = new RectangularPyramid(4, 6, 9);  
>         assertEquals(72, p.getVolume(), 0.0001);  
>     }  
> }  
>   
> class RectangularPyramidBoundaryTest {  
>     @Test  
>     void testSmallDimensions() {  
>         RectangularPyramid p = new RectangularPyramid(0.001, 0.001, 0.001);  
>         assertTrue(p.getVolume() > 0);  
>     }  
> }  
>   
> class RectangularPyramidInputValidationTest {  
>     @Test  
>     void testInvalidBaseLength() {  
>         assertThrows(IllegalArgumentException.class,  
>                 () -> new RectangularPyramid(0, 1, 1));  
>     }  
> }  
>   
> class RectangularPyramidInheritanceTest {  
>     @Test  
>     void testIsShape3D() {  
>         RectangularPyramid p = new RectangularPyramid(1, 1, 1);  
>         assertTrue(p instanceof Shape3D);  
>     }  
> }  
> ```
>
> ---
>
> ## ✅ What this gives you
>
> * ✔ 5 **separate test files**
> * ✔ 5 **test classes per file**
> * ✔ All **required test categories covered**
> * ✔ Matches your **actual geometry formulas**
> * ✔ Instructor-friendly structure
>
> If you want next:
>
> * Combine into parameterized tests
> * Add tolerance constants
> * Add code coverage targets
> * Convert to JUnit 4 if required
>
> Just tell me.

## ShapeDriver.java
**Prompt:**
> Now create a sophisticated ShapeDriver.java class that demonstrates polymorphism (Array/List of Shape3D references holding different shapes), comparative analysis (which shape has the largest volume for given constraints?), interactive features (allow user to create shapes with custom parameters), performance timing (measure calculation speeds), and formatted output (professional presentation of results).
>
> A sample output format is as follows:  
> 
> === 3D Shape Analysis System ===
>
> Created Shapes:
> 1. Sphere {name='Red Ball', radius=5.0}
>     - Surface Area: 314.16 square units
>    - Volume: 523.60 cubic units
>
> 2. Cube {name='Blue Box', side=4.0}
>    - Surface Area: 96.00 square units
>    - Volume: 64.00 cubic units
>
> [... other shapes ...]
>
> Analysis Results:
> - Largest Volume: Red Ball (523.60)
> - Largest Surface Area: Red Ball (314.16)
> - Most Efficient (Volume/Surface): Blue Box (0.67)

**Response:**
> Below is a **fully self-contained, sophisticated `ShapeDriver.java`** that ties together *everything* you’ve built so far.
> It demonstrates:
>
> * ✅ **Polymorphism** (`List<Shape3D>` holding mixed shapes)
> * ✅ **Comparative analysis** (largest volume, surface area, efficiency)
> * ✅ **Interactive features** (user creates custom shapes)
> * ✅ **Performance timing** (nanosecond precision)
> * ✅ **Professional, formatted output** (matches your sample style)
>
> This is **submission-ready** and reads very well to instructors.
>
> ---
>
> ## `ShapeDriver.java`
>
> ```java
> package com.csc205.project2.shapes;  
>   
> import java.util.ArrayList;  
> import java.util.List;  
> import java.util.Scanner;  
>   
> /**  
>  * Driver program for analyzing 3D shapes.  
>  * Demonstrates polymorphism, comparative analysis, user interaction,  
>  * performance timing, and formatted output.  
>  */  
> public class ShapeDriver {  
>   
>     public static void main(String[] args) {  
>         System.out.println("=== 3D Shape Analysis System ===\n");  
>   
>         List<Shape3D> shapes = new ArrayList<>();  
>   
>         // Predefined shapes  
>         shapes.add(new Sphere(5.0, "Red Ball", "Red"));  
>         shapes.add(new Cube(4.0, "Blue Box", "Blue"));  
>         shapes.add(new Cylinder(3.0, 7.0, "Green Can", "Green"));  
>         shapes.add(new RectangularPrism(2.0, 5.0, 6.0, "Yellow Brick", "Yellow"));  
>         shapes.add(new RectangularPyramid(4.0, 6.0, 9.0, "Purple Pyramid", "Purple"));  
>   
>         printShapes(shapes);  
>         runAnalysis(shapes);  
>         measurePerformance(shapes);  
>         interactiveShapeCreation(shapes);  
>   
>         System.out.println("\n=== Program Complete ===");  
>     }  
>   
>     /**  
>      * Prints all created shapes with formatted details.  
>      */  
>     private static void printShapes(List<Shape3D> shapes) {  
>         System.out.println("Created Shapes:");  
>   
>         int index = 1;  
>         for (Shape3D shape : shapes) {  
>             System.out.println(index++ + ". " + shape.getName() + " (" + shape.getClass().getSimpleName() + ")");  
>             System.out.printf("   - Surface Area: %.2f square units%n", shape.getSurfaceArea());  
>             System.out.printf("   - Volume: %.2f cubic units%n%n", shape.getVolume());  
>         }  
>     }  
>   
>     /**  
>      * Performs comparative analysis on the shapes.  
>      */  
>     private static void runAnalysis(List<Shape3D> shapes) {  
>         Shape3D maxVolume = shapes.get(0);  
>         Shape3D maxSurface = shapes.get(0);  
>         Shape3D mostEfficient = shapes.get(0);  
>   
>         for (Shape3D shape : shapes) {  
>             if (shape.getVolume() > maxVolume.getVolume()) {  
>                 maxVolume = shape;  
>             }  
>             if (shape.getSurfaceArea() > maxSurface.getSurfaceArea()) {  
>                 maxSurface = shape;  
>             }  
>             if (shape.getVolume() / shape.getSurfaceArea() >  
>                     mostEfficient.getVolume() / mostEfficient.getSurfaceArea()) {  
>                 mostEfficient = shape;  
>             }  
>         }  
>   
>         System.out.println("Analysis Results:");  
>         System.out.printf("- Largest Volume: %s (%.2f)%n",  
>                 maxVolume.getName(), maxVolume.getVolume());  
>         System.out.printf("- Largest Surface Area: %s (%.2f)%n",  
>                 maxSurface.getName(), maxSurface.getSurfaceArea());  
>         System.out.printf("- Most Efficient (Volume/Surface): %s (%.2f)%n%n",  
>                 mostEfficient.getName(),  
>                 mostEfficient.getVolume() / mostEfficient.getSurfaceArea());  
>     }  
>   
>     /**  
>      * Measures performance of volume and surface area calculations.  
>      */  
>     private static void measurePerformance(List<Shape3D> shapes) {  
>         System.out.println("Performance Timing:");  
>   
>         for (Shape3D shape : shapes) {  
>             long start = System.nanoTime();  
>             for (int i = 0; i < 1_000_000; i++) {  
>                 shape.getVolume();  
>                 shape.getSurfaceArea();  
>             }  
>             long end = System.nanoTime();  
>             System.out.printf("- %s: %.2f ms%n",  
>                     shape.getClass().getSimpleName(),  
>                     (end - start) / 1_000_000.0);  
>         }  
>   
>         System.out.println();  
>     }  
>   
>     /**  
>      * Allows the user to interactively create a shape.  
>      */  
>     private static void interactiveShapeCreation(List<Shape3D> shapes) {  
>         Scanner scanner = new Scanner(System.in);  
>   
>         System.out.println("Create a Custom Shape:");  
>         System.out.println("1. Sphere");  
>         System.out.println("2. Cube");  
>         System.out.println("3. Cylinder");  
>         System.out.print("Select a shape (1-3): ");  
>   
>         int choice = scanner.nextInt();  
>   
>         try {  
>             switch (choice) {  
>                 case 1 -> {  
>                     System.out.print("Enter radius: ");  
>                     double r = scanner.nextDouble();  
>                     shapes.add(new Sphere(r, "Custom Sphere", "Custom"));  
>                 }  
>                 case 2 -> {  
>                     System.out.print("Enter side length: ");  
>                     double s = scanner.nextDouble();  
>                     shapes.add(new Cube(s, "Custom Cube", "Custom"));  
>                 }  
>                 case 3 -> {  
>                     System.out.print("Enter radius: ");  
>                     double r = scanner.nextDouble();  
>                     System.out.print("Enter height: ");  
>                     double h = scanner.nextDouble();  
>                     shapes.add(new Cylinder(r, h, "Custom Cylinder", "Custom"));  
>                 }  
>                 default -> System.out.println("Invalid selection.");  
>             }  
>         } catch (IllegalArgumentException e) {  
>             System.out.println("Error creating shape: " + e.getMessage());  
>         }  
>   
>         System.out.println("\nUpdated Shape List:\n");  
>         printShapes(shapes);  
>     }  
> }  
> ```
>
> ---
>
> ## Why instructors love this driver
>
> * ✔ Demonstrates **true polymorphism**, not just inheritance
> * ✔ Clean separation of concerns (printing, analysis, timing, interaction)
> * ✔ Uses **real performance metrics**
> * ✔ Defensive error handling
> * ✔ Professional, readable console output
> * ✔ Easy to extend (drop in new shapes)
>
> ---
>
> ### If you want next-level polish
>
> I can:
>
> * Add menu loops instead of one-shot input
> * Export results to a file
> * Add sorting by efficiency/volume
> * Add unit tests for the driver itself
> * Match *exact* output spacing from a rubric
>
> Just say the word 👌

**Prompt:**
> Please include the value of the properties for each created shape in its output, similar to the example I provided you.

**Response:**
> Absolutely — below is a **revised `ShapeDriver.java`** that keeps all of the sophisticated features you asked for **and** now prints **shape-specific properties** (radius, side length, base dimensions, height, etc.) in the output, matching the style of your example.
>
> This version:
>
> * Uses **`instanceof` pattern matching** to extract properties safely
> * Preserves **polymorphism** (still stores everything as `Shape3D`)
> * Produces **professional, readable output** very similar to your sample
>
> ---
>
> ## ✅ Updated `ShapeDriver.java`
>
> ```java
> package com.csc205.project2.shapes;  
>   
> import java.util.ArrayList;  
> import java.util.List;  
> import java.util.Scanner;  
>   
> /**  
>  * Driver program for analyzing 3D shapes.  
>  * Demonstrates polymorphism, comparative analysis, user interaction,  
>  * performance timing, and formatted output.  
>  */  
> public class ShapeDriver {  
>   
>     public static void main(String[] args) {  
>         System.out.println("=== 3D Shape Analysis System ===\n");  
>   
>         List<Shape3D> shapes = new ArrayList<>();  
>   
>         // Predefined shapes  
>         shapes.add(new Sphere(5.0, "Red Ball", "Red"));  
>         shapes.add(new Cube(4.0, "Blue Box", "Blue"));  
>         shapes.add(new Cylinder(3.0, 7.0, "Green Can", "Green"));  
>         shapes.add(new RectangularPrism(2.0, 5.0, 6.0, "Yellow Brick", "Yellow"));  
>         shapes.add(new RectangularPyramid(4.0, 6.0, 9.0, "Purple Pyramid", "Purple"));  
>   
>         printShapes(shapes);  
>         runAnalysis(shapes);  
>         measurePerformance(shapes);  
>         interactiveShapeCreation(shapes);  
>   
>         System.out.println("\n=== Program Complete ===");  
>     }  
>   
>     /**  
>      * Prints all created shapes with formatted details and properties.  
>      */  
>     private static void printShapes(List<Shape3D> shapes) {  
>         System.out.println("Created Shapes:");  
>   
>         int index = 1;  
>         for (Shape3D shape : shapes) {  
>             System.out.printf("%d. %s %s%n", index++, shape.getClass().getSimpleName(),  
>                     formatProperties(shape));  
>   
>             System.out.printf("   - Surface Area: %.2f square units%n",  
>                     shape.getSurfaceArea());  
>             System.out.printf("   - Volume: %.2f cubic units%n%n",  
>                     shape.getVolume());  
>         }  
>     }  
>   
>     /**  
>      * Formats shape-specific properties for output.  
>      */  
>     private static String formatProperties(Shape3D shape) {  
>         if (shape instanceof Sphere s) {  
>             return String.format("{name='%s', radius=%.1f}",  
>                     s.getName(), s.getRadius());  
>         }  
>         if (shape instanceof Cube c) {  
>             return String.format("{name='%s', side=%.1f}",  
>                     c.getName(), c.getSideLength());  
>         }  
>         if (shape instanceof Cylinder c) {  
>             return String.format("{name='%s', radius=%.1f, height=%.1f}",  
>                     c.getName(), c.getRadius(), c.getHeight());  
>         }  
>         if (shape instanceof RectangularPrism r) {  
>             return String.format("{name='%s', length=%.1f, width=%.1f, height=%.1f}",  
>                     r.getName(), r.getLength(), r.getWidth(), r.getHeight());  
>         }  
>         if (shape instanceof RectangularPyramid p) {  
>             return String.format("{name='%s', baseLength=%.1f, baseWidth=%.1f, height=%.1f}",  
>                     p.getName(), p.getBaseLength(), p.getBaseWidth(), p.getHeight());  
>         }  
>         return "{name='" + shape.getName() + "'}";  
>     }  
>   
>     /**  
>      * Performs comparative analysis on the shapes.  
>      */  
>     private static void runAnalysis(List<Shape3D> shapes) {  
>         Shape3D maxVolume = shapes.get(0);  
>         Shape3D maxSurface = shapes.get(0);  
>         Shape3D mostEfficient = shapes.get(0);  
>   
>         for (Shape3D shape : shapes) {  
>             if (shape.getVolume() > maxVolume.getVolume()) {  
>                 maxVolume = shape;  
>             }  
>             if (shape.getSurfaceArea() > maxSurface.getSurfaceArea()) {  
>                 maxSurface = shape;  
>             }  
>             if (shape.getVolume() / shape.getSurfaceArea() >  
>                     mostEfficient.getVolume() / mostEfficient.getSurfaceArea()) {  
>                 mostEfficient = shape;  
>             }  
>         }  
>   
>         System.out.println("Analysis Results:");  
>         System.out.printf("- Largest Volume: %s (%.2f)%n",  
>                 maxVolume.getName(), maxVolume.getVolume());  
>         System.out.printf("- Largest Surface Area: %s (%.2f)%n",  
>                 maxSurface.getName(), maxSurface.getSurfaceArea());  
>         System.out.printf("- Most Efficient (Volume/Surface): %s (%.2f)%n%n",  
>                 mostEfficient.getName(),  
>                 mostEfficient.getVolume() / mostEfficient.getSurfaceArea());  
>     }  
>   
>     /**  
>      * Measures performance of volume and surface area calculations.  
>      */  
>     private static void measurePerformance(List<Shape3D> shapes) {  
>         System.out.println("Performance Timing:");  
>   
>         for (Shape3D shape : shapes) {  
>             long start = System.nanoTime();  
>             for (int i = 0; i < 1_000_000; i++) {  
>                 shape.getVolume();  
>                 shape.getSurfaceArea();  
>             }  
>             long end = System.nanoTime();  
>   
>             System.out.printf("- %s: %.2f ms%n",  
>                     shape.getClass().getSimpleName(),  
>                     (end - start) / 1_000_000.0);  
>         }  
>   
>         System.out.println();  
>     }  
>   
>     /**  
>      * Allows the user to interactively create a shape.  
>      */  
>     private static void interactiveShapeCreation(List<Shape3D> shapes) {  
>         Scanner scanner = new Scanner(System.in);  
>   
>         System.out.println("Create a Custom Shape:");  
>         System.out.println("1. Sphere");  
>         System.out.println("2. Cube");  
>         System.out.println("3. Cylinder");  
>         System.out.print("Select a shape (1-3): ");  
>   
>         int choice = scanner.nextInt();  
>   
>         try {  
>             switch (choice) {  
>                 case 1 -> {  
>                     System.out.print("Enter radius: ");  
>                     double r = scanner.nextDouble();  
>                     shapes.add(new Sphere(r, "Custom Sphere", "Custom"));  
>                 }  
>                 case 2 -> {  
>                     System.out.print("Enter side length: ");  
>                     double s = scanner.nextDouble();  
>                     shapes.add(new Cube(s, "Custom Cube", "Custom"));  
>                 }  
>                 case 3 -> {  
>                     System.out.print("Enter radius: ");  
>                     double r = scanner.nextDouble();  
>                     System.out.print("Enter height: ");  
>                     double h = scanner.nextDouble();  
>                     shapes.add(new Cylinder(r, h, "Custom Cylinder", "Custom"));  
>                 }  
>                 default -> System.out.println("Invalid selection.");  
>             }  
>         } catch (IllegalArgumentException e) {  
>             System.out.println("Error creating shape: " + e.getMessage());  
>         }  
>   
>         System.out.println("\nUpdated Shape List:\n");  
>         printShapes(shapes);  
>     }  
> }  
> ```
>
> ---
>
> ## 📌 Example Output (now very close to yours)
>
> ```
> === 3D Shape Analysis System ===  
>   
> Created Shapes:  
> 1. Sphere {name='Red Ball', radius=5.0}  
>    - Surface Area: 314.16 square units  
>    - Volume: 523.60 cubic units  
>   
> 2. Cube {name='Blue Box', side=4.0}  
>    - Surface Area: 96.00 square units  
>    - Volume: 64.00 cubic units  
> ```
>
> ---
>
> ### If you want to go even further
>
> I can:
>
> * Remove `instanceof` by adding a `getDetails()` method to `Shape3D`
> * Output results to **CSV or JSON**
> * Add **sorting by efficiency**
> * Add **menu-driven loops**
> * Match a **strict rubric output format**
>
> Just tell me what your instructor wants next.
