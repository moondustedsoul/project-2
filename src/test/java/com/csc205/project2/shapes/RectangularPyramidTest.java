package com.csc205.project2.shapes;

import com.csc205.project2.shapes.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RectangularPyramidBasicFunctionalityTest {
    @Test
    void testCreation() {
        RectangularPyramid p = new RectangularPyramid(4, 6, 9);
        assertEquals(72, p.getVolume() * 3, 0.0001);
    }
}

class RectangularPyramidCalculationAccuracyTest {
    @Test
    void testVolume() {
        RectangularPyramid p = new RectangularPyramid(4, 6, 9);
        assertEquals(72, p.getVolume(), 0.0001);
    }
}

class RectangularPyramidBoundaryTest {
    @Test
    void testSmallDimensions() {
        RectangularPyramid p = new RectangularPyramid(0.001, 0.001, 0.001);
        assertTrue(p.getVolume() > 0);
    }
}

class RectangularPyramidInputValidationTest {
    @Test
    void testInvalidBaseLength() {
        assertThrows(IllegalArgumentException.class,
                () -> new RectangularPyramid(0, 1, 1));
    }
}

class RectangularPyramidInheritanceTest {
    @Test
    void testIsShape3D() {
        RectangularPyramid p = new RectangularPyramid(1, 1, 1);
        assertTrue(p instanceof Shape3D);
    }
}