package sideProjectTest;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {
    public static void main(String[] args) {


        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        Date d = new Date();
        System.out.println(d);
        System.out.println(sdf.format(d));
    }
}
