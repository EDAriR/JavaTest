package scjpJava5.ch6;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexSmall {

    public static void main(String[] args) {

        Pattern p = Pattern.compile("ab");

        Matcher m = p.matcher("abaaaba");

        boolean b = false;

        while(b = m.find())
            System.out.print(m.start() + " ");


        System.out.println("\nString : abababa Pattern : aba");

        Pattern p1 = Pattern.compile("aba");

        Matcher m1 = p1.matcher("abababa");

        boolean b1 = false;

        while(b1 = m1.find())
            System.out.print(m1.start() + " ");

        System.out.println("\nStrnig : a12c3e456f Pattern : \\d");

        Pattern p2 = Pattern.compile("\\d");

        Matcher m2 = p2.matcher("a12c3e456f");

        boolean b2 = false;

        while(b2 = m2.find())
            System.out.print(m2.start() + " ");


        System.out.println("\nString : a 1 56 _Z  Pattern : \\w");
        Pattern p3 = Pattern.compile("\\w");

        Matcher m3 = p3.matcher("a 1 56 _Z");

        boolean b3 = false;

        while(b3 = m3.find())
            System.out.print(m3.start() + " ");


        System.out.println("\nString : cafeBABE Pattern : [a-cA-C]");

        Pattern p4 = Pattern.compile("[a-cA-C]");

        Matcher m4 = p4.matcher("cafeBABE");

        boolean b4 = false;

        while(b4 = m4.find())
            System.out.print(m4.start() + " ");
    }
}
