package sideProjectTest;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

import java.io.File;

public class chartServiceImp extends ApplicationFrame {


    public chartServiceImp( String applicationTitle , String chartTitle ) {
        super( applicationTitle );
        JFreeChart barChart = ChartFactory.createBarChart(
                chartTitle,
                "Category",
                "Score",
                createDataset(),
                PlotOrientation.VERTICAL,
                true, true, false);

        ChartPanel chartPanel = new ChartPanel( barChart );
        chartPanel.setPreferredSize(new java.awt.Dimension( 560 , 367 ) );
        setContentPane( chartPanel );
    }

    private CategoryDataset createDataset( ) {
        String fiat = "FIAT";
        String audi = "AUDI";
        String ford = "FORD";
        String speed = "Speed";
        String millage = "Millage";
        String userrating = "User Rating";
        String safety = "safety";
        DefaultCategoryDataset dataset =
                new DefaultCategoryDataset( );

        dataset.addValue( 1.0 , fiat , speed );
        dataset.addValue( 3.0 , fiat , userrating );
        dataset.addValue( 5.0 , fiat , millage );
        dataset.addValue( 5.0 , fiat , safety );

        dataset.addValue( 5.0 , audi , speed );
        dataset.addValue( 6.0 , audi , userrating );
        dataset.addValue( 10.0 , audi , millage );
        dataset.addValue( 4.0 , audi , safety );

        dataset.addValue( 4.0 , ford , speed );
        dataset.addValue( 2.0 , ford , userrating );
        dataset.addValue( 3.0 , ford , millage );
        dataset.addValue( 6.0 , ford , safety );

        return dataset;
    }

    public static void main( String[ ] args )throws Exception {
        String fiat = "FIAT";
        String audi = "AUDI";
        String ford = "FORD";
        String speed = "Speed";
        String millage = "Millage";
        final String userrating = "User Rating";
        final String safety = "safety";

        DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
        dataset.addValue( 1.0 , fiat , speed );
        dataset.addValue( 3.0 , fiat , userrating );
        dataset.addValue( 5.0 , fiat , millage );
        dataset.addValue( 5.0 , fiat , safety );

        dataset.addValue( 5.0 , audi , speed );
        dataset.addValue( 6.0 , audi , userrating );
        dataset.addValue( 10.0 , audi , millage );
        dataset.addValue( 4.0 , audi , safety );

        dataset.addValue( 4.0 , ford , speed );
        dataset.addValue( 2.0 , ford , userrating );
        dataset.addValue( 3.0 , ford , millage );
        dataset.addValue( 6.0 , ford , safety );

        JFreeChart barChart = ChartFactory.createBarChart(
                "CAR USAGE STATIStICS",
                "Category", "Score",
                dataset, PlotOrientation.VERTICAL,
                true, true, false);

        int width = 640;    /* Width of the image */
        int height = 480;   /* Height of the image */
        File BarChart = new File( "BarChart.jpeg" );
        ChartUtilities.saveChartAsJPEG( BarChart , barChart , width , height );
//	      ChartUtilities.writeScaledChartAsPNG(arg0, arg1, arg2, arg3, arg4, arg5);
    }

}
