package sideProjectTest.barChart;

import org.jfree.chart.*;
import org.jfree.chart.axis.SubCategoryAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.GroupedStackedBarRenderer;
import org.jfree.data.KeyToGroupMap;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.GradientPaintTransformType;
import org.jfree.ui.RefineryUtilities;
import org.jfree.ui.StandardGradientPaintTransformer;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class StackedBarChartDemo4 extends ApplicationFrame {

    /**
     * Creates a new demo.
     *
     * @param title  the frame title.
     */
    public StackedBarChartDemo4(final String title) throws IOException {
        super(title);
        final CategoryDataset dataset = createDataset();
        final JFreeChart chart = createChart(dataset);
//        final ChartPanel chartPanel = new ChartPanel(chart);
//        chartPanel.setPreferredSize(new java.awt.Dimension(590, 350));
//        setContentPane(chartPanel);
        int width = 960;    /* Width of the image */
        int height = 540;   /* Height of the image */
        File BarChart = new File( "BarChart.jpeg" );
        ChartUtilities.saveChartAsJPEG( BarChart , chart , width , height );
    }

    /**
     * Creates a sample dataset.
     *
     * @return A sample dataset.
     */
    private CategoryDataset createDataset() {
        DefaultCategoryDataset result = new DefaultCategoryDataset();

        result.addValue(100, "Product 1 (US)", "unit_1");
        result.addValue(100.4, "Product 1 (Europe)", "unit_2");
        result.addValue(100.5, "Product 1 (Asia)", "unit_3");
        result.addValue(100.2, "Product 1 (Middle East)", "Jan 04");

        result.addValue(23.3, "Product 2 (US)", "unit_4");
        result.addValue(12.7, "Product 2 (Europe)", "unit_5");
        result.addValue(15.4, "Product 2 (Asia)", "unit_6");
        result.addValue(23.8, "Product 2 (Middle East)", "unit_6");

        result.addValue(11.9, "Product 3 (US)", "Jan 04");
        result.addValue(15.3, "Product 3 (Europe)", "Jan 04");
        result.addValue(23.9, "Product 3 (Asia)", "Jan 04");
        result.addValue(13.2, "Product 3 (Middle East)", "Jan 04");

        return result;
    }

    /**
     * Creates a sample chart.
     *
     * @param dataset  the dataset for the chart.
     *
     * @return A sample chart.
     */
    private JFreeChart createChart(final CategoryDataset dataset) {

        final JFreeChart chart = ChartFactory.createStackedBarChart(
                "Stacked Bar Chart Demo 4",  // chart title
                "Category",                  // domain axis label
                "Value",                     // range axis label
                dataset,                     // data
                PlotOrientation.VERTICAL,    // the plot orientation
                true,                        // legend
                true,                        // tooltips
                false                        // urls
        );

        GroupedStackedBarRenderer renderer = new GroupedStackedBarRenderer();
        KeyToGroupMap map = new KeyToGroupMap("G1");
//        map.mapKeyToGroup("Product 1 (US)", "G1");
//        map.mapKeyToGroup("Product 1 (Europe)", "G1");
//        map.mapKeyToGroup("Product 1 (Asia)", "G1");
//        map.mapKeyToGroup("Product 1 (Middle East)", "G1");
//        map.mapKeyToGroup("Product 2 (US)", "G2");
//        map.mapKeyToGroup("Product 2 (Europe)", "G2");
//        map.mapKeyToGroup("Product 2 (Asia)", "G2");
//        map.mapKeyToGroup("Product 2 (Middle East)", "G2");
//        map.mapKeyToGroup("Product 3 (US)", "G3");
//        map.mapKeyToGroup("Product 3 (Europe)", "G3");
//        map.mapKeyToGroup("Product 3 (Asia)", "G3");
//        map.mapKeyToGroup("Product 3 (Middle East)", "G3");
        renderer.setSeriesToGroupMap(map);

        renderer.setItemMargin(0.3);
        Paint p1 = new GradientPaint(
                0.0f, 0.0f, new Color(0x22, 0x22, 0xFF), 0.0f, 0.0f,
                new Color(0x22, 0x22, 0xFF)
        );
        renderer.setSeriesPaint(0, p1);

        Paint p2 = new GradientPaint(
                0.0f, 0.0f, new Color(255, 93, 16), 0.0f, 0.0f,
                new Color(255, 93, 16)
        );
        renderer.setSeriesPaint(1, p2);

        Paint p3 = new GradientPaint(
                0.0f, 0.0f, new Color(0xFF, 212, 19), 0.0f, 0.0f,
                new Color(0xFF, 212, 19)
        );
        renderer.setSeriesPaint(2, p3);

        Paint p4 = new GradientPaint(
                0.0f, 0.0f, new Color(67, 0xFF, 250), 0.0f, 0.0f,
                new Color(67, 0xFF, 250)
        );
        renderer.setSeriesPaint(3, p4);

        Paint p5 = new GradientPaint(
                0.0f, 0.0f, new Color(88, 0xFF, 62), 0.0f, 0.0f,
                new Color(88, 0xFF, 62)
        );
        renderer.setSeriesPaint(4, p5);

        renderer.setGradientPaintTransformer(
                new StandardGradientPaintTransformer(GradientPaintTransformType.HORIZONTAL)
        );

        SubCategoryAxis domainAxis = new SubCategoryAxis("Product / Month");
        domainAxis.setCategoryMargin(0.05);
        domainAxis.addSubCategory("Product 1");
        domainAxis.addSubCategory("Product 2");
        domainAxis.addSubCategory("Product 3");

        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        plot.setDomainAxis(domainAxis);
        //plot.setDomainAxisLocation(AxisLocation.TOP_OR_RIGHT);
        plot.setRenderer(renderer);
        plot.setFixedLegendItems(createLegendItems());
        return chart;

    }

    /**
     * Creates the legend items for the chart.  In this case, we set them manually because we
     * only want legend items for a subset of the data series.
     *
     * @return The legend items.
     */
    private LegendItemCollection createLegendItems() {
        LegendItemCollection result = new LegendItemCollection();
        LegendItem item1 = new LegendItem("US", new Color(0x22, 0x22, 0xFF));
        LegendItem item2 = new LegendItem("Europe", new Color(255, 104, 43));
        LegendItem item3 = new LegendItem("Asia", new Color(0xFF, 212, 19));
        LegendItem item4 = new LegendItem("Middle East", new Color(67, 0xFF, 250));
        LegendItem item5 = new LegendItem("Middle East", new Color(88, 0xFF, 62));
        result.add(item1);
        result.add(item2);
        result.add(item3);
        result.add(item4);
        result.add(item5);
        return result;
    }

    // ****************************************************************************
    // * JFREECHART DEVELOPER GUIDE                                               *
    // * The JFreeChart Developer Guide, written by David Gilbert, is available   *
    // * to purchase from Object Refinery Limited:                                *
    // *                                                                          *
    // * http://www.object-refinery.com/jfreechart/guide.html                     *
    // *                                                                          *
    // * Sales are used to provide funding for the JFreeChart project - please    *
    // * support us so that we can continue developing free software.             *
    // ****************************************************************************

    /**
     * Starting point for the demonstration application.
     *
     * @param args  ignored.
     */
    public static void main(final String[] args) throws IOException {
        final StackedBarChartDemo4 demo = new StackedBarChartDemo4("Stacked Bar Chart Demo 4");
//        demo.pack();
//        RefineryUtilities.centerFrameOnScreen(demo);
//        demo.setVisible(true);

        final CategoryDataset dataset = demo.createDataset();
        final JFreeChart chart = demo.createChart(dataset);
//        final ChartPanel chartPanel = new ChartPanel(chart);
//        chartPanel.setPreferredSize(new java.awt.Dimension(590, 350));
//        setContentPane(chartPanel);
        int width = 960;    /* Width of the image */
        int height = 540;   /* Height of the image */
        File BarChart = new File( "BarChart.jpeg" );
        ChartUtilities.saveChartAsJPEG( BarChart , chart , width , height );
    }

}
