package at.fhj.msd;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) {

        try {

            PostFixCalculator calc = new PostFixCalculator();
            calc.calculatePostFix("10 2 8 * + 3 4 2 * + / 5 2 3 * + -");
        } catch (Exception e) {
            System.out.println("fehler");
        }

    }
}
