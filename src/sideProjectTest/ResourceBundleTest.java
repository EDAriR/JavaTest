package sideProjectTest;

import java.util.ResourceBundle;

public class ResourceBundleTest {

    public static void main(String[] args) {

//      native2ascii -encoding UTF-8 amount_report.properties amount_report_zh_tw.properties

        ResourceBundle res = ResourceBundle.getBundle("properties.language2_zh_tw");
        System.out.print(res.getString("under_old_abnormal_bloodpressure_rate") + "!");
        System.out.println(res.getString("over_old_abnormal_bloodpressure_number") + "!");

    }
}
