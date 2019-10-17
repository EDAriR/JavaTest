public class AextendsB {



    public static void main(String[] args) {

        A a = new A();

        a.setAaa("aaa");

        B b = (B) a;

        System.out.print(a.getAaa());

    }
}

class A{

    private String aaa;

    public String getAaa() {
        return aaa;
    }

    public void setAaa(String aaa) {
        this.aaa = aaa;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}


class B extends A{


}
