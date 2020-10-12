package tk.xerohero;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class DetailsWindow {
    JFrame frameClass;

    public DetailsWindow() {
        initialize();
    }

    public static void detailsPaneUsed() {
        EventQueue.invokeLater(() -> {
            try {

                DetailsWindow window = new DetailsWindow();
                window.frameClass.setVisible(true);
//                window.initialize();
                System.out.println("Show secondary details OK");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    private void initialize() {
        frameClass = new JFrame();
        frameClass.setTitle("Details");
        frameClass.setSize(200, 200);
        frameClass.setDefaultCloseOperation(EXIT_ON_CLOSE);
        JButton jButton = new JButton();
        jButton.setText("Close");
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameClass.dispose();
                Main.frame.setVisible(true);
//                frameClass.getDefaultCloseOperation();
                System.out.println("Disposed!");
            }
        });
//        detailsPaneUsed();
        jButton.setVisible(true);
        frameClass.add(jButton);
        frameClass.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }

}