package tk.xerohero;

import javax.swing.*;
import java.awt.*;

import static tk.xerohero.GraphUtility.constructChart;

/**
 * This class controls the GUI
 */
public class GUI {
    static void layoutFrame(JFrame frame, double freeBytes, double usedBytes, JTextField total, JTextField free, JTextField used) {
        constructChart(frame, freeBytes, usedBytes);

        JPanel jContentPane = new JPanel();
        jContentPane.add(BorderLayout.WEST, total);
        jContentPane.add(BorderLayout.CENTER, free);
        jContentPane.add(BorderLayout.EAST, used);
        total.setHighlighter(null);
        used.setHighlighter(null);
        free.setHighlighter(null);
        frame.add(BorderLayout.SOUTH, jContentPane);
        frame.setVisible(true);
        frame.setSize(500, 400);

    }
}
