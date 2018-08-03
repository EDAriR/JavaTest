package sideProjectTest;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DataFormat2 {

    public static void main(String[] args) {

        Date date = new Date();

        System.out.println(date);

        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        String str = format.format(date);

        System.out.println(str);

    }


}
