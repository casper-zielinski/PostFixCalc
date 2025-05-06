package at.fhj.msd;

import java.util.ArrayList;
import java.util.List;

public class PostFixCalculator {

    /**
     * A class that implements a Postfix Calculator using a single linked list
     * as its underlying data structure.
     *
     * This calculator evaluates mathematical expressions written in postfix
     * notation (Reverse Polish Notation). Postfix notation is a mathematical
     * notation where operators follow their operands, making parentheses
     * unnecessary.
     *
     * The class provides a method that takes a postfix expression as a string
     * and calculates its result.
     *
     * The expression should be in the form of operands and operators separated
     * by spaces, with supported operators being addition (+), subtraction (-),
     * multiplication (*), and division (/).
     *
     * The calculator uses a single linked list to store intermediate results
     * during the evaluation process. The linked list structure ensures
     * efficient manipulation of the data during the calculation.
     *
     * @see MySinglyLinkedList
     */
    public PostFixCalculator() {
    }

    /**
     * Checks whether the given token is a valid operator
     *
     * Recognized operators are: +, -, *, /
     *
     * @param token
     * @return true if the token is an operator; false otherwise
     */
    private boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    /**
     * Checks whether the given token is a valid operator, including
     * parentheses.
     *
     * Recognized operators are: +, -, *, /, (, )
     *
     * @param token the input token to check
     * @return true if the token is an operator or parenthesis; false otherwise
     */
    private boolean isOperatorExtended(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/") || token.equals("(") || token.equals(")");
    }

    /**
     * Evaluates the result of a postfix expression (Reverse Polish Notation)
     * and returns the final result as a string.
     *
     * This method takes a postfix expression as a single string, splits it into
     * individual tokens (numbers and operators), and uses a stack (implemented
     * as a singly linked list) to process the expression. The method follows
     * the typical "push" and "pop" logic of a stack to handle the postfix
     * notation.
     *
     * The method iterates over each token, checks whether it is a valid number
     * or operator, and performs the corresponding operation. When an operator
     * is encountered, the method pops the necessary operands from the stack,
     * applies the operator, and pushes the result back onto the stack. This
     * process continues until the entire expression is evaluated.
     *
     * The final result is returned as a string representation of the computed
     * value.
     *
     * <p>
     * <strong>Important:</strong> The postfix expression must be provided with
     * spaces between each element (numbers and operators). For example, the
     * expression "3 4 +" must have spaces between the operands and the
     * operator.</p>
     *
     * @param expression A string representing the postfix expression to
     * evaluate.
     * @return A string containing the result of the postfix expression
     * calculation.
     * @throws IllegalArgumentException If the expression contains invalid
     * operators, invalid numbers, or any other errors.
     */
    public String calculatePostFix(String expression) {

        // Erstelle eine Instanz der LinkedList-Klasse
        MySinglyLinkedList<String> stack = new MySinglyLinkedList<>(); // Stack für die Berechnung
        String[] tokens = expression.split(" "); // Ausdruck in Tokens zerlegen
        int result = 0;

        // Berechne den Wert des Postfix-Ausdrucks
        for (String token : tokens) {

            if (!isOperator(token)) {
                if (Character.isDigit(token.charAt(0))) {
                    stack.addFirst(token);
                } else {
                    throw new IllegalArgumentException("One of the given operators is not an actual operator");
                }
            } else {
                int number2 = Integer.parseInt(stack.removeFirst());
                int number1 = Integer.parseInt(stack.removeFirst());

                //? Result - Solution
                if (token.equals("+")) {
                    result = number1 + number2;
                } else if (token.equals("-")) {
                    result = number1 - number2;
                } else if (token.equals("*")) {
                    result = number1 * number2;
                } 
                else {
                    result = number1 / number2;
                }
                stack.addFirst(String.valueOf(result)); //Result back on stack
            }

        }

        return Integer.toString(result);

    }

