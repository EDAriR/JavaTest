package scjpJava5.ch4;

public class OperatorsExampleExame2 {

    OperatorsExampleExame2(){}

    OperatorsExampleExame2(int i, int x){

    }

    int gcd(int i, int x){

        System.out.println("gcd i = " + i + ", x = " + x);

        if(x == 0) {
            System.out.println("x == 0, x = " + x + " , i = " + i);
            return i;
        }
        else{
            System.out.println("x != 0, x = " + x + " , i = " + i);
            return gcd(x, i%x);
        }

    }

    public static void main(String[] args) {

        OperatorsExampleExame2 gcd = new OperatorsExampleExame2();

        System.out.println(gcd.gcd(77, 43));

    }
}