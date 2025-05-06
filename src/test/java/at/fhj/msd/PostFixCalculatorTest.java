package at.fhj.msd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PostFixCalculatorTest {

    PostFixCalculator calc;
    PostFixCalculator calcConvertInfix;

    @BeforeEach
    @DisplayName("PostFix Calculator Setup")
    public void setup() {
        calc = new PostFixCalculator();
        calcConvertInfix = new PostFixCalculator();
    }

    @Test
    @DisplayName("PostFix Constructor Test")
    void constructorTest() {
        assertNotNull(calc);
    }

    @Test
    @DisplayName("PostFix Addition Test")
    void additionTest() {
        assertEquals("25", calc.calculatePostFix("3 4 + 5 + 6 + 7 +"));
    }

    @Test
    @DisplayName("PostFix Substraction Test")
    void substractionTest() {
        assertEquals("6", calc.calculatePostFix("20 2 - 3 - 4 - 5 -"));
    }

    @Test
    @DisplayName("PostFix Multiplication Test")
    void multiplicationTest() {
        assertEquals("48", calc.calculatePostFix("2 2 * 3 * 4 *"));
    }

    @Test
    @DisplayName("PostFix Division Test")
    void divisionTest() {
        assertEquals("5", calc.calculatePostFix("100 2 / 5 / 2 /"));
    }

    @Test
    @DisplayName("PostFix Full Calculation Test")
    void fullCalculationTest() {
        assertEquals("200", calc.calculatePostFix("5 3 + 8 2 - * 4 2 / + 7 3 - *"));
    }

    @Test
    @DisplayName("PostFix IllegalArgument Test")
    void IllegalArgument() {
        assertThrows(IllegalArgumentException.class, () -> {
            calc.calculatePostFix("10 30 =");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            calc.calculatePostFix("5 3 &");
        });
    }

    @Test
    @DisplayName("PostFix InfixToPostfix - IllegalArgument Test")
    void InfixIllegalArgumentTest() {

        assertThrows(IllegalArgumentException.class, () -> {
            calcConvertInfix.convertInfixToPostfix("(1 + 2) * (3 - 4) &&");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            calcConvertInfix.convertInfixToPostfix("..(1 + 2) * (3 - 4)");
        });

    }

    @Test
    @DisplayName("PostFix InfixToPostfix - Addition Test")
    void infixAdditionTest() {
        assertEquals("3 5 + 2 +", calcConvertInfix.convertInfixToPostfix("3 + 5 + 2"));
    }

    @Test
    @DisplayName("PostFix InfixToPostfix - Substraction Test")
    void infixSubstractionTest() {
        assertEquals("8 4 - 2 -", calcConvertInfix.convertInfixToPostfix("8 - 4 - 2"));
    }

    @Test
    @DisplayName("PostFix InfixToPostfix - Multiplication Test")
    void infixMultiplicationTest() {
        assertEquals("2 3 * 4 *", calcConvertInfix.convertInfixToPostfix("2 * 3 * 4"));
    }

    @Test
    @DisplayName("PostFix InfixToPostfix - Division Test")
    void infixDivisionTest() {
        assertEquals("12 4 / 2 /", calcConvertInfix.convertInfixToPostfix("12 / 4 / 2"));
    }

    @Test
    @DisplayName("PostFix InfixToPostfix - Middle Test")
    void infixMiddleTest() {
        assertEquals("3 5 + 2 4 - * 6 +", calcConvertInfix.convertInfixToPostfix("( 3 + 5 ) * ( 2 - 4 ) + 6"));

        assertEquals("8 4 3 * + 2 6 + 4 / -", calcConvertInfix.convertInfixToPostfix("8 + ( 4 * 3 ) - ( 2 + 6 ) / 4"));

        assertEquals("3 5 + 2 4 - * 6 2 / +", calcConvertInfix.convertInfixToPostfix("( 3 + 5 ) * ( 2 - 4 ) + ( 6 / 2 )"));
    }

    @Test
    @DisplayName("PostFix InfixToPostfix - Komplex Test")
    void infixKomplexTest() {

        assertEquals("3 5 + 6 2 - * 4 2 + 7 3 - * / 8 4 / 9 5 - * +", 
                calcConvertInfix.convertInfixToPostfix("( ( 3 + 5 ) * ( 6 - 2 ) ) / ( ( 4 + 2 ) * ( 7 - 3 ) ) + ( 8 / 4 ) * ( 9 - 5 )"));

     
        assertEquals("2 3 + 4 5 * + 6 -",
                calcConvertInfix.convertInfixToPostfix("( 2 + 3 ) + ( 4 * 5 ) - 6"));

        
        assertEquals("7 3 + 2 1 + / 5 *",
                calcConvertInfix.convertInfixToPostfix("( ( 7 + 3 ) / ( 2 + 1 ) ) * 5"));

   
        assertEquals("10 2 3 + * 6 4 - +",
                calcConvertInfix.convertInfixToPostfix("( 10 * ( 2 + 3 ) ) + ( 6 - 4 )"));

      
        assertEquals("5 1 2 + 4 * + 3 -",
                calcConvertInfix.convertInfixToPostfix("5 + ( ( 1 + 2 ) * 4 ) - 3"));
    }

    @Test
    @DisplayName("PostFix - precedence() Test")
    void PrecedenceTest() {
        assertEquals(1, PostFixCalculator.precedence("+"));
        assertEquals(1, PostFixCalculator.precedence("-"));
        assertEquals(2, PostFixCalculator.precedence("/"));
        assertEquals(2, PostFixCalculator.precedence("*"));
        assertEquals(3, PostFixCalculator.precedence("("));
        assertEquals(3, PostFixCalculator.precedence(")"));
    }

    @Test
    @DisplayName("PostFix  - precedence() IllegalArgument Test")
    void PrecedenceIllegalArgumentTest() {
        assertThrows(IllegalArgumentException.class, () -> {
            PostFixCalculator.precedence("&");
        });
    }

    @Test
    @DisplayName("PostFix - hasLowerPrecedence() Test")
    void hasLowerPrecedenceTest() {
        //Test, if op2 = "(" or ")"
        assertEquals(false, PostFixCalculator.hasLowerPrecedence("+", ")"));
        assertEquals(false, PostFixCalculator.hasLowerPrecedence("+", "("));

        //Test, if op1 = op2
        assertEquals(true, PostFixCalculator.hasLowerPrecedence("+", "+"));

        //Test, if precedence(op1) == precedence(op2)
        assertEquals(true, PostFixCalculator.hasLowerPrecedence("-", "+"));

        //Test, if precedence(op1) < precedence(op2); --> For example: "+" and  "*" 
        assertEquals(true, PostFixCalculator.hasLowerPrecedence("+", "*"));
    }

}
