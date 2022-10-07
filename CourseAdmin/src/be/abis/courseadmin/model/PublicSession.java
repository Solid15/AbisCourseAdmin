package be.abis.courseadmin.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class PublicSession extends Session {

    private final static Company abis = new Company("ABIS");
    private List<CourseParticipant> enrollments = new ArrayList();

    public PublicSession(Course course, LocalDate startDate, Company location, Person instructor, Person organizer, int numberOfPersons) {
        super(course, startDate, location, getAbis(), instructor, organizer, numberOfPersons);        // PublicSession is ALWAYS ABIS as company
    }

    public void addEnrollment(CourseParticipant courseParticipant) {
        enrollments.add(courseParticipant);
    }

    public void addEnrollments(CourseParticipant... courseParticipants) {
    //    enrollments.addAll(List.of(courseParticipants));                    // requires java 9
        enrollments.addAll(Arrays.asList(courseParticipants));
    }

    public void cancelEnrollment(CourseParticipant courseParticipant) {
        enrollments.remove(courseParticipant);
    }

    public void printParticipantList() {
        for (CourseParticipant participant: enrollments) {
            enrollments.iterator().next().printInfo();
        }
    }

    public List<CourseParticipant> findAbisParticipants() {
        List<CourseParticipant> abisParticipants = new ArrayList<>();

        Iterator<CourseParticipant> iteration =enrollments.listIterator();      //  enhanced for-each is the better option
        while (iteration.hasNext()) {
            Person participant = (Person)iteration.next();
            if (participant.getCompany().getCompanyName().equalsIgnoreCase("ABIS")) {
                abisParticipants.add(participant);
            }
        }
        return abisParticipants;
    }

    public void removeAbisParticipants() {
        for (CourseParticipant participant: enrollments) {
            Person person = (Person) enrollments.iterator().next();
            if(person.getCompany().getCompanyName().equalsIgnoreCase("ABIS")) {
                enrollments.remove(participant);
            }
        }
    }

    @Override
    public double calculatePrice() {
        return 200;
    }
    public static Company getAbis() { return abis; }

    @Override
    public Person getOrganizer() {
        return super.organizer;
    }

    public List<CourseParticipant> getEnrollments() {
        return enrollments;
    }

    public void setEnrollments(List<CourseParticipant> enrollments) {
        this.enrollments = enrollments;
    }
}
