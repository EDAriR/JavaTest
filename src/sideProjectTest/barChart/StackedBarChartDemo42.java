package sideProjectTest.barChart;


import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFClientAnchor;
import org.apache.poi.xssf.usermodel.XSSFDrawing;
import org.apache.poi.xssf.usermodel.XSSFPicture;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jfree.chart.*;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.GroupedStackedBarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.GradientPaintTransformType;
import org.jfree.ui.StandardGradientPaintTransformer;

import java.awt.*;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class StackedBarChartDemo42 {

    public StackedBarChartDemo42() throws IOException {

    }


    private JFreeChart createChart(String title, CategoryDataset dataset) {

        final JFreeChart chart = ChartFactory.createStackedBarChart(
                title,          // chart title 大標題
                "",           // domain axis label
                "",             // range axis label 縱軸數值欄位名稱
                dataset,                     // data
                PlotOrientation.VERTICAL,    // the plot orientation
                true,                 // legend
                true,                // tooltips
                false                   // urls
        );

        GroupedStackedBarRenderer renderer = new GroupedStackedBarRenderer();

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

        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        plot.setRenderer(renderer);
        plot.setFixedLegendItems(createLegendItems());
        return chart;

    }

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

    public static void main(final String[] args) throws IOException {

        final sideProjectTest.barChart.StackedBarChartDemo42 demo =
                new sideProjectTest.barChart.StackedBarChartDemo42();

        final CategoryDataset dataset = demo.createDataset();
        final CategoryDataset dataset2 = demo.createDataset2();
        final JFreeChart chart = demo.createChart("血壓量測人數", dataset);
        final JFreeChart chart2 = demo.createChart("註冊人數", dataset2);
        int width = 120 * 2 ;    /* Width of the image */
        int height = 540;   /* Height of the image */
//        File BarChart =  new File( "BarChart2.jpeg" );
        ByteArrayOutputStream stackedbarChartOP = new ByteArrayOutputStream();
        ByteArrayOutputStream barChartOP = new ByteArrayOutputStream();

        ChartUtilities.writeChartAsPNG(stackedbarChartOP, chart, width, height);
        ChartUtilities.writeChartAsPNG(barChartOP, chart2, width, height);

        Workbook wb = new XSSFWorkbook();

        Sheet sheet = wb.createSheet("Sheet1");
        Sheet stackedbarChartSheet = wb.createSheet("stackedbarchart");
        Sheet barSheetSheet = wb.createSheet("barchart");

        ClientAnchor stackedbarChartAnchor = new XSSFClientAnchor();

        stackedbarChartAnchor.setCol1(0);
        stackedbarChartAnchor.setRow1(0);

        stackedbarChartOP.close();
        barChartOP.close();

        int stackedbarChartId = wb.addPicture(stackedbarChartOP.toByteArray(), Workbook.PICTURE_TYPE_PNG);
        XSSFDrawing drawing = (XSSFDrawing) stackedbarChartSheet.createDrawingPatriarch();
        XSSFPicture xsfp = drawing.createPicture(stackedbarChartAnchor, stackedbarChartId);
        xsfp.resize();

        int barChartId = wb.addPicture(barChartOP.toByteArray(), Workbook.PICTURE_TYPE_PNG);
        XSSFDrawing bardrawing = (XSSFDrawing) barSheetSheet.createDrawingPatriarch();
        XSSFPicture barxsfp = bardrawing.createPicture(stackedbarChartAnchor, barChartId);
        barxsfp.resize();

        FileOutputStream fileOut = new FileOutputStream("ChartExcel.xlsx");

        wb.write(fileOut);
        wb.close();
    }




    private CategoryDataset createDataset() {
        DefaultCategoryDataset result = new DefaultCategoryDataset();

        result.addValue(25, "xxx", "卑南鄉");
        result.addValue(20.4, "aaa", "卑南鄉");
        result.addValue(20.5, "yyyy", "卑南鄉");
        result.addValue(100.2, "", "卑南鄉");

        result.addValue(23.3, "xxx", "台東市");
        result.addValue(12.7, "aaa", "台東市");
        result.addValue(15.4, "yyyy", "台東市");
        result.addValue(23.8, "", "台東市");

        return result;
    }

    private CategoryDataset createDataset2() {
        DefaultCategoryDataset result = new DefaultCategoryDataset();

        result.addValue(25, "用戶註冊人數", "卑南鄉");
//        result.addValue(20, "用戶註冊人數", "卑南鄉");
//        result.addValue(20, "用戶註冊人數", "卑南鄉");
//        result.addValue(5, "用戶註冊人數", "卑南鄉");

        result.addValue(2, "用戶註冊人數", "台東市");
//        result.addValue(12, "用戶註冊人數", "台東市");
//        result.addValue(15, "用戶註冊人數", "台東市");
//        result.addValue(23, "用戶註冊人數", "台東市");

        return result;
    }



}

