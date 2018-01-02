package scjp60;

public class A{

    String name;

    public A(String name){
        this.name = name;
    }

    public void finalize(){
        System.out.println(name + " ");
    }

    public void setA(A a){
        a = null;
    }

}

class  Execute{

    public static void main(String[] args) {

        A a1 = new A("a1");
        A a2 = new A("a2");

        a1 = a2;
        a2.setA(a2);

        System.gc();
    }
}