package tk.xerohero;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

import javax.swing.*;

public class GraphUtility {

    static void constructChart(JFrame frame, double freeBytes, double usedBytes) {
        PieDataset pieDataset = createDataset(usedBytes, freeBytes);
        JFreeChart jFreeChart = createChart(pieDataset);
        jFreeChart.setAntiAlias(true);
        ChartPanel chartPanel = new ChartPanel(jFreeChart);
        frame.add(chartPanel);
    }

    private static PieDataset createDataset(double used, double free) {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Used", used);
        dataset.setValue("Free", free);
        return dataset;
    }

    private static JFreeChart createChart(PieDataset dataset) {
        return ChartFactory.createPieChart(
                "Disk Space Status", // chart title
                dataset, // data
                true, // include legend
                true,
                false);
    }


}
