package sideProjectTest;

import java.util.HashMap;
import java.util.Map;

public class MapGetNull {

    public static void main(String[] args) {

        Map<String, String > map = new HashMap<>();
        System.out.println(map.get("aa"));
    }
}
