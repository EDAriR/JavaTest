package com.company;

import java.util.*;

public class mapTest {
    public static void main(String[] args) {

        Map map = new LinkedHashMap<>();
        map.put("index:1","error:'1xxx'");
        map.put("index:2","error:'2xxx'");
        map.put("index:3","error:'3xxx'");
        map.put("index:4","error:'4xxx'");
//        System.out.println(map);

        StringBuffer sb = new StringBuffer();

        List<String> errorSB = new ArrayList<String>();

        String errorString = "{\"index\":" +  ", \"error\" : \'" + "e.getMessage()" + "\'}";
        errorSB.add(errorString);


            sb.append("{\"importResult\":");
            sb.append(errorSB.toString());
            sb.append("}");
        System.out.println(sb.toString());

    }
}
