package be.abis.courseadmin.model;

import be.abis.courseadmin.util.DateUtils;
import be.abis.courseadmin.util.NumberUtils;
import be.abis.exception.*;

import java.time.LocalDate;

public abstract class Session extends Service {

    private Course course;
    private LocalDate startDate;
    private Company location;
    private Company company;
    private Person instructor;
    protected Person organizer;
    public int numberOfPersons;

    public Session(Course course, LocalDate startDate, Company location, Company company, Person instructor, Person organizer , int numberOfPersons) {
        this.course = course;
        this.startDate = startDate;
        this.location = location;
        this.company = company;
        this.instructor = instructor;
        this.organizer = organizer;
        this.numberOfPersons = numberOfPersons;
    }

    protected void printInfo() {
        System.out.println("The " + course.getCourseName() + " course will start on " +
                DateUtils.europeanDateFormatter(startDate) + ". It will take place at " +
                location.getCompanyName() + ". Your instructor is " + instructor.getFirstName() + " " +
                instructor.getLastName() + " of " + company.getCompanyName() + ".");
    }

    public double calculatePrice() throws PriceException {
        double sessionPrice = numberOfPersons * course.calculateTotalPrice();
        if (sessionPrice >6000) {
            throw new PriceTooHighException(sessionPrice + " is too high of a price to pay.");
        } else {
            if (sessionPrice < 5000) {
                throw new PriceTooLowException(sessionPrice + " is too low of a price to pay.");
            }
        }
        return sessionPrice;
    }

    public String calculatePriceFormatter() throws PriceException {
        return NumberUtils.numberTwoDigitsBehindTheCommaFormatter(calculatePrice());
    }


    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public Company getLocation() {
        return location;
    }

    public void setLocation(Company location) {
        this.location = location;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Person getInstructor() {
        return instructor;
    }

    public void setInstructor(Person instructor) {
        this.instructor = instructor;
    }

    public abstract Person getOrganizer();

    public void setOrganizer(Person organizer) {
        this.organizer = organizer;
    }

    public int getNumberOfPersons() {
        return numberOfPersons;
    }

    public void setNumberOfPersons(int numberOfPersons) {
        this.numberOfPersons = numberOfPersons;
    }
}
