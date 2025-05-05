package at.fhj.msd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PostFixCalculatorTest {

    PostFixCalculator calc;

    @BeforeEach
    @DisplayName("PostFix Calculator Setup")
    public void setup() {
        calc = new PostFixCalculator();
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

}
