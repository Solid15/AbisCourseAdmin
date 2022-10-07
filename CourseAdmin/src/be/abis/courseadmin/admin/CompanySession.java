package be.abis.courseadmin.admin;

import be.abis.exception.PriceException;
import be.abis.exception.PriceTooHighException;
import be.abis.exception.PriceTooLowException;

public class CompanySession {

    private int numberOfPersons;
    private Course course;

    public CompanySession(int numberOfPersons, Course course) {
        this.numberOfPersons = numberOfPersons;
        this.course = course;
    }

    public double calculatePrice() throws PriceException {
        double sessionPrice = numberOfPersons * course.calculateTotalPrice();
        if (sessionPrice >6000) {
            throw new PriceTooHighException(sessionPrice + " is too high of a price to pay.");
        } else {
            if (sessionPrice < 6000) {
                throw new PriceTooLowException(sessionPrice + " is too low of a price to pay.");
            }
        }
        return sessionPrice;
    }

    public double calculatePriceWithReduction(int reduction) {
        return numberOfPersons * course.calculateTotalPrice(reduction);
    }


    public int getNumberOfPersons() {
        return numberOfPersons;
    }

    public void setNumberOfPersons(int numberOfPersons) {
        this.numberOfPersons = numberOfPersons;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}