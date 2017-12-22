package scjpJava5.ch6;

import java.util.Scanner;

public class ScanNext {

    public static void main(String[] args) {

        boolean b2, b;

        int i;

        String s, hits = " ";

//        Scanner s1 = new Scanner("1 true 34 hi");
//        Scanner s2 = new Scanner("1 true 34 hi");
        Scanner s1 = new Scanner(args[0]);
        Scanner s2 = new Scanner(args[0]);

        for (String arg:args) {
            System.out.println("arg =>" + arg);
        }

        while (b = s1.hasNext()){
            s = s1.next();
            System.out.println("s : " + s);
            hits += "s";
        }

        while (b = s2.hasNext()){
            if(s2.hasNextInt()){
                i = s2.nextInt();
                hits += "i";
            }else if(s2.hasNextBoolean()){
                b2 = s2.nextBoolean();
                hits += "b";

            }else {
                s2.next();
                hits += "s2";
            }
        }

        System.out.println("hits "  + hits);

    }
}
