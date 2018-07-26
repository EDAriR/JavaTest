package sideProjectTest;

import java.util.HashSet;
import java.util.Set;

public class SetTest {

    public static void main(String[] args) {

        Set<String> bs = new HashSet<>();

        System.out.println(bs.add("aa"));
        System.out.println(bs.add("aa"));
        System.out.println(bs.add("ab"));
        System.out.println(bs.add("ac"));

        Set<String> bs2 = new HashSet<>(bs);

        System.out.println(bs2);

    }

}
