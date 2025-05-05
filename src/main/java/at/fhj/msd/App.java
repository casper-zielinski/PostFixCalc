package at.fhj.msd;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) {

        PostFixCalculator calc = new PostFixCalculator();
        String result = calc.calculatePostFix("10 2 8 * + 3 4 2 * + / 5 2 3 * + -");
        System.out.println(result);

        PostFixCalculator calcConvert2 = new PostFixCalculator();
        String postfix = calcConvert2.convertInfixToPostfix("( ( 7 + 3 ) - ( 2 * 5 ) ) / ( 4 + 1 )");
        System.out.println(postfix);
    }
}
