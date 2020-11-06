package tk.xerohero;

import javax.swing.*;
import java.io.File;
import java.text.ParseException;

import static tk.xerohero.Calculations.roundOneDp;
import static tk.xerohero.Main.*;

/**
 * This class contains calls to the OS layer functions to obtain all
 * the information relative to the underlying operating systems, as
 * different OSs have different addressing strategies and partition
 * tables. This can cause issues when we are obtaining the references
 * to the root partitions of the drives, and therefore there are many
 * check to be performed here.
 */
public class OsFunctions {

    public static String getOsType() {
        return System.getProperty("os.name");
    }

    static void getSpaceReadings(double freeBytes, double totalBytes, double usedBytes) throws ParseException {
        total = new JTextField("Total: \t" + roundOneDp(totalBytes).toString() + "GB");
        free = new JTextField("Free: \t" + roundOneDp(freeBytes).toString() + "GB");
        used = new JTextField("Used: \t" + roundOneDp(usedBytes).toString() + "GB");

        total.setEditable(false);
        free.setEditable(false);
        used.setEditable(false);
    }

    static void determineOsCalculation() {
        switch (getOsType()) {
            case "Linux" -> {
                freeBytes = new File("/").getFreeSpace();
                totalBytes = new File("/").getTotalSpace();
            }
            case "Windows" -> {
                String windowsDir = System.getenv("windir");
                freeBytes = new File(windowsDir).getFreeSpace();
                totalBytes = new File(windowsDir).getTotalSpace();
            }
        }
    }
}
