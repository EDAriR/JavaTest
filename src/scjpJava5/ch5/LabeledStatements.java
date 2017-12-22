package scjpJava5.ch5;

import com.sun.org.apache.bcel.internal.generic.GOTO;

public class LabeledStatements {

    public static void main(String[] args) {

        //example 1
        System.out.println("Example 1 ");
        int y = 10;
        foo:
            for(int x = 3; x< 20; x++){
                while (y > 7){
                    y--;
                    System.out.println(y);
                }
            }

        System.out.println("Example 2 : break");
        boolean isTrue = true;
        outer:
            for (int i =0; i < 5; i ++){

                while (isTrue){
                    System.out.println("Hello");
                    break outer;
                }
                System.out.println("Outer loop.");
            }

        System.out.println("Good-Bye");

        System.out.println("");

        System.out.println("Example 3 : continue");

        outer:
        for (int i =0; i < 5; i ++){

            for(int j = 0; j < 5; j++){
                System.out.println("Hello");
                continue outer;
            }
            System.out.println("Outer loop.");
        }
        System.out.println("Good-Bye continue");
    }
}
