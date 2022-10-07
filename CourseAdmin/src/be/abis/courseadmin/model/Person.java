package be.abis.courseadmin.model;

import java.util.Set;
import java.util.TreeSet;

public class Person implements Instructor, CourseParticipant, Comparable<CourseParticipant> {

    private static int counter = 0;

    private String firstName;
    private String lastName;
    private Role role;
    private Company company;
    private final int personNumber;
    private Set<String> hobbies = new TreeSet<>();

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        counter++;
        this.personNumber = counter;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

    public void executeCourse(Course course) {
        switch (role) {
            case TEACHER: teachCourse(course); break;
            case STUDENT: attendCourse(course); break;
        }
    }

    @Override
    public void printInfo() {
        System.out.println(personNumber + ": " +firstName + " " + lastName);
    }

    @Override
    public void teachCourse(Course course) {                            // cannot make private method because interface
        System.out.println("Teacher " + firstName + " " + lastName + " is teaching course: " + course);
    }
    @Override
    public void attendCourse(Course course) {
        System.out.println("Student " + firstName + " " + lastName + " is attending course: " + course);
    }

    public void addHobby(String hobby) {
        hobbies.add(hobby);
    }

    @Override
    public int compareTo(CourseParticipant participant) {
        return this.personNumber - ((Person) participant).personNumber;
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


    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public int getPersonNumber() {
        return personNumber;
    }

    public Set<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(Set<String> hobbies) {
        this.hobbies = hobbies;
    }

    public static int getCounter() {
        return counter;
    }


}
