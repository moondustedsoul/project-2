package com.csc205.project2.shapes;

import com.csc205.project2.shapes.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SphereBasicFunctionalityTest {
    @Test
    void testSphereCreation() {
        Sphere s = new Sphere(3.0);
        assertEquals(3.0, s.getRadius());
    }
}

class SphereCalculationAccuracyTest {
    @Test
    void testVolume() {
        Sphere s = new Sphere(2.0);
        assertEquals((4.0 / 3.0) * Math.PI * 8, s.getVolume(), 0.0001);
    }

    @Test
    void testSurfaceArea() {
        Sphere s = new Sphere(2.0);
        assertEquals(4 * Math.PI * 4, s.getSurfaceArea(), 0.0001);
    }
}

class SphereBoundaryTest {
    @Test
    void testSmallRadius() {
        Sphere s = new Sphere(0.0001);
        assertTrue(s.getVolume() > 0);
    }
}

class SphereInputValidationTest {
    @Test
    void testInvalidRadius() {
        assertThrows(IllegalArgumentException.class, () -> new Sphere(0));
    }
}

class SphereInheritanceTest {
    @Test
    void testIsShape3D() {
        Sphere s = new Sphere(1.0);
        assertTrue(s instanceof Shape3D);
    }
}