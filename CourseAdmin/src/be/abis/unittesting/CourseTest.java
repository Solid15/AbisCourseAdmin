package be.abis.unittesting;

import be.abis.courseadmin.admin.Course;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CourseTest {

    private Course course;

    @BeforeEach
    public void setUp() throws Exception {
        course = new Course("Java", 100, 30);
    }

    @AfterEach
    public void tearDown() throws Exception {
        course = null;
    }

    @Test
    void testCalculateTotalPrice() {
        assertEquals(3000, course.calculateTotalPrice());
    }

    @Test
    void testCalculateTotalPriceBy10Reduction() {
        assertEquals(2700, course.calculateTotalPrice(10));
    }

    @Test
    void testCalculateTotalPriceBy500Reduction()  {
        assertEquals(0, course.calculateTotalPrice(500));
    }

    @Test
    void testCalculateTotalPriceByNegative10Reduction()  {
        assertEquals(3000, course.calculateTotalPrice(-10));
    }
}