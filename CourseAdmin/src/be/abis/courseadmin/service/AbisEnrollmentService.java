package be.abis.courseadmin.service;

import be.abis.courseadmin.model.CourseParticipant;
import be.abis.courseadmin.model.Person;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AbisEnrollmentService implements EnrollmentService {


    @Override
    public List<CourseParticipant> sortParticipantsByPersonNumber(List<CourseParticipant> participants) {
       Collections.sort(participants);      // implemented Comparable<T> in CourseParticipant
       return participants;                 // Collections.sort() refers to CompareTo() method in Person Class
    }                                                                       // only 1 implementation possible

    @Override
    public List<CourseParticipant> sortParticipantsByLastName(List<CourseParticipant> participants) {
        return participants.stream().sorted((p1, p2) -> ((Person)p1).getLastName().compareTo(((Person)p2).getLastName()))
                .collect(Collectors.toList());                              /* streams -> return in one go    */
    }

    public List<CourseParticipant> sortParticipantsByLastNameWithSomeOtherCode(List<CourseParticipant> participants) {
        return participants.stream().sorted(Comparator.comparing(c -> ((Person)c).getLastName())).collect(Collectors.toList());
    }                                               // using streams and Comparator

    @Override
    public List<CourseParticipant> sortParticipantsByFirstName(List<CourseParticipant> participants) {
        participants.sort((p1, p2) -> ((Person)p1).getFirstName().compareTo(((Person)p2).getFirstName()));
        return participants;
    }

    public List<CourseParticipant> sortParticipantsByFirstNameWithSomeOtherCode(List<CourseParticipant> participants) {
        participants.sort(Comparator.comparing(c -> ((Person)c).getFirstName()));       // works as well
        return participants;
    }

    @Override
    public List<CourseParticipant> sortParticipantsByLastNameAndFirstName(List<CourseParticipant> participants) {
        participants.sort(Comparator.comparing(c -> ((Person)c).getLastName()).thenComparing(c -> ((Person)c).getFirstName()));
        return participants;
    }
}
