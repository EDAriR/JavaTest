package sideProjectTest;

import javax.xml.bind.DatatypeConverter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DataFormat {

    public static void main(String[] args) {

        String isoTime = "2012-09-26T16:00:00Z";

        Date parseTime = DatatypeConverter.parseDate(isoTime).getTime();

        System.out.println("isoTime : " + isoTime);

        System.out.println("parseTime : " + parseTime);

        Calendar c = Calendar.getInstance();
        c.setTime(parseTime);
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        System.out.println("======================================");
        c.setTimeZone(TimeZone.getTimeZone("UTC"));
        System.out.println("getTimeZone " + c.getTimeZone());
        System.out.println("getTimeInMillis " + c.getTimeInMillis());
        System.out.println("HOUR_OF_DAY " + c.get(Calendar.HOUR_OF_DAY));
        System.out.println("getTime " + c.getTime());
        System.out.println("======================================");
        c.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        System.out.println("getTimeZone +8 " + c.getTimeZone());
        System.out.println("getTimeInMillis +8 " + c.getTimeInMillis());
        System.out.println("HOUR_OF_DAY +8 " + c.get(Calendar.HOUR_OF_DAY));
        System.out.println("getTime +8 " + c.getTime());

        c.add(Calendar.HOUR, 30);
        System.out.println(c.getTime());

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH'\\':mm'\\':ss.SSSX");
        System.out.println(df.format(c.getTime()).toString());
        System.out.println(df.format(new Date()));

    }
}
