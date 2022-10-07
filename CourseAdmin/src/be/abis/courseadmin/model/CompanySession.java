package be.abis.courseadmin.model;

import java.time.LocalDate;

public class CompanySession extends Session {

    private int numberOfParticipants;

    public CompanySession(Course course, LocalDate startDate, Company location, Company company, Person instructor, Person organizer, int numberOfParticipants) {
        super(course, startDate, location, company, instructor, organizer, numberOfParticipants);
    }

    @Override
    public void printInfo() {
        super.printInfo();
        if (numberOfParticipants == 0) {
            System.out.println("This sessions of offered to you by " + getCompany().getCompanyName() +".");
        } else {
            System.out.println("This sessions of offered to you by " + getCompany().getCompanyName() +
                    ". There will be " + numberOfParticipants + " participants.");
            }
    }

    @Override
    public Person getOrganizer() {
        return super.organizer;
    }

    public int getNumberOfParticipants() {
        return numberOfParticipants;
    }

    public void setNumberOfParticipants(int numberOfParticipants) {
        this.numberOfParticipants = numberOfParticipants;
    }

    @Override
    public double calculatePrice() {
        return 400;
    }
}
