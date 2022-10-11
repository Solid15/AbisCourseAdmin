package be.abis.courseadmin.model;

import be.abis.courseadmin.repository.FileCompanyRepository;
import be.abis.courseadmin.service.AbisEnrollmentService;
import be.abis.courseadmin.util.CalculatorUtils;
import be.abis.courseadmin.util.DateUtils;
import be.abis.exception.CompanyNotFoundException;
import be.abis.exception.PriceException;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class TestMain {

    public static void main(String[] args) {

        Company ttl = new Company("TTL");
        Company ibm = new Company("IBM");
        Company abis = new Company("ABIS");
        Company smals = new Company("Smals");
        Company egov = new Company("Egov Select");
        Person instructor = new Person("Bob", "Janssens");
        Course java = new Course("Java", 8, 154.83);
        System.out.println(java.calculateTotalPrice(18));

        LocalDate sessionStartDate = LocalDate.of(2022, 10, 24);
        PublicSession abisSession = new PublicSession(java, sessionStartDate, abis, instructor, instructor, 8);
        abisSession.printInfo();

        CompanySession ttlSession = new CompanySession(java, sessionStartDate, abis, ttl, instructor, instructor, 8);
        CompanySession ibmSession = new CompanySession(java, LocalDate.of(2022, 9, 5), abis, ibm, instructor, instructor, 8);
        ibmSession.setNumberOfParticipants(5);
        ttlSession.printInfo();
        ibmSession.printInfo();

        System.out.println();
        Session[] sessions = {abisSession, ttlSession, ibmSession};
        for (Session session: sessions) {
            session.printInfo();
        }

        System.out.println();
        System.out.println("SERVICES EXPERIMENT");
        Consultancy consultancy = new Consultancy();
        Service[] services = {abisSession, ttlSession, ibmSession, consultancy};
        for (Service service : services) {
            try {
                System.out.println(service.calculatePrice());
            } catch (PriceException e) {
                System.out.println(e.getMessage());
            } finally {
                System.out.println("Checked for price errors.");
            }

            if (service instanceof Session) {                                                   // INSTANCE OF
                ((Session)service).printInfo();                                                 // typecasting
                System.out.println("Typecasting successful");
            } else {
                System.out.println("This service is not a session");
            }
        }

        System.out.println();
        System.out.println(java);                   //  same as java.toString()
        System.out.println(ibm);
        System.out.println(instructor);


        System.out.println();
        instructor.setRole(Role.TEACHER);
        instructor.executeCourse(java);

        Person student = new Person("John", "Doe");
        student.setRole(Role.STUDENT);
        student.executeCourse(java);
        student.setRole(Role.TEACHER);
        student.executeCourse(java);

        System.out.println();
        abisSession.printParticipantList();

        System.out.println();
        abisSession.printInfo();


        LocalDate date1 = LocalDate.now();
        LocalTime time1 = LocalTime.now();
        System.out.println(DateUtils.europeanDateFormatter(date1));
        System.out.println(DateUtils.europeanDateFormatterWithoutZeros(date1));
        System.out.println(DateUtils.roundedClockFormatter(time1));




        System.out.println();
        System.out.println(CalculatorUtils.callCalculator((i, d) -> i + d, 5, 7));      // lambda
        System.out.println(CalculatorUtils.callCalculator(Double::sum, 5, 7.8));        // method reference

        Person person1 = new Person("Marie", "De La Braderie");
        Person person2 = new Person("John", "The Lion");
        Person person3 = new Person("Sergei", "Maximov");
        Person person4 = new Person("Saintan", "DeRoo");
        Person person5 = new Person("Antonov", "Maximov");

        AbisEnrollmentService enrollmentService = new AbisEnrollmentService();
        List<CourseParticipant> participants = new ArrayList<>();
        participants.add(person4); participants.add(person2); participants.add(person1);
        participants.add(person3); participants.add(person5);
        for (CourseParticipant p : participants) {
            ((Person)p).printInfo();
        }
        System.out.println("---------------------");
        participants = enrollmentService.sortParticipantsByPersonNumber(participants);
        for (CourseParticipant p : enrollmentService.sortParticipantsByPersonNumber(participants)) { p.printInfo(); }

        System.out.println("---------------------");
        for (CourseParticipant p : enrollmentService.sortParticipantsByLastName(participants)) {
            p.printInfo();
        }

        System.out.println("---------------------");
        for (CourseParticipant p : enrollmentService.sortParticipantsByFirstName(participants)) {
            p.printInfo();
        }

        System.out.println("---------------------");
        for (CourseParticipant p : enrollmentService.sortParticipantsByLastNameAndFirstName(participants)) {
            p.printInfo();
        }

        System.out.println("---------------------");
        for (CourseParticipant p : enrollmentService.sortParticipantsByFirstNameWithSomeOtherCode(participants)) {
            p.printInfo();
        }

        System.out.println("---------------------");
        for (CourseParticipant p : enrollmentService.sortParticipantsByLastNameWithSomeOtherCode(participants)) {
            p.printInfo();
        }

        System.out.println();
        FileCompanyRepository fileCompanyRepository = new FileCompanyRepository();
        fileCompanyRepository.addCompany(abis);
        fileCompanyRepository.addCompany(ibm);
        fileCompanyRepository.addCompany(smals);
        fileCompanyRepository.addCompany(egov);

        try {
            System.out.println(fileCompanyRepository.findCompany("aBiS").getCompanyName());
            System.out.println(fileCompanyRepository.findCompany("ibm").getCompanyName());
            System.out.println(fileCompanyRepository.findCompany("Smals").getCompanyName());
            System.out.println(fileCompanyRepository.findCompany("Egov Select").getCompanyName());
            System.out.println(fileCompanyRepository.findCompany(2));
        } catch (CompanyNotFoundException e) {
            System.out.println(e.getMessage());
        }




    }
}
