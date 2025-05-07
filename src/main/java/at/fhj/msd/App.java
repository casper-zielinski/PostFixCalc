package at.fhj.msd;

import java.util.ArrayList;
import java.util.List;

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
        List<String> tests = new ArrayList<>(List.of(
            "3 + 4",
            "7 - 5",
            "10 / 2",
            "5 + 6 * 2",
            "8 / 4 - 3",
            "2 + 3 * 4 - 6",
            "( 2 + 3 ) * ( 4 - 5 )",
            "( 8 + 2 ) * ( 3 - 1 ) / ( 5 + 1 )",
            "( 4 + 5 ) * ( 6 - 2 ) / ( 3 + 1 ) + 7",
            "8 + ( 4 * 3 ) - ( 2 + 6 ) / 4",
            "( 5 + 3 ) * ( 4 - 2 ) + ( 6 / 3 ) * ( 8 - 5 )",
            "( 3 + 2 * 5 ) * ( 8 - 4 / 2 ) + ( 7 - 3 ) * ( 4 + 6 )",
            "( 2 + 3 * ( 4 + 5 ) ) - ( 6 + 2 ) * ( 3 + 7 )"
        ));
        
        for (String test : tests) {
            String postfix = calcConvert2.convertInfixToPostfix(test);
            System.out.println(postfix);
        }
       
       
    }
}
