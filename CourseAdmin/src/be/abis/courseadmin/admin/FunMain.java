package be.abis.courseadmin.admin;

import be.abis.courseadmin.functionalinterface.Calculator;
import be.abis.courseadmin.functionalinterface.Printer;
import be.abis.courseadmin.util.CalculatorUtils;
import be.abis.exception.PriceException;
import be.abis.courseadmin.enumm.Gender;
import be.abis.courseadmin.util.StringUtils;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;

public class FunMain {
    public static void main (String[] args) {

        Course javaCourse = new Course("Java", 90, 15.76);
        javaCourse.printInfo();
        System.out.println("Total price is: " + javaCourse.calculateTotalPrice());

        Company abis = new Company("Abis");
        abis.printInfo();

        Person mary = new Person("Mary", "Jones", Gender.FEMALE, abis);
        Person john = new Person("John", "Doe", Gender.MALE);

        mary.printInfo();
        john.printInfo();

        Person[] persons = {mary, john, new Person("Bob", "Verheyden", Gender.OTHER),
                new Person("Kim", "Wauters", Gender.MALE, new Company("Smals"))};

        for (int i=0; i<persons.length ;i++) {
            persons[i].printInfo();
        }

        for (Person person : persons) {                             // enhanced for-loop    // for each
            person.printInfo();
        }
        System.out.println("METHOD REFERENCE");
   //     persons(System.out::println);                              //  even shorter with method::reference

        System.out.println(javaCourse.calculateTotalPrice(96));
        System.out.println(javaCourse.calculateTotalPrice(5));
        System.out.println(javaCourse.calculateTotalPrice(225));
        System.out.println(javaCourse.calculateTotalPrice(-14));

        persons[2].attendCourse(javaCourse);

        mary.addHobby("Playing the violin");
        mary.addHobbies("Soccer", "Piano", "Crypto", "Dancing", "Krav Maga", "Jijutsu", "Rugby", "Reading", "Chess",
                "Hardstyle", "Metal", "Drums", "Tarot", "Astronomy");
        // System.out.println(Arrays.toString(mary.getHobbies()));  // String[]

        Instructor sandy = new Instructor("Sandy", "Lastly", Gender.FEMALE, abis, 3457.4);

        System.out.println();
        System.out.println("Testing Capitalizing method: " + StringUtils.capitalizeFirstLetter(Gender.FEMALE.getPronoun()));
        System.out.println("Testing non-capitalized: " + Gender.MALE.getPronoun() + " " + Gender.OTHER.getPronoun());

        System.out.println();
        System.out.println("-----------------------------------------------------------");
        System.out.println("-----------------------------------------------------------");

        CompanySession session = new CompanySession(persons.length, javaCourse);
        try {
            System.out.println("Total sessions price is " + session.calculatePrice());
        } catch (PriceException exception) {
            System.out.println(exception.getMessage());
        } finally {
            System.out.println("Should always print");
        }

        System.out.println();
        try { System.out.println(abis.requestPriceOfferForCompanySession(javaCourse, 5));
        } catch (PriceException exception) {
            System.out.println(exception.getMessage());
        }

        mary.addHobbies("soccer", "soccer", "soccer", "soccer", "soccer", "soccer");
        System.out.println(mary.getHobbies());

        System.out.println();
        Date date = new Date();             // old version
        System.out.println(date);

        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();                              // new version
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDate);                                      // year - month - day
        System.out.println(localTime);
        System.out.println(localDateTime);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");      //  american date notation Formatter
        DateTimeFormatter roundedTime = DateTimeFormatter.ofPattern("kk:mm:ss");
        System.out.println(localTime.format(roundedTime));

        double someDouble = 1.2367;                                             // #.00 will use . everywhere except for intelliJ
        DecimalFormat decimalFormat = new DecimalFormat("#.00");         // numberFormatter  // intelliJ makes this ,
        System.out.println(decimalFormat.format(someDouble));                   // prints 1,24   (rounded print)

        DecimalFormat decimalFormatWithComma = new DecimalFormat("#,##0.00");       // always uses , instead of .
        System.out.println(decimalFormatWithComma.format(someDouble));           //  . or ,  might be country-specific

        Printer printer = () -> System.out.println("Lambda test print");
        printer.print();                                                        // works

        Calculator calc = (x, y) -> x * y;                                       // x & y never used before in method !!!!
        System.out.println(calc.performCalculation(5, 7.8));                 // lambda
        System.out.println(CalculatorUtils.callCalculator(calc, 12, 7.7));
        System.out.println(decimalFormatWithComma.format(CalculatorUtils.callCalculator((i, d) -> i/d, 65, 7)));

        DecimalFormat decimalFormatWithOneComma = new DecimalFormat("#,#0.0");  // #,#  !!==  #,#0.0 !!!!
        System.out.println(decimalFormatWithOneComma.format(CalculatorUtils.callCalculator((i, d) -> d*i, 15 ,2.7)));

        String x = "x";
        StringBuilder sb = new StringBuilder("StringBuilder");
        for (int i = 0; i < 5; i++) {
            sb.append(x);
        }
        System.out.println(sb);

        StringBuilder sb2 = new StringBuilder("s");
        System.out.println(sb == sb2);
        System.out.println(sb.toString().equals(sb2.toString()));







    }
}