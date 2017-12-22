package scjpJava5.ch8;

public class Popcorn {

    public void pop(){
        System.out.println("popcorn");
    }
}

class Food{

    Popcorn p = new Popcorn();
    public  void pop(){
        System.out.println("anonymous popcorn");
    }
}
