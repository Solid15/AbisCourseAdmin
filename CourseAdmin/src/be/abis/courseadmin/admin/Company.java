package be.abis.courseadmin.admin;

import be.abis.exception.PriceException;

public class Company {

    private String name;

    public Company(String name) {
        this.name = name;
    }

    public void printInfo() {
        System.out.println("The company's name is " + name + ".");
    }

    public double requestPriceOfferForCompanySession(Course course, int numberOfParticipants) throws PriceException {
        return new CompanySession(numberOfParticipants, course).calculatePrice();
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
