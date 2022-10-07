package be.abis.unittesting;

import be.abis.courseadmin.util.CalculatorUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorUtilsTest {

//    @BeforeEach
//    @AfterEach

    @Test
    void testCallCalculator() {
        assertEquals(15, CalculatorUtils.callCalculator((i, d) -> i*d, 3, 5));
        assertEquals(27.1, CalculatorUtils.callCalculator((i, d) -> i - d, 30, 2.9 ));
        assertEquals(18.4, CalculatorUtils.callCalculator(Double::sum, 15, 3.4));
    }


}
