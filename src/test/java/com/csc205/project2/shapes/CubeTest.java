package com.csc205.project2.shapes;

import com.csc205.project2.shapes.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CubeBasicFunctionalityTest {
    @Test
    void testCubeCreation() {
        Cube c = new Cube(4.0);
        assertEquals(4.0, c.getSideLength());
    }
}

class CubeCalculationAccuracyTest {
    @Test
    void testVolume() {
        Cube c = new Cube(3.0);
        assertEquals(27.0, c.getVolume(), 0.0001);
    }

    @Test
    void testSurfaceArea() {
        Cube c = new Cube(3.0);
        assertEquals(54.0, c.getSurfaceArea(), 0.0001);
    }
}

class CubeBoundaryTest {
    @Test
    void testMinimalSideLength() {
        Cube c = new Cube(0.0001);
        assertTrue(c.getSurfaceArea() > 0);
    }
}

class CubeInputValidationTest {
    @Test
    void testInvalidSideLength() {
        assertThrows(IllegalArgumentException.class, () -> new Cube(-2));
    }
}

class CubeInheritanceTest {
    @Test
    void testIsShape3D() {
        Cube c = new Cube(1.0);
        assertTrue(c instanceof Shape3D);
    }
}