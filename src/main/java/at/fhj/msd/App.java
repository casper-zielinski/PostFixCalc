package at.fhj.msd;

import java.util.ArrayList;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        PostFixCalculator calculator = new PostFixCalculator("2 7 * 3 4 + / 3 4 * /");
        double result = calculator.calculate();
        System.out.println("Result: " + result); // Output: Result: 2.0
        

            }
        }
