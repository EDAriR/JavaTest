package sideProjectTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Test4 {


    Model m = new Model();

    public static void main(String[] args) {


        Model m = new Model();
        m.setId("aa");
        m.setSequence(666);
        m.setDate(new Date());

        List<Model> ml = new ArrayList<>();
        ml.add(m);
        ml.add(m);
        ml.add(m);
        ml.add(m);
        List<TO> tl = ml.stream()
                .map(t -> t.convert())
                .collect(Collectors.toList());

        int i = 0;

        for (TO tt:tl) {
            System.out.println(tt.getSequence() + " _" + ++i );
            System.out.println(tt.getDate() + " _" + i);
        }
    }
}
