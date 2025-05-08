package at.fhj.msd;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) {

        PostFixCalculator calc = new PostFixCalculator();

        System.out.println("=====================================");
        System.out.println("          POSTFIX CALCULATIONS");
        System.out.println("=====================================");
        System.out.println();

        List<String> postfixExpressions = List.of(
                "3 4 +",
                "8 5 -",
                "6 2 *",
                "10 2 /",
                "3 4 + 2 *",
                "9 3 / 5 -",
                "2 3 4 + *",
                "10 5 / 3 +",
                "5 1 2 + 4 * + 3 -",
                "7 3 5 * + 2 /",
                "15 3 / 4 2 * + 6 1 - * 3 3 * 2 + - 5 +",
                "8 4 / 2 5 * + 3 1 - * 10 2 / 4 + - 6 *",
                "6 2 / 3 4 * + 5 1 - 2 / * 9 3 + 2 * - 4 +",
                "9 3 / 4 5 * + 2 1 - * 6 3 / 8 + - 7 *",
                "10 2 * 3 4 + - 5 1 + 2 / * 8 4 / 2 * + 6 -"
        );

        for (String test : postfixExpressions) {
            System.out.println("Expression: " + test);
            String result = calc.calculatePostFix(test);
            System.out.println("Result  : " + result);
            System.out.println("-------------------------------------");
        }

        try {
            String result = calc.calculatePostFix("5 0 /");
            System.out.println("Expression: 5 0 /");
            System.out.println("Result  : " + result);
        } catch (ArithmeticException e) {
            System.out.println("Expression: 5 0 /");
            System.out.println("Error    : " + e.getMessage());
        }

        System.out.println();
        System.out.println("=====================================");
        System.out.println("      CONVERSION --> POSTFIX TO INFIX");
        System.out.println("=====================================");

        try {
            PostFixCalculator calcString = new PostFixCalculator();
            String infix = calcString.convertPostfixToInfix("10 2 * 3 4 + - 5 1 + 2 / * 8 4 / 2 * + 6 -");
            System.out.println("Postfix Expression: 10 2 * 3 4 + - 5 1 + 2 / * 8 4 / 2 * + 6 -");
            System.out.println("Infix Expression  : " + infix);
        } catch (ArithmeticException e) {
            System.out.println("Error    : " + e.getMessage());
        }

        System.out.println();
        System.out.println("=====================================");
        System.out.println("      CONVERSION --> INFIX TO POSTFIX");
        System.out.println("=====================================");

        PostFixCalculator calcConvert2 = new PostFixCalculator();
        List<String> tests = new ArrayList<>(List.of(
                "3+4",
                "7-5",
                "10/2",
                "5+6*2",
                "8/4-3",
                "2+3*4-6",
                "(2+3)*(4-5)",
                "(8+2)*(3-1)/(5+1)",
                "(4+5)*(6-2)/(3+1)+7",
                "8+(4*3)-(2+6)/4",
                "(5+3)*(4-2)+(6/3)*(8-5)",
                "(3+2*5)*(8-4/2)+(7-3)*(4+6)",
                "(2+3*(4+5))-(6+2)*(3+7)"
        ));

        for (String test : tests) {
            System.out.println("Infix Expression  : " + test);
            String postfix = calcConvert2.convertInfixToPostfix(test);
            System.out.println("Postfix Expression: " + postfix);
            System.out.println("-------------------------------------");
        }

        try {
            String infix = calcConvert2.convertInfixToPostfix("( 5 + 3 ) / ( 2 - 2 )");
            System.out.println("Infix Expression  : ( 5 + 3 ) / ( 2 - 2 )");
            System.out.println("Postfix Expression: " + infix);
        } catch (ArithmeticException e) {
            System.out.println("Expression: ( 5 + 3 ) / ( 2 - 2 )");
            System.out.println("Error    : " + e.getMessage());
        }

    }
}
