package sideProjectTest;

import java.math.BigDecimal;

public class BigDecimal_2 {

    public static void main(String[] args) {

        BigDecimal totalBigDecimal = new BigDecimal(15);
        BigDecimal inRangeBigDecimal = new BigDecimal(7);

        double rate = totalBigDecimal
                .divide(inRangeBigDecimal,  BigDecimal.ROUND_UP)
                .toBigInteger().doubleValue();

        System.out.println(rate);
    }
}
