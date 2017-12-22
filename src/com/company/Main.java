package com.company;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static java.lang.System.out;

public class Main {

    public static void main(String[] args) {

        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        SimpleDateFormat monthsdf = new SimpleDateFormat("yyyy-MM");
        String[] dateArray = sdf.format(date).split(" ");
        out.println("Date :  " + dateArray[0]);
//

        Calendar cal = Calendar.getInstance();
        out.println("1 : " + cal.getTime());
        cal.add(Calendar.MONTH,-1);
        out.println("2 : "+cal.getTime());
        cal.set(Calendar.DATE, cal.getActualMinimum(Calendar.DATE));
        Date start = cal.getTime();
        cal.set(Calendar.DATE, cal.getActualMaximum(Calendar.DATE));
        Date end = cal.getTime();
        out.println("3 : "+ start);
        out.println("4 : "+ end);
        out.println(monthsdf.format(cal.getTime()));
        out.println("start : "  + start + "  end : " + end);
//
//        out.println(LocalDateTime.now().plusMonths(2));

//        int i = Integer.parseInt("-123");
//
//        out.println(i);

    }
}
