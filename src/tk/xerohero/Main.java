package tk.xerohero;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.File;
import java.text.ParseException;

import static javafx.application.Application.launch;
import static tk.xerohero.Calculations.toGB;
import static tk.xerohero.GUI.layoutFrame;
import static tk.xerohero.OsFunctions.determineOsCalculation;
import static tk.xerohero.OsFunctions.getSpaceReadings;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;



public class Main extends Application{


    @Override
    public void start(Stage primaryStage) throws Exception {

        //Draw a line

        Line line = new Line();
        line.setStartX(-10);
        line.setStartY(-0.5);
        line.setEndX(2);
        line.setEndY(2.5);
        Group group = new Group(line);
        Group root = new Group(line);
        Scene scene = new Scene(group,600, 300);
        scene.setFill(Color.BLUEVIOLET);

        Scene rootScene = new Scene(root, 200, 200 );
        primaryStage.setTitle("My first JavaFX Application");
        primaryStage.setScene(rootScene);
        Stage secondStage = new Stage();
        secondStage.setTitle("Second stage");

        primaryStage.show();
        secondStage.show(); //Can apply this to my DSAnalyz Project
    }

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
        launch(args);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}