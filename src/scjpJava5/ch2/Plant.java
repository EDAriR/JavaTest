package scjpJava5.ch2;

public class Plant {


    String getName(){ return "plant"; }
    Plant getType(){ return this; }
}

class Flower extends Plant{

    Tulip getType(){ return new Tulip();}
}

class Tulip extends Flower{}
