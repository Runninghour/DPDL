package Vorlesungen.Serilisation;

import java.io.*;

import java.io.FileOutputStream;
import java.io.Serializable;

public class Main {
    public static void main(String[] args) throws IOException {

        FileOutputStream fs = new FileOutputStream("src/Serialization/test1.ser");
        ObjectOutputStream os = new ObjectOutputStream(fs);
        Time time = new Time(10, 20);
        os.writeObject(time);
        os.writeInt(123);
        os.writeObject("Hallo");
        os.writeObject(new Time(11, 25));
        os.close();
    }
}

class Time implements Serializable {
    private int hour;
    private int minute;

    public Time(int hour, int minute) {
        this.hour = hour;
        this.minute = minute;
    }

    public String toString() {
        return hour + ":" + minute;
    }
}
