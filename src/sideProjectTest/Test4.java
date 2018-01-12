package sideProjectTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Test4 {


    Model m = new Model();

    public static void main(String[] args) {


        Model m = new Model();
        m.setId("aa");
        m.setSequence(666);
        m.setDate(new Date());

        TO t = m.convert();

        System.out.println(t.getSequence());
        System.out.println(t.getDate());
    }
}
