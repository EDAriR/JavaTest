package scjpJava5.ch6;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Writer2 {

    public static void main(String[] args) {
        char[] in = new char[50];

        int size = 0;


        try {
            File file = new File("fileWrite2.txt");

            FileWriter fw = new FileWriter(file);


            fw.write("howdy\nfolks\n");
            fw.flush();
            fw.close();

            FileReader fr = new FileReader(file);
            size = fr.read(in);

            System.out.println(size + " ");

            for (char c:in){
                System.out.println(c);
            }

            fr.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
