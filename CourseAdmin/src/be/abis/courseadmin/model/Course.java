package be.abis.courseadmin.model;

import be.abis.courseadmin.util.CalculatorUtils;

public class Course {

    private String courseName;
    private int numberOfDays;
    private double pricePerDay;

    public Course(String courseName, int numberOfDays, double pricePerDay) {
        this.courseName = courseName;
        this.numberOfDays = numberOfDays;
        this.pricePerDay = pricePerDay;
    }


    public double calculateTotalPrice() {
        return numberOfDays*pricePerDay;
    }

    public double calculateTotalPrice(int reductionPercentage) {
        if (reductionPercentage > 100) {
            reductionPercentage = 100;
        }
        if (reductionPercentage < 0) {
            reductionPercentage = 0;
        }
        double originalPrice = calculateTotalPrice();
  //      Calculator c = (x, y) -> (y * (100 - x)) / 100 ;
        return CalculatorUtils.callCalculator((x, y) -> (y * (100 - x)) / 100, reductionPercentage, originalPrice);
  //      return calculateTotalPrice() * (100 - reductionPercentage) / 100;     // reductionPercentage/100.
    }

        @Override
    public String toString() {
        return getCourseName();
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }
}
