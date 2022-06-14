package Vorlesungen.Serilisation;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Deserialisierung {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        FileInputStream fs = new FileInputStream("src/Serialization/test1.ser");
        ObjectInputStream is = new ObjectInputStream(fs);
        Time time = (Time) is.readObject();
        System.out.println(time.toString());
        System.out.println("" + is.readInt());
        System.out.println((String) is.readObject());
        Time t = (Time) is.readObject();
        System.out.println(t.toString());
        is.close();
    }

}
