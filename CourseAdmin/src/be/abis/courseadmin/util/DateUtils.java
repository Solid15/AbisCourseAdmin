package be.abis.courseadmin.util;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DateUtils {

    public static String europeanDateFormatter(LocalDate date) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");   // MM months != mm minutes
        return date.format(dateTimeFormatter);
    }

    public static String europeanDateFormatterWithoutZeros(LocalDate date) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("d/M/yy");      // MM months != mm minutes
        return date.format(dateTimeFormatter);
    }

    public static String roundedClockFormatter(LocalTime time) {
  //      DateTimeFormatter roundedTime = DateTimeFormatter.ofPattern("kk:mm:ss");            //  kk is hours
  //      return  time.format(roundedTime);
        return time.format(DateTimeFormatter.ofPattern("kk:hh:mm"));
    }

    public static LocalDate parse(String date) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");   // MM months != mm minutes
        return LocalDate.parse(date, dateTimeFormatter);
    }

}
