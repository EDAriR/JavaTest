package scjpJava5.ch7;

import java.util.HashMap;
import java.util.Map;

public class MapEq {

    public static void main(String[] args) {

        Map<ToDos, String > m = new HashMap<ToDos, String>();

        ToDos t1 = new ToDos("Monday");
        ToDos t2 = new ToDos("Monday");
        ToDos t3 = new ToDos("Tuesday");

        m.put(t1, "doLaundry");
        m.put(t2, "222");
        m.put(t3, "xxx");

        System.out.println(m.size());

    }

}

class ToDos{

    String day;

    ToDos(String d){
        day = d;
    }

    @Override
    public boolean equals(Object obj) {

        System.out.println(obj);
        System.out.println("this.day  == " + this.day);
        return ((ToDos)obj).day == this.day;
    }

    @Override
    public int hashCode() {
        return 9;
    }
}
