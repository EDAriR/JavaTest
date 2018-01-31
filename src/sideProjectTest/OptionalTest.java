package sideProjectTest;

import java.util.Optional;

public class OptionalTest {

    public static void main(String[] args) {
        Optional<Object> op = Optional.ofNullable(null);
        System.out.println(op.orElse('n'));

        Optional<Object> op2 = Optional.of('a');
        System.out.println(op2.isPresent());
    }
}
