package tk.xerohero;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;

public class Calculations {

    static double roundTwoDp(double val) throws ParseException {
        DecimalFormatSymbols symbols = DecimalFormatSymbols.getInstance();
        symbols.setDecimalSeparator('.');
        DecimalFormat format = new DecimalFormat("#.##", symbols);
        return (double) format.parse(format.format(toGB(val)));
    }

    static double toGB(double bytes) {
        return bytes / (1024 * 1024 * 1024);
    }


}
