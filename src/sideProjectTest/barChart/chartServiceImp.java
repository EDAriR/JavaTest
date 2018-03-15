package sideProjectTest.barChart;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.DrawingSupplier;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.title.Title;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.TextAnchor;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class chartServiceImp  {

    public static void main( String[ ] args )throws Exception {

        ArrayList<Data> datas  = setDatas();

        DefaultCategoryDataset dataset = new DefaultCategoryDataset( );

        for (Data d:datas) {
            dataset.addValue(d.getMaleNumber(), "Male", d.getUnitName());
//            dataset.addValue(d.getMaleNumber(), "", d.getUnitName());
            dataset.addValue(d.getFamaleNumber(), "FaMale", d.getUnitName());
        }

        JFreeChart barChart = ChartFactory.createBarChart(
                "血壓項目名稱",
                "", "數值",
                dataset, PlotOrientation.VERTICAL,
                true, true, false);

        barChart.setBackgroundPaint(Color.white);

        // 改 bar 顏色
        CategoryPlot plot = barChart.getCategoryPlot();
        plot.setNoDataMessage("NO DATA!");

        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        plot.setBackgroundAlpha(1.0f);

        GradientPaint gp0 = new GradientPaint(
                0.0f, 0.0f, new Color(68,144,195),
                0.0f, 0.0f, new Color(68,144,195)
        );
        GradientPaint gp1 = new GradientPaint(
                0.0f, 0.0f, new Color(236,152,49),
                0.0f, 0.0f, new Color(236,152,49)
        );
        GradientPaint gp2 = new GradientPaint(
                0.0f, 0.0f, Color.blue,
                0.0f, 0.0f, Color.blue
        );
        renderer.setSeriesPaint(0, gp0);
        renderer.setSeriesPaint(1, gp1);
        renderer.setSeriesPaint(2, gp2);


        // change the margin at the top of the range axis...
        final ValueAxis rangeAxis = plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        rangeAxis.setLowerMargin(0.0);
        rangeAxis.setUpperMargin(0.0);

        int width = 960;    /* Width of the image */
        int height = 540;   /* Height of the image */
        File BarChart = new File( "BarChart.jpeg" );
        ChartUtilities.saveChartAsJPEG( BarChart , barChart , width , height );


//        OutputStream op = new BufferedOutputStream(new FileOutputStream(BarChart));
//        OutputStream f = new FileOutputStream("BarChart1.jpeg");
//        BufferedImage buf = barChart.createBufferedImage(640, 480, null);
//        ChartUtilities.writeBufferedImageAsJPEG(f , 1.0f, buf);
//        System.out.println(BarChart.length());
    }

    private static ArrayList<Data> setDatas() {


        ArrayList<Data> datas  = new ArrayList<>();

        Data data = new Data();
        data.setUnitName("unti_1");
        data.setFamaleNumber(new Random().nextInt(20));
        data.setMaleNumber(new Random().nextInt(20));
        datas.add(data);
        Data data2 = new Data();
        data2.setUnitName("unti_2");
        data2.setFamaleNumber(new Random().nextInt(20));
        data2.setMaleNumber(new Random().nextInt(20));
        datas.add(data2);
        Data data3 = new Data();
        data3.setUnitName("unti_3");
        data3.setFamaleNumber(new Random().nextInt(20));
        data3.setMaleNumber(new Random().nextInt(20));
        datas.add(data3);

//        Data data4 = new Data();
//        data4.setUnitName("unti_4");
//        data4.setFamaleNumber(new Random().nextInt(20));
//        data4.setMaleNumber(new Random().nextInt(20));
//        datas.add(data4);
//
//        Data data5 = new Data();
//        data5.setUnitName("unti_5");
//        data5.setFamaleNumber(new Random().nextInt(20));
//        data5.setMaleNumber(new Random().nextInt(20));
//        datas.add(data5);

        for(Data d:datas)
            System.out.println("rrr  : " + d.getUnitName());

        return datas;
    }

}
