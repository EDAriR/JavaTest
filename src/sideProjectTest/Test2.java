package sideProjectTest;

import java.math.BigDecimal;

public class Test2 {

    public static void main(String[] args) {

        long a1 = 82;
        long a2 = 3;
        long intresult;
        String strresult;

        BigDecimal b1 = new BigDecimal(a1);
        BigDecimal b2 = new BigDecimal(a2);
        BigDecimal b3 = new BigDecimal(100);

        b1.divide(b2);

        // multiply 成
        long a3 = b1.multiply(b2).divide(b3,0,BigDecimal.ROUND_UP).toBigInteger().longValue();
        System.out.println(a3);
        //將 BigDecimal 轉成 int
        intresult = ((b1.divide(b2,0,BigDecimal.ROUND_UP)).toBigInteger()).longValue();

        //將 BigDecimal 轉成 String
        strresult = (b1.divide(b2,0,BigDecimal.ROUND_UP)).toString();

        System.out.println( a1 + "÷" + a2 + " 無條件進位 " + intresult );

        //將 int 轉成 String
        System.out.println( String.valueOf(a1) + "÷" + String.valueOf(a2)
                + " 無條件進位 " + String.valueOf(intresult) );

    }
}
