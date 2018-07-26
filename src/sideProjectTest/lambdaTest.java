package sideProjectTest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

public class lambdaTest {

    public static void main(String[] args) {

        List<Integer> al = new ArrayList<Integer>(asList(1, 2, 3, 5, 7));

        List<Integer> a1 = al.stream().filter(i -> i > 2).collect(Collectors.toList());
        List<Integer> a2 = al.stream().filter(i -> i < 2).collect(Collectors.toList());

        System.out.println(al);
        System.out.println(a1);
        System.out.println(a2);
    }
}
