package be.abis.courseadmin.service;

import be.abis.courseadmin.model.CourseParticipant;
import java.util.List;

public interface EnrollmentService {

    List<CourseParticipant> sortParticipantsByPersonNumber(List<CourseParticipant> participants);
    List<CourseParticipant> sortParticipantsByLastName(List<CourseParticipant> participants);
    List<CourseParticipant> sortParticipantsByFirstName(List<CourseParticipant> participants);
    List<CourseParticipant> sortParticipantsByLastNameAndFirstName(List<CourseParticipant> participants);
}
