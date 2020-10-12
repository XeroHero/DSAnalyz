package tk.xerohero;

import javax.swing.*;
import java.io.File;
import java.text.ParseException;

import static tk.xerohero.Calculations.toGB;
import static tk.xerohero.GUI.layoutFrame;
import static tk.xerohero.OsFunctions.determineOsCalculation;
import static tk.xerohero.OsFunctions.getSpaceReadings;

public class Main {
    static JTextField total, free, used;

    static double freeBytes = toGB(new File("/").getFreeSpace());
    static double totalBytes = toGB(new File("/").getTotalSpace());
    static JFrame frame;
    public static void main(String[] args) throws ParseException {
        frame = new JFrame("Space Analyser");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        determineOsCalculation();

        double usedBytes = totalBytes - freeBytes;
        getSpaceReadings(freeBytes, totalBytes, usedBytes);

        layoutFrame(frame, freeBytes, usedBytes, total, free, used);
    }


    @Override
    public String toString() {
        return super.toString();
    }
}
