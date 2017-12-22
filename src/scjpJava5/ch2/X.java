package scjpJava5.ch2;

class X {
    void dog1(){}
}

class Y extends X { void dog2(){}}

class Chrome{
    public static void main(String[] args) {

        X x1 = new X();
        X x2 = new Y();
        Y y1 = new Y();

    }
}