package sideProjectTest;

import com.sun.javafx.collections.MappingChange;

import java.util.HashMap;
import java.util.Map;

public class MapTest {

    enum AA{
        A, B, C, D
    }

    public static void main(String[] args) {

        Map<String, Integer> mm = new HashMap<>();
        mm.put("A",1);
        mm.put("B",2);
        mm.put("C",3);

        System.out.println(mm.get(AA.D.toString()));

    }
}
