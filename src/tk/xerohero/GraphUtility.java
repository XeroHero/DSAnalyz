package tk.xerohero;

import org.jfree.chart.*;
import org.jfree.chart.entity.ChartEntity;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

import javax.swing.*;

import static tk.xerohero.DetailsWindow.detailsPaneUsed;

//import static org.graalvm.compiler.debug.DebugOptions.Log;

/**
 * This class controls the Graph settings to construct the PieChart in the main screen of the program
 */
public class GraphUtility {

    static void constructChart(JFrame frame, double freeBytes, double usedBytes) {
        PieDataset pieDataset = createDataset(usedBytes, freeBytes);
        JFreeChart jFreeChart = createChart(pieDataset);
        jFreeChart.setAntiAlias(true);
        ChartPanel chartPanel = new ChartPanel(jFreeChart);
        clickEventHandler(chartPanel);
        frame.add(chartPanel);
    }

    private static void clickEventHandler(ChartPanel chartPanel) {
        chartPanel.addChartMouseListener(new ChartMouseListener() {
            @Override
            public void chartMouseClicked(ChartMouseEvent event) {
                ChartEntity entity = event.getEntity();
                // CASE 1: "PieSection: 0, 1(Free)" ==> FREE
                // CASE 2: "PieSection: 0, 0(Used)" ==> USED

                switch (entity.toString()){
                    case "PieSection: 0, 1(Free)":
                        System.out.println("Clicked on FRee");
                        detailsPaneUsed();
                        new DetailsWindow();
                        break;
                    case "PieSection: 0, 0(Used)":
//                        new DetailsWindow();
                        System.out.println("Clicked on Used");
                        break;
                }
            }

            @Override
            public void chartMouseMoved(ChartMouseEvent event) {

            }
        });
    }


    private static PieDataset createDataset(double used, double free) {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Used", used);
        dataset.setValue("Free", free);
        return dataset;
    }

    private static JFreeChart createChart(PieDataset dataset) {
        return ChartFactory.createPieChart(
                "Main Disk Space Status", // chart title
                dataset, // data
                true, // include legend
                true,
                false);
    }


}
