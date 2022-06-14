package Vorlesungen.Serilisation.FileManipulation2;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        FileOutputStream outputStream;
        int lineCount = 0;

        try {

            while (true) {
                System.out.print("Enter output file: ");
                try {
                    outputStream = new FileOutputStream(bufferedReader.readLine());
                    break;
                } catch (SecurityException ex)
                // FileOutputStream throws SecurityExceptions
                {
                    System.out.println(ex.getMessage());
                }
            }


            while (lineCount < 1) {
                try {
                    System.out.print("Enter number of lines to append to file: ");
                    lineCount = Integer.parseInt(bufferedReader.readLine());
                    break;
                } catch (NumberFormatException ex)
                // Integer.ParseInt throws NumberFormatExceptions
                {
                    System.out.println(ex.getMessage());
                }
            }

            System.out.println("Enter the lines you wish to write:");

            for (int k = 0; k < lineCount; k++) {
                String line = bufferedReader.readLine();
                outputStream.write(line.getBytes());
                outputStream.write('\n');
            }

            //for (int k = 0; k < lineCount; k++)
            //    outputStream.write(bufferedReader.readLine().getBytes());


            bufferedReader.close();
            outputStream.close();
        }
        catch (IOException ex)
        // BufferedReader throws IOExceptions
        {
            System.out.println(ex.getMessage());
        }
    }
}
