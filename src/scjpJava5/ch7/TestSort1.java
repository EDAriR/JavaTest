package scjpJava5.ch7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestSort1 {

    public static void main(String[] args) {

        List<String> stuff = new ArrayList();

        stuff.add("Denver");
        stuff.add("Boulder");
        stuff.add("Vail");
        stuff.add("Aspen");
        stuff.add("Telluride");

        System.out.println("unsorted " + stuff);

        Collections.sort(stuff);

        System.out.println("sorted " + stuff);
    }
}
