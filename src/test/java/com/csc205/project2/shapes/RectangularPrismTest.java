package com.csc205.project2.shapes;

import com.csc205.project2.shapes.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RectangularPrismBasicFunctionalityTest {
    @Test
    void testCreation() {
        RectangularPrism r = new RectangularPrism(2, 3, 4);
        assertEquals(24, r.getVolume());
    }
}

class RectangularPrismCalculationAccuracyTest {
    @Test
    void testSurfaceArea() {
        RectangularPrism r = new RectangularPrism(2, 3, 4);
        assertEquals(52, r.getSurfaceArea(), 0.0001);
    }
}

class RectangularPrismBoundaryTest {
    @Test
    void testSmallDimensions() {
        RectangularPrism r = new RectangularPrism(0.001, 0.001, 0.001);
        assertTrue(r.getVolume() > 0);
    }
}

class RectangularPrismInputValidationTest {
    @Test
    void testInvalidDimension() {
        assertThrows(IllegalArgumentException.class,
                () -> new RectangularPrism(-1, 2, 3));
    }
}

class RectangularPrismInheritanceTest {
    @Test
    void testIsShape3D() {
        RectangularPrism r = new RectangularPrism(1, 1, 1);
        assertTrue(r instanceof Shape3D);
    }
}