package Übungsklausuren.Charstream;

import java.io.*;

public class Main {


    public static void main(String[] args) throws IOException {

//        test();
        FileReader FR = null;
        FileWriter FW = null;
        PrintWriter PW = null;
        BufferedReader BR = null;
        try {
            File input = new File("input.html");
            FR = new FileReader(input);

            File output = new File("output.html");
            FW = new FileWriter(output);

            BR = new BufferedReader(FR);
            PW = new PrintWriter(FW);

            String content = "";
            while (  (content=BR.readLine()) != null) {

              //  content = BR.readLine();
               content = content.replaceAll("ä", "&auml;");
                content = content.replaceAll("Ä", "&Auml;");
                content = content.replaceAll("ö", "&ouml;");
                content = content.replaceAll("Ö", "&Ouml;");
                content = content.replaceAll("ü", "&uuml;");
                content = content.replaceAll("Ü", "&Uuml;");
                content = content.replaceAll("ß", "&szlig;");
                content = content.replaceAll("\"", "&quot;");

                PW.println(content);
            }
            BR.close();
            FR.close();
            FW.close();
            PW.close();

        } catch (IOException e) {
            BR.close();
            FR.close();
            FW.close();
            PW.close();
            System.err.println("Datei fehlt!:");
            e.printStackTrace();
        }


    }

    public static void test() throws IOException {


        FileReader FR = null;
        FileWriter FW = null;
        BufferedReader BuR = null;
        PrintWriter PW = null;


        try {
            File input = new File("input.html");
            File output = new File("output.html");

            FR = new FileReader(input);
            FW = new FileWriter(output);

            BuR = new BufferedReader(FR);
            PW = new PrintWriter(FW);
            String content = "";
            while (BuR.read() != -1) {

                content = BuR.readLine();

                content = content.replaceAll("ü", "&uuml;");
                content = content.replaceAll("Ü", "&Uuml;");
                content = content.replaceAll("Ä", "&Auml;");
                content = content.replaceAll("ä", "&auml;");
                content = content.replaceAll("ö", "&ouml;");
                content = content.replaceAll("Ö", "&uuml;");
                content = content.replaceAll("ß", "&szlig;");
                content = content.replaceAll("\"", "&quot;");

                PW.println(content);

            }
            FR.close();
            FW.close();
            BuR.close();
            PW.close();
            System.out.println("Läuft!");
        } catch (IOException e) {
            FR.close();
            FW.close();
            BuR.close();
            PW.close();
            System.err.println("File missing!");
        }
    }

}
