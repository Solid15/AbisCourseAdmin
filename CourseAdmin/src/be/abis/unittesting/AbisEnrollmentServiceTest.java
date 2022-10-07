package be.abis.unittesting;

import be.abis.courseadmin.model.CourseParticipant;
import be.abis.courseadmin.model.Person;
import be.abis.courseadmin.service.AbisEnrollmentService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AbisEnrollmentServiceTest {

    private AbisEnrollmentService enrollmentService;
    private List<CourseParticipant> participants;
    private Person person1; private Person person2; private Person person3; private Person person4; private Person person5;

    @BeforeEach
    void setUp() throws Exception {
        enrollmentService = new AbisEnrollmentService();
        person1 = new Person("Marie", "De La Braderie");
        person2 = new Person("John", "The Lion");
        person3 = new Person("Sergei", "Maximov");
        person4 = new Person("Saintan", "DeRoo");
        person5 = new Person("Antonov", "Maximov");
        participants = new ArrayList<>();
        participants.add(person1); participants.add(person2); participants.add(person3);
        participants.add(person4); participants.add(person5);
    }

    @AfterEach
    void tearDown() throws Exception {
        enrollmentService = null; participants = null;
        person1 = null; person2 = null; person3 = null; person4 = null; person5 = null;
    }

    @Test
    void testSortParticipantsByLastNameWithSomeOtherCode() {
        List<CourseParticipant> sortedParticipants = new ArrayList<>();
        sortedParticipants.add(person1); sortedParticipants.add(person4); sortedParticipants.add(person3);
        sortedParticipants.add(person5); sortedParticipants.add(person2);
        assertEquals(sortedParticipants, enrollmentService.sortParticipantsByLastNameWithSomeOtherCode(participants));
    }


}