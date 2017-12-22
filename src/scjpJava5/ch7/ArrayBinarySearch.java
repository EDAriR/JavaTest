package scjpJava5.ch7;

import java.util.Arrays;

public class ArrayBinarySearch {

    public static void main(String[] args) {

        String[] s = {"a", "f", "w", "r", "d"};
        System.out.println(Arrays.binarySearch(s, "d"));
    }
}
