package sideProjectTest;

public class EnumTest {

    public static void main(String[] args) {


        String ee = "YES";

        System.out.println(TEST.YES.equals(ee));
        System.out.println(ee.equals(TEST.YES));

        TEST c = TEST.YES;
        System.out.println(c == TEST.YES);

    }
}
