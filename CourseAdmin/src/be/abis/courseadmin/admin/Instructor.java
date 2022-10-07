package be.abis.courseadmin.admin;

import be.abis.courseadmin.enumm.Gender;

public class Instructor extends Person {

    private double salary;

    public Instructor(String firstName, String lastName, Gender gender) {
        super(firstName, lastName, gender);
    }

    public Instructor(String firstName, String lastName, Gender gender, Company company, double salary) {
        super(firstName, lastName, gender, company);
        this.salary = salary;
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println(salary);
    }


    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