      //? Bonus Punkte, maybe? :)
      public String convertPostfixToInfix(String expression) {

        MySinglyLinkedList<String> stack = new MySinglyLinkedList<>();
        String[] tokens = expression.split(" ");
        String infix = "";

        for (String token : tokens) {

            if (!isOperator(token)) {
                if (Character.isDigit(token.charAt(0))) {
                    stack.addFirst(token);
                } else {
                    throw new IllegalArgumentException("One element of the given PostFix notation is neither an operator nor a digit!");
                }
            } else {
                String number2 = stack.removeFirst();
                String number1 = stack.removeFirst();

                if (token.equals("+")) {
                    infix = "(" + number1 + " + " + number2 + ")";
                } else if (token.equals("-")) {
                    infix = "(" + number1 + " - " + number2 + ")";
                } else if (token.equals("*")) {
                    infix = "(" + number1 + " * " + number2 + ")";
                } else {
                    infix = "(" + number1 + " / " + number2 + ")";
                }
                stack.addFirst(infix);
            }

        }

        return infix;

    }

    /**
     * Watched the youtube video: https://www.youtube.com/watch?v=0Vnd41fBqY4
     * for better understanding, how a method like this could look like. Based
     * on the visuals in the video, I could implement the method and it works!
     *
     *
     * * Converts an infix expression (mathematical notation) into postfix
     * notation (Reverse Polish Notation).
     * <p>
     * This method uses a stack-based algorithm to convert an infix expression
     * into postfix form. The algorithm handles parentheses and operator
     * precedence, ensuring that the operators are placed in the correct order
     * according to the mathematical rules of precedence.
     * </p>
     *
     * <p>
     * The algorithm works as follows:
     * </p>
     * <ul>
     * <li>If the token is a number, it is added directly to the operand
     * list.</li>
     * <li>If the token is an operator, it is pushed onto the stack, but only
     * after removing any operators from the stack with higher or equal
     * precedence.</li>
     * <li>If the token is a closing parenthesis (')'), operators are popped
     * from the stack into the operand list until an opening parenthesis ('(')
     * is encountered, which is discarded.</li>
     * <li>At the end of the expression, any remaining operators in the stack
     * are moved to the operand list.</li>
     * </ul>
     *
     * <p>
     * The resulting postfix expression is returned as a string, where operands
     * and operators are separated by spaces.
     * </p>
     *
     * <p>
     * <strong>Important:</strong> When providing the infix expression as input,
     * ensure that there is a space between each element (operator, operand, or
     * parenthesis). For example, the expression "( 3 + 4 )" must be provided
     * with spaces between the numbers, operators, and parentheses.</p>
     *
     * @param expression the infix expression to be converted, with operators
     * and operands separated by spaces
     * @return the equivalent postfix expression
     * @throws IllegalArgumentException if an element in the expression is
     * neither an operator nor a number
     */
    public String convertInfixToPostfix(String expression) {

        MySinglyLinkedList<String> stack = new MySinglyLinkedList<>();
        List<String> operands = new ArrayList<>();

        String[] tokens = expression.split(" "); // Ausdruck in Tokens zerlegen

        for (String token : tokens) {

            //?If it is a number, then put it into new data structure: list
            if (!isOperatorExtended(token)) {
                if (Character.isDigit(token.charAt(0))) {
                    operands.add(token);
                } else {
                    throw new IllegalArgumentException("One element of the given infix-notation is neither an operator nor a digit!");
                }
            } else {

                //? Example1: if token is = ")" the while loop will be ignored and the token will be added to the stack
                //? Example2: If token is = "-" and ")" is already in the stack, while loop will also be skipped, see hasLowerPrecendence()
                //? Example3: if token is = "+" and "*" is already in the stack, while loop will be called, we are then following the mathematical rules
                while (!stack.isEmpty() && hasLowerPrecedence(token, stack.first())) {

                    operands.add(stack.removeFirst()); //Remove all upper-level operators to the list of operands
                }

                stack.addFirst(token); //? After while loop (or not) token will be added to stack!

                //? Iterate backbwards until "(" is found
                if (token.equals(")")) {
                    while (!stack.isEmpty() && !stack.first().equals("(")) {
                        int count = 0;
                        if (count == 0) {
                            stack.removeFirst(); //if count == 0, then the value "(" will be called, since we don't need it, we will remove it
                            count++;
                        }
                        operands.add(stack.removeFirst()); //move all operators which were inside the parentheses to the operand list!
                    }

                    stack.removeFirst(); //When "(" found, then remove ")" also!
                }

            }
        }

        //? If the infix notation is at the end (for loop end), then move all remaining operators to operands list
        //? This will ensure, that the stack is empty at the end
        while (!stack.isEmpty()) {
            operands.add(stack.removeFirst());
        }

        return String.join(" ", operands);
    }

