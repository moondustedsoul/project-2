package com.csc205.project2;

import com.csc205.project2.shapes.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Driver program for analyzing 3D shapes.
 * Demonstrates polymorphism, comparative analysis, user interaction,
 * performance timing, and formatted output.
 */
public class ShapeDriver {

    public static void main(String[] args) {
        System.out.println("=== 3D Shape Analysis System ===\n");

        List<Shape3D> shapes = new ArrayList<>();

        // Predefined shapes
        shapes.add(new Sphere(5.0, "Red Ball", "Red"));
        shapes.add(new Cube(4.0, "Blue Box", "Blue"));
        shapes.add(new Cylinder(3.0, 7.0, "Green Can", "Green"));
        shapes.add(new RectangularPrism(2.0, 5.0, 6.0, "Yellow Brick", "Yellow"));
        shapes.add(new RectangularPyramid(4.0, 6.0, 9.0, "Purple Pyramid", "Purple"));

        printShapes(shapes);
        runAnalysis(shapes);
        measurePerformance(shapes);
        interactiveShapeCreation(shapes);

        System.out.println("\n=== Program Complete ===");
    }

    /**
     * Prints all created shapes with formatted details and properties.
     */
    private static void printShapes(List<Shape3D> shapes) {
        System.out.println("Created Shapes:");

        int index = 1;
        for (Shape3D shape : shapes) {
            System.out.printf("%d. %s %s%n", index++, shape.getClass().getSimpleName(),
                    formatProperties(shape));

            System.out.printf("   - Surface Area: %.2f square units%n",
                    shape.getSurfaceArea());
            System.out.printf("   - Volume: %.2f cubic units%n%n",
                    shape.getVolume());
        }
    }

    /**
     * Formats shape-specific properties for output.
     */
    private static String formatProperties(Shape3D shape) {
        if (shape instanceof Sphere s) {
            return String.format("{name='%s', radius=%.1f}",
                    s.getName(), s.getRadius());
        }
        if (shape instanceof Cube c) {
            return String.format("{name='%s', side=%.1f}",
                    c.getName(), c.getSideLength());
        }
        if (shape instanceof Cylinder c) {
            return String.format("{name='%s', radius=%.1f, height=%.1f}",
                    c.getName(), c.getRadius(), c.getHeight());
        }
        if (shape instanceof RectangularPrism r) {
            return String.format("{name='%s', length=%.1f, width=%.1f, height=%.1f}",
                    r.getName(), r.getLength(), r.getWidth(), r.getHeight());
        }
        if (shape instanceof RectangularPyramid p) {
            return String.format("{name='%s', baseLength=%.1f, baseWidth=%.1f, height=%.1f}",
                    p.getName(), p.getBaseLength(), p.getBaseWidth(), p.getHeight());
        }
        return "{name='" + shape.getName() + "'}";
    }

    /**
     * Performs comparative analysis on the shapes.
     */
    private static void runAnalysis(List<Shape3D> shapes) {
        Shape3D maxVolume = shapes.get(0);
        Shape3D maxSurface = shapes.get(0);
        Shape3D mostEfficient = shapes.get(0);

        for (Shape3D shape : shapes) {
            if (shape.getVolume() > maxVolume.getVolume()) {
                maxVolume = shape;
            }
            if (shape.getSurfaceArea() > maxSurface.getSurfaceArea()) {
                maxSurface = shape;
            }
            if (shape.getVolume() / shape.getSurfaceArea() >
                    mostEfficient.getVolume() / mostEfficient.getSurfaceArea()) {
                mostEfficient = shape;
            }
        }

        System.out.println("Analysis Results:");
        System.out.printf("- Largest Volume: %s (%.2f)%n",
                maxVolume.getName(), maxVolume.getVolume());
        System.out.printf("- Largest Surface Area: %s (%.2f)%n",
                maxSurface.getName(), maxSurface.getSurfaceArea());
        System.out.printf("- Most Efficient (Volume/Surface): %s (%.2f)%n%n",
                mostEfficient.getName(),
                mostEfficient.getVolume() / mostEfficient.getSurfaceArea());
    }

    /**
     * Measures performance of volume and surface area calculations.
     */
    private static void measurePerformance(List<Shape3D> shapes) {
        System.out.println("Performance Timing:");

        for (Shape3D shape : shapes) {
            long start = System.nanoTime();
            for (int i = 0; i < 1_000_000; i++) {
                shape.getVolume();
                shape.getSurfaceArea();
            }
            long end = System.nanoTime();

            System.out.printf("- %s: %.2f ms%n",
                    shape.getClass().getSimpleName(),
                    (end - start) / 1_000_000.0);
        }

        System.out.println();
    }

    /**
     * Allows the user to interactively create a shape.
     */
    private static void interactiveShapeCreation(List<Shape3D> shapes) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Create a Custom Shape:");
        System.out.println("1. Sphere");
        System.out.println("2. Cube");
        System.out.println("3. Cylinder");
        System.out.print("Select a shape (1-3): ");

        int choice = scanner.nextInt();

        try {
            switch (choice) {
                case 1 -> {
                    System.out.print("Enter radius: ");
                    double r = scanner.nextDouble();
                    shapes.add(new Sphere(r, "Custom Sphere", "Custom"));
                }
                case 2 -> {
                    System.out.print("Enter side length: ");
                    double s = scanner.nextDouble();
                    shapes.add(new Cube(s, "Custom Cube", "Custom"));
                }
                case 3 -> {
                    System.out.print("Enter radius: ");
                    double r = scanner.nextDouble();
                    System.out.print("Enter height: ");
                    double h = scanner.nextDouble();
                    shapes.add(new Cylinder(r, h, "Custom Cylinder", "Custom"));
                }
                default -> System.out.println("Invalid selection.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error creating shape: " + e.getMessage());
        }

        System.out.println("\nUpdated Shape List:\n");
        printShapes(shapes);
    }
}