package scjpJava5.ch6.Test15;

import java.io.*;

public class TestSer {

    public static void main(String[] args) {

        SpecialSerial s = new SpecialSerial();
        try{

            ObjectOutputStream os  = new ObjectOutputStream(new FileOutputStream("myFile"));

            os.writeObject(s);
            os.close();
            System.out.print(++ s.z + " ");

            ObjectInputStream is  = new ObjectInputStream(new FileInputStream("myFile"));

            SpecialSerial s2 = (SpecialSerial) is.readObject();
            is.close();

            System.out.print(s2.y + " " + s2.z + " ");

        }catch (Exception e){

            System.out.println("exc");

        }
    }
}

class SpecialSerial implements Serializable{

    transient int y = 7;

    static int z = 9;
}