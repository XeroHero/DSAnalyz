package tk.xerohero;

import javax.swing.*;
import java.awt.*;

import static tk.xerohero.GraphUtility.constructChart;

public class GUI {
    static void layoutFrame(JFrame frame, double freeBytes, double usedBytes, JTextField total, JTextField free, JTextField used) {
        frame.getContentPane().add(BorderLayout.NORTH, total);
        frame.getContentPane().add(BorderLayout.CENTER, free);
        frame.getContentPane().add(BorderLayout.SOUTH, used);
        constructChart(frame, freeBytes, usedBytes);
        frame.setVisible(true);
        frame.setSize(300, 300);
    }

}
