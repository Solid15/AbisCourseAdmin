package be.abis.courseadmin.admin;

import be.abis.courseadmin.enumm.Gender;
import be.abis.courseadmin.util.StringUtils;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Person {

    private static int counter;

    private String firstName;
    private String lastName;
    private Gender gender;
    private Company company;
    private int personNumber;
    private Set<String> hobbies = new TreeSet<>();              // TreeSet is a sorted set (alphabetical, in case of strings)

    public Person(String firstName, String lastName, Gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        counter++;
        personNumber = counter;
    }

    public Person(String firstName, String lastName, Gender gender, Company company) {
        this(firstName, lastName, gender);
        this.company = company;
    }

    public void printInfo() {
        String lastPart;
        if (company == null) {
            lastPart = " is not linked to a company for the moment.";
        } else {
            lastPart = " works for " + company.getName() + ".";
        }
        System.out.println("be.abis.course.Person " + personNumber + ": " + firstName + " " + lastName + ". " +
                StringUtils.capitalizeFirstLetter(gender.getPronoun()) + lastPart);
    }

    public void attendCourse(Course course) {
        System.out.println(firstName + " is attending a " + course.getTitle() + " course.");
    }

    public void addHobby(String hobby) {
        hobbies.add(hobby);
    }
        /**                                                     // when it was still a String[] Array
        boolean hobbyAdded = false;
        for (int i =0 ; i< hobbies.length ; i++) {              // or use an int to track hobbies[i] -> no NULL check necessary
            if (hobbies[i] == null) {
                hobbies[i] = hobby;
                hobbyAdded = true; break;
            }
        }
        if (hobbyAdded) {
            System.out.println("Hobby " + hobby + " added.");
        } else {
            System.out.println("No hobby slots available. Hobby " + hobby + " was NOT added.");
        }
        */

                                                    // varargs... = variable number of arguments (pre-undefined number)
    public void addHobbies(String... hobbies) {     // varargs... must be the last passed variable of method
        for (String hobby : hobbies) {
            addHobby(hobby);
        }
    }



    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        System.out.println("Warning: counter cannot be manually overridden.");
     // be.abis.course.Person.counter = counter;
    }

    public int getPersonNumber() {
        return personNumber;
    }

    public void setPersonNumber(int personNumber) {
        this.personNumber = personNumber;
    }

    public Set<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(Set<String> hobbies) {
        this.hobbies = hobbies;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
