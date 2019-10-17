package sideProjectTest;

import java.util.Arrays;
import java.util.Optional;

public class EnumGetByValue {

    public static void main(String[] args) {

        System.out.println(DocType.getName(3));
    }
}


enum DocType {

    ETC(1), NTC(2);

    private Integer value;

    private DocType(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public static String getName(Integer i){
        Optional<DocType> op =  Arrays.stream(DocType.values())
                .filter(c -> c.getValue().equals(i))
                .findFirst();

        if(op.isPresent()){
            return op.get().name();
        }else {
            return "";
        }

    }
}