package Vorlesungen.Serilisation.FileManipulation;

import java.io.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {

        try {
            FileReader in = new FileReader("Text/Input.txt");
            FileWriter out = new FileWriter("Output.txt");
            BufferedReader bufferedReader = new BufferedReader(in);

            Stream<String> text = bufferedReader.lines();

            String result = text.filter(str -> str.length() > 1).collect(Collectors.joining());

            out.write(result);
            bufferedReader.close();
            out.close();
        } catch (IOException e) {

            System.err.println("File missing");

        }
    }
}
