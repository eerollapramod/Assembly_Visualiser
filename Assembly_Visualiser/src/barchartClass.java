
import java.awt.Color;
//import javafx.scene.chart.CategoryAxis;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author PramodEerolla
 */
public class barchartClass extends myFrame {

    // method for bar chart creation
    public JFreeChart barchartMethod(int N50) {
        // display barchart with contigs length and N50
        DefaultCategoryDataset dcd = new DefaultCategoryDataset();
        //int N50 = statsMethodsClass.get()
        for (int i = 0; i < seqsArray.length; i++) {
            if ((seqsArray[i].length() == N50)) {//checks if the sequenc at current index is equal to N50
                //if the above requirement met, this will be set as N50 on barchart
                dcd.setValue(seqsArray[i].length(), "N50",String.valueOf(i));
            } else {
                // if the first requirement is not met, this will be set as other contigs.
                dcd.setValue(seqsArray[i].length(), "Other Contigs", String.valueOf(i));
            }
            //System.out.println(N50);

        }
        // creating a chart with title, axis labels, data, orientation and other preferences
        JFreeChart jChart = ChartFactory.createBarChart("Contigs Viewer", "", "Contigs Length", dcd, PlotOrientation.VERTICAL, true, true, false);
        CategoryPlot catPlot = jChart.getCategoryPlot(); // Creates a category plot
//        CategoryAxis xAxis = catPlot.getDomainAxis();//gets the x-axis values
//        xAxis.setTickLabelsVisible(false);//sets x-xis values visible om the chart
        catPlot.setRangeGridlinePaint(Color.black);// sets the range grid background colour to black

        return jChart;// returns the chart
    }

}
