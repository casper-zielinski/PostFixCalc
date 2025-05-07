package at.fhj.msd;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) {

        PostFixCalculator calc = new PostFixCalculator();
        String result = calc.calculatePostFix("10 2 * 3 4 + - 5 1 + 2 / * 8 4 / 2 * + 6 -");
        System.out.println(result);

        PostFixCalculator calcString = new PostFixCalculator();
        String infix = calc.convertPostfixToInfix("10 5 2 + 3 * - 4 1 + 6 / + 8 2 2 + * - 7 + ");
        System.out.println(infix);

        PostFixCalculator calcConvert2 = new PostFixCalculator();
        String postfix = calcConvert2.convertInfixToPostfix("8 + ( 4 * 3 ) - ( 2 + 6 ) / 4");
        System.out.println(postfix);
    }
}
