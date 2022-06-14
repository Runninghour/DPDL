package Übungsklausuren.OutputFormatting;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        String vorname = "Theo";
        String nachname = "Heyde";

        System.out.printf(vorname + " " + nachname);
        System.out.printf("\n" + "\n");

        for (int i = 0; i < 16; i++) {

            System.out.printf(i + "'%S' %n", Integer.toHexString(i));
        }
        printName(vorname,nachname,"Leipzig",19.002);
    }

    static private void printName(String vorname, String nachname, String stadt, double alter) {

        System.out.printf("'%-5s' %n", vorname);
        System.out.printf("'%-5s' %n", nachname);
        System.out.printf("'%5.3S' %n",stadt);
        System.out.printf("'%06.2f'%n",alter);
    }
}
