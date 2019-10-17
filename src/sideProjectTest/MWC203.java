package sideProjectTest;

public class MWC203 {

    public void m1(){
        System.out.println("A.m1,");
    }

    protected void m2(){
        System.out.println("A.m2,");
    }

    private void m3(){
        System.out.println("A.m3,");
    }

}

class B implements C{

    public static void main(String[] args) {

        MWC203 A = new MWC203();

        A.m1();
        A.m2();
    }

    public void mxx(){
        MWC203 A = new MWC203();
        A.m1();
        A.m2();
    }

    @Override
    public void xxx() {

    }
}

interface C{

   void xxx();

}