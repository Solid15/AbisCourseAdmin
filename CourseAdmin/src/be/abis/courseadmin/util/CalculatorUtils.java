package be.abis.courseadmin.util;

import be.abis.courseadmin.functionalinterface.Calculator;

public class CalculatorUtils {

    public static double callCalculator(Calculator c, int i, double d) {
        return c.performCalculation(i,d);
    }


}
