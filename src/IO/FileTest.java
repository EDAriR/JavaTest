package IO;

import java.io.File;

public class FileTest {

    public static void main(String[] args) {


        String path = "/Users/ed/EDPython/udemy-dl/react-redux/01 Lets Dive In/012 Displaying Content with Functional Components.mp4";
        File file = new File(path);

        System.out.println(file.exists());
        System.out.println(file.length() / 1024 / 1024);
        System.out.println(file.length());
        System.out.println(file.getName());
    }
}