    /**
     * Returns the precedence level of the given operator based on the standard
     * order of operations: Parentheses, Exponents, Multiplication/Division, and
     * Addition/Subtraction (PEMDAS/BODMAS).
     *
     * <p>
     * This method ensures the correct handling of operator precedence for
     * arithmetic expressions. The precedence levels are assigned as
     * follows:</p>
     * <ul>
     * <li>Parentheses ('(', ')'): Precedence level 3 (highest precedence)</li>
     * <li>Multiplication ('*') and Division ('/'): Precedence level 2</li>
     * <li>Addition ('+') and Subtraction ('-'): Precedence level 1 (lowest
     * precedence)</li>
     * </ul>
     *
     * <p>
     * If the provided operator is not recognized, an
     * {@link IllegalArgumentException} is thrown.</p>
     *
     * @param operator the operator whose precedence is to be determined
     * @return the precedence level of the operator
     * @throws IllegalArgumentException if the operator is not a valid
     * arithmetic operator
     */
    //? This method is used to ensure  "Parentheses – Exponents – Multiplication/Division – Addition/Subtraction" Logic
    public static int precedence(String operator) {

        switch (operator) {

            case "+":
            case "-":
                return 1;
            case "/":
            case "*":
                return 2;
            case "(":
            case ")":
                return 3;
            default:
                throw new IllegalArgumentException("Ungültiger Operator: " + operator);
        }
    }

    /**
     * Compares the precedence of two operators and determines if the first
     * operator has lower precedence than the second.
     *
     * <p>
     * Special handling is applied when one of the operators is a
     * parenthesis:</p>
     * <ul>
     * <li>If the second operator is a parenthesis ('(' or ')'), the method
     * returns false because parentheses are handled differently in the
     * expression and should not be compared directly.</li>
     * <li>If both operators are the same (e.g., both '+' or both '-'), the
     * method returns true, indicating that one of the operators should be
     * popped from the stack.</li>
     * <li>If the operators have the same precedence (e.g., '+' and '-'), the
     * method returns true to ensure that the operator on the stack is
     * popped.</li>
     * </ul>
     * <p>
     * If none of these special cases apply, the method returns true if the
     * first operator has lower precedence than the second, following the
     * standard precedence rules of arithmetic operations.</p>
     *
     * @param op1 the first operator (currently on the stack)
     * @param op2 the second operator (being processed)
     * @return true if op1 has lower precedence than op2 or if special cases
     * apply; false otherwise
     */
    public static boolean hasLowerPrecedence(String op1, String op2) {

        if (op2.equals("(") || op2.equals(")")) {
            return false;
        } else if (op1.equals(op2)) { //Example: "+" and "+", if that's the case, one "+" should be removed from stack
            return true;
        } else if (precedence(op1) == precedence(op2)) { //Example: "-" and "+", if that's the case, "+" should be also removed from stack
            return true;
        } else {
            return precedence(op1) < precedence(op2); //Normal mathematical logic

        }
    }
}
