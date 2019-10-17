package sideProjectTest;

import org.apache.poi.ss.usermodel.DateUtil;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import static com.sun.tools.javac.util.Constants.format;

public class LocalDateTest {

    public static void main(String[] args) {

        String date = LocalDateTime
                .from(ZonedDateTime.now(ZoneOffset.UTC))
                .plusDays(-3)//
                .format(DateTimeFormatter.BASIC_ISO_DATE);

        System.out.println(date);


    }
}
