package tk.xerohero;

import javax.swing.*;
import java.io.File;
import java.text.ParseException;

import static tk.xerohero.Calculations.roundTwoDp;
import static tk.xerohero.Main.*;

public class OsFunctions {

    public static String getOsType() {
        return System.getProperty("os.name");
    }

    static void getSpaceReadings(double freeBytes, double totalBytes, double usedBytes) throws ParseException {
        total = new JTextField("Total: \t" + roundTwoDp(totalBytes) + "GB");
        free = new JTextField("Free: \t" + roundTwoDp(freeBytes) + "GB");
        used = new JTextField("Used: \t" + roundTwoDp(usedBytes) + "GB");

        total.setEditable(false);
        free.setEditable(false);
        used.setEditable(false);
    }

    static void determineOsCalculation() {
        if (getOsType().equalsIgnoreCase("Linux")) {
//            String uxDir = System.getenv();
            freeBytes = new File("/").getFreeSpace();
            totalBytes = new File("/").getTotalSpace();
        } else if (getOsType().equalsIgnoreCase("Windows")) {
            String windowsDir = System.getenv("windir");
            freeBytes = new File(windowsDir).getFreeSpace();
            totalBytes = new File(windowsDir).getTotalSpace();
        }
    }


}
