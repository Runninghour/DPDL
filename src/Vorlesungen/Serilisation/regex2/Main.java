package Vorlesungen.Serilisation.regex2;

import java.io.*;
import java.util.Arrays;

public class Main {

    static int indextemp;
    static int indexhumidity;

    public static void main(String[] args) throws IOException {
        String dateiName = "Text/Input.txt";
        ladeDatei(dateiName);
    }

    private static void ladeDatei(String datName) {


        double tempmontly = 0;
        double humiditymontly = 0;
        int iterations = 0;
        File file = new File(datName);

        if (!file.canRead() || !file.isFile())
            System.exit(0);

        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader(datName));
            String zeile = null;
            while ((zeile = in.readLine()) != null) {

                if (zeile.contains("Stationsindex;Datum;VGSL;VPGB;VPGH;TS05;TS10;TS20;TS50;TS100;ZFUMI;BF10;BF20;BF30;BF40;" +
                        "BF50;BF60;BFGSL;BFGLS;TSLS05;TSSL05;ZTKMI;ZTUMI;VPGPM;VPMB;VPWB;VPZB;VGLS;VWLS;VWSL;BFWLS;BFWSL;eor")) {
                    String[] list = zeile.split(";");
                    for (String element : list) {
                        if (element.contains("TS10")) {
                            indextemp = Arrays.asList(list).indexOf(element);
                        }
                        if (element.contains("BF10")) {
                            indexhumidity = Arrays.asList(list).indexOf(element);
                        }
                    }
                }


                //Berechnung
                iterations++;
                tempmontly += datenAusleseTemp(zeile);
                humiditymontly += datenAusleseHumidity(zeile);

            }
            // Output
            System.out.println("Temperatur " + tempmontly / iterations);
            System.out.println("Feuchtigkeit " + humiditymontly / iterations);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null)
                try {
                    in.close();
                } catch (IOException ignored) {
                }
        }
    }

    private static Double datenAusleseTemp(String zeile) {

        double tempdaily = 0.0;

        //first line has to be ignored
        if (!zeile.contains("Stationsindex;Datum;VGSL;VPGB;VPGH;TS05;TS10;TS20;TS50;TS100;ZFUMI;BF10;BF20;BF30;BF40;" +
                "BF50;BF60;BFGSL;BFGLS;TSLS05;TSSL05;ZTKMI;ZTUMI;VPGPM;VPMB;VPWB;VPZB;VGLS;VWLS;VWSL;BFWLS;BFWSL;eor")) {

            // get the numbers of the temp
            String[] list = zeile.split(";");
            String tempnumber = list[indextemp].strip();

            tempdaily = Double.parseDouble(tempnumber);

        }
        return tempdaily;

    }

    private static Double datenAusleseHumidity(String zeile) {

        double humiditydaily = 0.0;

        if (!zeile.contains("Stationsindex;Datum;VGSL;VPGB;VPGH;TS05;TS10;TS20;TS50;TS100;ZFUMI;BF10;BF20;BF30;BF40;" +
                "BF50;BF60;BFGSL;BFGLS;TSLS05;TSSL05;ZTKMI;ZTUMI;VPGPM;VPMB;VPWB;VPZB;VGLS;VWLS;VWSL;BFWLS;BFWSL;eor")) {
            // get the numbers of the humidity
            String[] list = zeile.split(";");
            String humiditynumber = list[indexhumidity].strip();

            humiditydaily = Double.parseDouble(humiditynumber);
        }
        return humiditydaily;

    }
}
