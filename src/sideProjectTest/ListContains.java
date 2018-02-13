package sideProjectTest;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public class ListContains {

    public static void main(String[] args) {

        List<Integer> a = new ArrayList<Integer>(asList(1, 2, 3, 5, 7));
        List<Integer> b = new ArrayList<Integer>(asList(1, 2, 3, 4, 5));

        List<Integer> bc = new ArrayList();
        for(Integer aa:a){

            if(b.contains(aa)){
                bc.add(aa);
            }
        }

        System.out.println(bc);

        a.addAll(b);
        System.out.println(a);

    }
}
