package sideProjectTest.barChart;

import java.util.Optional;

public class OptionalTest {

    public static void main(String[] args) {

        Optional<String> op  = Optional.empty();

        System.out.println(op.isPresent());

        op = Optional.ofNullable(null);

        System.out.println(op.isPresent());

        op = Optional.of("");

        System.out.println(op.isPresent());
    }
}
