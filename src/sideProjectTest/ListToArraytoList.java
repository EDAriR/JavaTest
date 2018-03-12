package sideProjectTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;

public class ListToArraytoList {

    public static void main(String[] args) {

        Integer[] a= {1,2,3,4};
        List<Integer> al = new ArrayList<Integer>(asList(1, 2, 3, 5, 7));
        ArrayList<Integer> aa = new ArrayList<Integer>(asList(1,2,3));
        List<Integer> cc = Arrays.asList(a);
        System.out.println(cc);
        System.out.println(al);
        System.out.println(aa);


    }
}
