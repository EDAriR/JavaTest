package scjpJava5.ch2;

class Top {
    public Top(String s ){
        System.out.println("B");
    }
}

class Bottom2 extends Top{

    public Bottom2(String s) {
        super("");
        System.out.println("D");
    }

    public static void main(String[] args) {
        new Bottom2("2");

    }
}