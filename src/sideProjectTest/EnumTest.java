package sideProjectTest;

public class EnumTest {

    public static void main(String[] args) {


        String ee = "YES";

        System.out.println(TEST.YES.YES);
        System.out.println(TEST.NO.name());

        System.out.println(TEST.YES.equals(ee));
        System.out.println(ee.equals(TEST.YES));

        TEST c = TEST.YES;
        System.out.println(c == TEST.YES);

        System.out.println(TEST.values());

        for (TEST t:TEST.values()) {
            System.out.println(t.name());
        }

        System.out.println(TEST.valueOf("NO"));
        System.out.println(TEST.valueOf("N"));


    }
}
