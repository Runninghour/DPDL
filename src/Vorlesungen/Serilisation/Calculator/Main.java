package Vorlesungen.Serilisation.Calculator;

import java.util.ArrayList;
import java.util.*;

public class Main {


    public static void main(String[] s) {
        double a = 3.0;
        double b = 2.0;
        String o = "+";
        double r = 0.0;
        Calculator c1 = new Calculator.ArithmeticCalculator();
        Calculator c2 = new Calculator.SquareCalculator();
        List<Calculator> l = new ArrayList<Calculator>();
        l.add(c1);
        l.add(c2);
        int j = 0;
        Calculator c = null;
        while (true) {
            if (j >= l.size()) {
                break;
            }
            c = l.get(j);
            r = c.calculate(a, b, o);
            System.out.println("The result of calculator number: " + j + " is: " + r);
            j++;
        }
    }


}

abstract class Calculator {


    public  double calculate(double a, double b, String c){
        return 0.0;
    }


    public static class ArithmeticCalculator extends Calculator {
        @Override
        public double calculate(double a, double b, String c) {
            double s = 0;

            if (Objects.equals(c, "+")) {
                s = a + b;
            } else if (Objects.equals(c, "-")) {
                s = a - b;
            } else if (Objects.equals(c, "*")) {
                s = a * b;
            } else if (Objects.equals(c, "/")) {
                s = a / b;
            }


            return s;
        }
    }

    public static class SquareCalculator extends Calculator {
        @Override
        public double calculate(double a, double b, String c) {
            double s = 0;
            s = Math.pow(a, b);


            return s;
        }
    }
}