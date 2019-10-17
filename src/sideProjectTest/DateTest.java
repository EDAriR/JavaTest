package sideProjectTest;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTest {
    public static void main(String[] args) {


        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        Date d = new Date();
        System.out.println(d);
        System.out.println(sdf.format(d));


        Calendar cal = Calendar.getInstance();
        //Displaying current date in the desired format
        System.out.println("Current Date: "+sdf.format(cal.getTime()));

        //Number of Days to add
        cal.add(Calendar.DAY_OF_MONTH, 30);

        System.out.print(cal.getTime());
    }
}
