package sideProjectTest;

import com.sun.javafx.collections.MappingChange;

import java.util.HashMap;
import java.util.Map;

public class JsonToClass {


    public static void main(String[] args) {

        String aa = "{\"sequence\":4,\"friendId\":\"firend01\",\"friendName\":\"firend01\",\"createDate\":1516851461751,\"status\":\"WAITTOAGREE\"}";

        Map<String,String> m = new HashMap();

        m.put("seq","4");
        m.put("fid","4d");
        m.put("fname","4n");
        m.put("createdate","4d");
        System.out.println(m);
        System.out.println(aa);

        String[] aaa = aa
                .replace('\"', ' ')
                .replace('{',' ')
                .replace('}',' ')
                .trim()
                .split(",");

        for (String a: aaa) {
            System.out.println(a);

            String[] b = a.split(":");
        }
    }

}
