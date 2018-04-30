package sideProjectTest;

import java.math.BigDecimal;

public class BigDecimal_1 {

    public static void main(String[] args) {

        long a1 = 444;
        long a2 = 1000;
        long intresult;
        String strresult;

        BigDecimal b1 = new BigDecimal(a1);
        BigDecimal b2 = new BigDecimal(a2);
        BigDecimal b3 = new BigDecimal(100);

        b1.divide(b2, 3 , BigDecimal.ROUND_UP);

        // multiply 成
        long a3 = b1.multiply(b2).divide(b3,0,BigDecimal.ROUND_UP).toBigInteger().longValue();
        System.out.println(a3);
        //將 BigDecimal 轉成 int
        intresult = ((b1.divide(b2,3,BigDecimal.ROUND_UP)).toBigInteger()).longValue();

        //將 BigDecimal 轉成 String
        strresult = (b1.divide(b2,2,BigDecimal.ROUND_UP).multiply(new BigDecimal(100))).toString();

        double a = b1.divide(b2, 2, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100)).doubleValue();
        System.out.println( a1 + "÷" + a2 + " 無條件進位 " + intresult );

        //將 int 轉成 String
        System.out.println( String.valueOf(a1) + "÷" + String.valueOf(a2)
                + " 無條件進位 " + strresult );

        System.out.println(a);

        System.out.println(Double.valueOf(a1)/Double.valueOf(a2));

    }
}
