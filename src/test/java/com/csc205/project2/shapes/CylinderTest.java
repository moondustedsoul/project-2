package com.csc205.project2.shapes;

import com.csc205.project2.shapes.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CylinderBasicFunctionalityTest {
    @Test
    void testCylinderCreation() {
        Cylinder c = new Cylinder(2.0, 5.0);
        assertEquals(2.0, c.getRadius());
        assertEquals(5.0, c.getHeight());
    }
}

class CylinderCalculationAccuracyTest {
    @Test
    void testVolume() {
        Cylinder c = new Cylinder(2.0, 5.0);
        assertEquals(Math.PI * 4 * 5, c.getVolume(), 0.0001);
    }
}

class CylinderBoundaryTest {
    @Test
    void testSmallDimensions() {
        Cylinder c = new Cylinder(0.0001, 0.0001);
        assertTrue(c.getVolume() > 0);
    }
}

class CylinderInputValidationTest {
    @Test
    void testInvalidHeight() {
        assertThrows(IllegalArgumentException.class, () -> new Cylinder(1.0, 0));
    }
}

class CylinderInheritanceTest {
    @Test
    void testIsShape3D() {
        Cylinder c = new Cylinder(1.0, 2.0);
        assertTrue(c instanceof Shape3D);
    }
}