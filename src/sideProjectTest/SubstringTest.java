package sideProjectTest;

import org.springframework.util.StringUtils;

public class SubstringTest {

    public static void main(String[] args) {

//        String ss = "A123456789";
//
//        String sss = ss.substring(0, 4) + "******";
//
//        System.out.println(sss);

        String prework = "2611";


        String result = "";
        if (!StringUtils.isEmpty(prework)) {
            try {

                System.out.println("prework ==>"+ prework);
                int part = 0;
                if (part == 0) {
                    result = prework.substring(0, 2);
                } else {
                    result = prework.substring(2, 4);
                }
            } catch (Exception e) {
            }
        }

        System.out.println(result);
    }
}
