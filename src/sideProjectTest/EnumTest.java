package sideProjectTest;

import javax.persistence.metamodel.EntityType;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class EnumTest {

    public static void main(String[] args) {


        String ee = "YES";

        System.out.println("============");
//        System.out.println(TEST.valueOf(ee).createTest(ee));

        System.out.println("============");
//        System.out.println(TEST.YES.YES);
//        System.out.println(TEST.NO.name());
//
//        System.out.println(TEST.YES.equals(ee));
//        System.out.println(ee.equals(TEST.YES));
//
//        TEST c = TEST.YES;
//        System.out.println(c == TEST.YES);
//
//        System.out.println(TEST.values());
//
//        for (TEST t:TEST.values()) {
//            System.out.println(t.name());
//        }

        System.out.println(lookup.get("1"));
//
//        System.out.println(TEST.valueOf("NO"));
//        System.out.println(TEST.valueOf("N"));


    }

    private static final Map<String , FLAG> lookup =
            Arrays.stream(FLAG.values())
                    .collect(Collectors.toMap(FLAG::getValue, e -> e));

    public enum FLAG{
        YES("Y"),NO("N");

        private String value;

        FLAG(String value){
            this.value = value;
        }

        public String getValue(){
            return this.value;
        }
    }
}
