package be.abis.courseadmin.util;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class NumberUtils {

/**    public static DecimalFormat setUpFormat() {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setDecimalSeparator(,);    ...    ...    ...
    }
  */

    public static String numberTwoDigitsBehindTheCommaFormatter(double number) {
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
        return decimalFormat.format(number);
    }
}
