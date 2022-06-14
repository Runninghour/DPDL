package Übungsklausuren.test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Main {
    public static void main(String[] args) {
        File ordner = new File("bla/suelz/testdir");
        ordner.mkdirs();

        String timeStamp = new SimpleDateFormat("dd.MM.yyyy").format(Calendar.getInstance().getTime());
        System.out.println(timeStamp);




        if(ordner.isDirectory()) {
            System.out.println("Ordner ist da");

            File unsereDatei = new File("bla/suelz/testdir/unsereDatei.txt");
            try {
                unsereDatei.createNewFile();
                File neuerName = new File("bla/suelz/testdir/neuerName.txt");
                unsereDatei.renameTo(neuerName);
                FileWriter writer = new FileWriter(unsereDatei);
                writer.write(timeStamp);
                writer.close();
            } catch (IOException e) {
                System.out.println("Fehler: Datei nicht angelegt.");
                //e.printStackTrace();
            }
        } else {
            System.out.println("Oberordner ist nicht da.");
        }
    }
}
