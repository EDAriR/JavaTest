package sideProjectTest.barChart;

import org.jfree.chart.*;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.SubCategoryAxis;
import org.jfree.chart.axis.TickUnitSource;
import org.jfree.chart.axis.ValueAxis;
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
import java.io.*;

public class StackedBarChartDemo4 extends ApplicationFrame {

    /**
     * Creates a new demo.
     *
     * @param title  the frame title.
     */
    public StackedBarChartDemo4(final String title) throws IOException {
        super(title);
        CategoryDataset dataset = createDataset();
        JFreeChart chart = createChart(dataset);
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

//        result.addValue(25, "xxx", "卑南鄉");
//        result.addValue(20.4, "aaa", "卑南鄉");
//        result.addValue(20.5, "yyyy", "卑南鄉");
//        result.addValue(100.2, "", "卑南鄉");
//
//        result.addValue(23.3, "xxx", "台東市");
//        result.addValue(12.7, "aaa", "台東市");
//        result.addValue(15.4, "yyyy", "台東市");
//        result.addValue(23.8, "", "台東市");
//
//        result.addValue(11.9, "xxx", "大武鄉");
//        result.addValue(15.3, "aaa", "大武鄉");
//        result.addValue(23.9, "yyyy", "大武鄉");
//        result.addValue(13.2, "", "大武鄉");

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
                "血壓量測人數",          // chart title 大標題
                "",           // domain axis label
                "",             // range axis label 縱軸數值欄位名稱
                dataset,                     // data
                PlotOrientation.VERTICAL,    // the plot orientation
                true,                        // legend
                true,                        // tooltips
                false                        // urls
        );

        GroupedStackedBarRenderer renderer = new GroupedStackedBarRenderer();
//        KeyToGroupMap map = new KeyToGroupMap("G1");
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
//        renderer.setSeriesToGroupMap(map);

        renderer.setItemMargin(0.3);
        Paint p1 = new GradientPaint(
                0.0f, 0.0f, new Color(0x22, 0x22, 0xFF), 0.0f, 0.0f,
                new Color(0x22, 0x22, 0xFF)
        );
        renderer.setSeriesPaint(0, p1);
        renderer.setSeriesPaint(6, p1);
        renderer.setSeriesPaint(12, p1);

        Paint p2 = new GradientPaint(
                0.0f, 0.0f, new Color(255, 93, 16), 0.0f, 0.0f,
                new Color(255, 93, 16)
        );
        renderer.setSeriesPaint(1, p2);
        renderer.setSeriesPaint(7, p2);
        renderer.setSeriesPaint(13, p2);

        Paint p3 = new GradientPaint(
                0.0f, 0.0f, new Color(108, 108, 108), 0.0f, 0.0f,
                new Color(108, 108, 108)
        );
        renderer.setSeriesPaint(2, p3);
        renderer.setSeriesPaint(8, p3);
        renderer.setSeriesPaint(14, p3);

        Paint p4 = new GradientPaint(
                0.0f, 0.0f, new Color(0xFF, 212, 19), 0.0f, 0.0f,
                new Color(0xFF, 212, 19)
        );
        renderer.setSeriesPaint(3, p4);
        renderer.setSeriesPaint(9, p4);
        renderer.setSeriesPaint(15, p4);

        Paint p5 = new GradientPaint(
                0.0f, 0.0f, new Color(67, 0xFF, 250), 0.0f, 0.0f,
                new Color(67, 0xFF, 250)
        );
        renderer.setSeriesPaint(4, p5);
        renderer.setSeriesPaint(10, p5);
        renderer.setSeriesPaint(16, p5);

        Paint p6 = new GradientPaint(
                0.0f, 0.0f, new Color(88, 0xFF, 62), 0.0f, 0.0f,
                new Color(88, 0xFF, 62)
        );
        renderer.setSeriesPaint(5, p6);
        renderer.setSeriesPaint(11, p6);
        renderer.setSeriesPaint(17, p6);

        renderer.setGradientPaintTransformer(
                new StandardGradientPaintTransformer(GradientPaintTransformType.HORIZONTAL)
        );

//        SubCategoryAxis domainAxis = new SubCategoryAxis("Product / Month");
//        domainAxis.setCategoryMargin(0.05);
//        domainAxis.addSubCategory("Product 1");
//        domainAxis.addSubCategory("Product 2");
//        domainAxis.addSubCategory("Product 3");

        CategoryPlot plot = (CategoryPlot) chart.getPlot();
//        plot.setDomainAxis(domainAxis);
        //plot.setDomainAxisLocation(AxisLocation.TOP_OR_RIGHT);
        plot.setRenderer(renderer);
        plot.setFixedLegendItems(createLegendItems());

        ValueAxis rangeAxis = plot.getRangeAxis();

        //設置Y轴的最小值
        rangeAxis.setLowerBound(0);

        // 設置 Y軸刻度 為整數
//        NumberAxis axis = (NumberAxis) plot.getRangeAxis();
        TickUnitSource units = NumberAxis.createIntegerTickUnits();
        rangeAxis.setStandardTickUnits(units);

        // 標題
        chart.getTitle().setFont(font14);

        rangeAxis.setLabelFont(font10);
        //设置x轴坐标字体
        rangeAxis.setTickLabelFont(font10);
        //y轴
        //设置y轴标题字体
        rangeAxis.setLabelFont(font10);
        //设置y轴坐标字体
        rangeAxis.setTickLabelFont(font10);

        return chart;

    }

    private static Font font10;//普通字体 10号
    private static Font font14;//标题字体 14号

    static//静态加载字体,实现linux中不安装字体 使jre显示中文
    {
        try
        {

//            File file = new File("NotoSansCJK-Medium.ttc");
//            File file = new File("wqy-microhei.ttc");
            File file = new File("NotoSansCJKtc-Medium.otf");
            FileInputStream fb = new FileInputStream(file);
            System.out.println("get input stream success");
//            Font nf = Font.createFont(Font.TRUETYPE_FONT, new File("wqy-microhei.ttf"));

            Font nf = Font.createFont(Font.TRUETYPE_FONT, fb);
            System.out.println("createFont");
            font10 = nf.deriveFont(Font.BOLD, 10);
            font14 = nf.deriveFont(Font.BOLD, 16);
        } catch (Exception e) {
            //TODO 抛出"配置错误"异常
            e.printStackTrace();
        }
    }

    /**
     * Creates the legend items for the chart.  In this case, we set them manually because we
     * only want legend items for a subset of the data series.
     *
     * @return The legend items.
     */
    private LegendItemCollection createLegendItems() {
        LegendItemCollection result = new LegendItemCollection();
        LegendItem item1 = new LegendItem("30", new Color(0x22, 0x22, 0xFF));
        LegendItem item2 = new LegendItem("30-39", new Color(255, 104, 43));
        LegendItem item3 = new LegendItem("40-49", new Color(108, 108, 108));
        LegendItem item4 = new LegendItem("50-59", new Color(0xFF, 212, 19));
        LegendItem item5 = new LegendItem("60-69", new Color(67, 0xFF, 250));
        LegendItem item6 = new LegendItem("75", new Color(88, 0xFF, 62));
        result.add(item1);
        result.add(item2);
        result.add(item3);
        result.add(item4);
        result.add(item5);
        result.add(item6);
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
        int width = 120 * 2 ;    /* Width of the image */
        int height = 540;   /* Height of the image */
        File BarChart = new File( "BarChart_NotoSansCJKtc-Medium.jpeg" );
        ChartUtilities.saveChartAsJPEG( BarChart , chart , width , height );
    }

}
