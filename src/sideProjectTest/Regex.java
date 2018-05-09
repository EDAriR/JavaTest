package sideProjectTest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {

    public static void main(String[] args) {

        String s = "City: [name:NYK][distance:1100] [name:CLT][distance:2300] [name:KTY][distance:3540] Price:";

        String regex = "\\[name:([A-Z]+)\\]\\[distance:(\\d+)\\]";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s);


        StringBuilder result = new StringBuilder();
        while (matcher.find()) {

            System.out.println(matcher.group(1));
            System.out.println(matcher.group(2));
            result.append("[");
            result.append(matcher.group(1));
            result.append(":");
            result.append(matcher.group(2));
            result.append("]");
        }

        System.out.println(result.toString());
    }
}
