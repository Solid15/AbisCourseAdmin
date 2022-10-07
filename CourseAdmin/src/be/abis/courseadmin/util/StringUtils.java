package be.abis.courseadmin.util;

public class StringUtils {

    public static String capitalizeFirstLetter (String string) {
       String firstLetter = string.substring(0,1);
       return string.replaceFirst(firstLetter, firstLetter.toUpperCase());

    }
}
