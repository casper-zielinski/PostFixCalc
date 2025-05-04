package at.fhj.msd;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        try {

            PostFixCalculator calc = new PostFixCalculator();
            calc.calculatePostFix("2 3 1 * + 9 - 4 5 * +");
        } catch (Exception e) {
            System.out.println("fehler");
        }

        
            }
        }
