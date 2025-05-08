package at.fhj.msd;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PostFixCalculator {

    private static final Logger logger = LogManager.getLogger(PostFixCalculator.class); //Step-By-Step Logger. print every single step for better understanding of calculatePostFix()
    private static final Logger solutionLogger = LogManager.getLogger("SolutionLogger"); //Only expression and results logged
    private static final Logger postfixToInfixLogger = LogManager.getLogger("PostfixToInfixLogger"); //Logs conversion of postfix to infix
    private static final Logger solutionPostfixToInfixLogger = LogManager.getLogger("SolutionPostfixToInfixLogger"); //Only expression and results logged of conversion
    private static final Logger infixToPostFixLogger = LogManager.getLogger("InfixToPostFixLogger"); //Logs conversion of infix to postfix
    private static final Logger solutionInfixToPostFixLogger = LogManager.getLogger("SolutionInfixToPostFixLogger"); //Only expression and results logged of conversion

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

        LogUtils.StartCalculation(logger, solutionLogger, expression);

        // Erstelle eine Instanz der LinkedList-Klasse
        MySinglyLinkedList<String> stack = new MySinglyLinkedList<>(); // Stack für die Berechnung
        String[] tokens = expression.split(" "); // Ausdruck in Tokens zerlegen

        double result = 0;

        // Berechne den Wert des Postfix-Ausdrucks
        for (String token : tokens) {

            if (!isOperator(token)) {
                LogUtils.noOperator(logger, token);

                if (Character.isDigit(token.charAt(0))) {
                    LogUtils.addDigit(logger, token);

                    //Add Token to Stack
                    stack.addFirst(token);
                    LogUtils.stackUpdated(logger, stack, "after adding");
                } else {
                    // Invalid Token
                    LogUtils.invalidToken(logger, solutionLogger, token);
                    LogUtils.sectionBreak(logger, solutionLogger);

                    throw new IllegalArgumentException("One element of the given postfix-notation is neither an operator nor a digit!");

                }
            } else {
                // Log that token is operator
                LogUtils.isOperator(logger, token);

                LogUtils.removingFromStack(logger, stack.first());
                double number2 = Double.parseDouble(stack.removeFirst());
                LogUtils.stackUpdated(logger, stack, "after removing");

                LogUtils.removingFromStack(logger, stack.first());
                double number1 = Double.parseDouble(stack.removeFirst());
                LogUtils.stackUpdated(logger, stack, "after removing");

                //Log: Calculating for...
                LogUtils.calculatingFor(logger, number1, number2, token);

                //? Result - Solution
                if (token.equals("+")) {
                    result = number1 + number2;
                } else if (token.equals("-")) {
                    result = number1 - number2;
                } else if (token.equals("*")) {
                    result = number1 * number2;
                } else {
                    if (number2 == 0.0) {
                        LogUtils.divideByZero(logger, solutionLogger);
                        throw new ArithmeticException("Division by 0 is not possible!");
                    }
                    result = number1 / number2;
                }

                LogUtils.calculated(logger, number1, number2, token, result);
                LogUtils.addingToStack(logger, result);

                //Adding result to stack
                stack.addFirst(String.valueOf(result)); //Result back on stack
                LogUtils.stackUpdated(logger, stack, "after adding");
            }

        }

        LogUtils.finalResult(logger, solutionLogger, result);

        return Double.toString(result);

    }

    //? Bonus Punkte, maybe? :)
    /**
     * Converts a postfix expression (Reverse Polish Notation) into a valid
     * infix expression.
     * <p>
     * This method parses a space-separated postfix expression and reconstructs
     * the original infix notation by using a stack-based approach. It processes
     * each token in the postfix expression, where operands are pushed onto the
     * stack and operators trigger a pop of the top two operands to form an
     * infix sub-expression.
     * </p>
     *
     * <p>
     * The reconstructed sub-expression is then pushed back onto the stack. This
     * continues until the full infix expression is formed.
     * </p>
     *
     * <p>
     * Example:
     * <pre>
     * Input: 3 4 + 2 *
     * Output: ((3 + 4) * 2)
     * </pre>
     * </p>
     *
     * <p>
     * <b>Note:</b> The input expression must be space-separated (e.g.
     * {@code "3 4 +"}).</p>
     *
     * @param expression A postfix expression as a string, with each token
     * (number or operator) separated by a space
     * @return The corresponding infix expression as a string
     * @throws IllegalArgumentException If a token is neither a valid number nor
     * a supported operator
     */
    public String convertPostfixToInfix(String expression) {

        LogUtils.startConversionToInfix(postfixToInfixLogger, solutionPostfixToInfixLogger, expression);

        MySinglyLinkedList<String> stack = new MySinglyLinkedList<>();
        String[] tokens = expression.split(" ");
        String infix = "";

        postfixToInfixLogger.info("call calculatePostFix and try to calculate the expression first...");

        //Check if division by 0
        boolean divisionIsOk = true;

        try {
            String result = calculatePostFix(expression);
            System.out.println(result); //debug
        } catch (ArithmeticException e) {
            divisionIsOk = false;
        }

        if (divisionIsOk) {
            postfixToInfixLogger.debug("postfix expression: {} is correct!", expression);
        } else {

            LogUtils.divideByZero(postfixToInfixLogger, solutionPostfixToInfixLogger);
            throw new ArithmeticException("The given Postfix-notation contains division by 0!");
        }

        for (String token : tokens) {

            if (!isOperator(token)) {
                LogUtils.noOperator(postfixToInfixLogger, token);

                if (Character.isDigit(token.charAt(0))) {
                    LogUtils.addDigit(postfixToInfixLogger, token);

                    //Adding token to stack
                    stack.addFirst(token);
                    LogUtils.stackUpdated(postfixToInfixLogger, stack, "after adding");
                } else {
                    //Invalid token
                    LogUtils.invalidToken(postfixToInfixLogger, solutionPostfixToInfixLogger, token);
                    LogUtils.sectionBreak(postfixToInfixLogger, solutionPostfixToInfixLogger);

                    throw new IllegalArgumentException("One element of the given postfix-notation is neither an operator nor a digit!");
                }
            } else {

                LogUtils.isOperator(postfixToInfixLogger, token);

                LogUtils.removingFromStack(postfixToInfixLogger, stack.first());
                String number2 = stack.removeFirst();
                LogUtils.stackUpdated(postfixToInfixLogger, stack, "after removing");

                LogUtils.removingFromStack(postfixToInfixLogger, stack.first());
                String number1 = stack.removeFirst();
                LogUtils.stackUpdated(postfixToInfixLogger, stack, "after removing");

                LogUtils.convertingFor(postfixToInfixLogger, number1, number2, token);

                if (token.equals("+")) {
                    infix = "(" + number1 + " + " + number2 + ")";
                } else if (token.equals("-")) {
                    infix = "(" + number1 + " - " + number2 + ")";
                } else if (token.equals("*")) {
                    infix = "(" + number1 + " * " + number2 + ")";
                } else {
                    infix = "(" + number1 + " / " + number2 + ")";
                }

                LogUtils.converted(postfixToInfixLogger, infix);
                LogUtils.addingToStack(logger, infix);

                //Adding result to stack
                stack.addFirst(infix);
                LogUtils.stackUpdated(postfixToInfixLogger, stack, "after adding");

            }

        }

        LogUtils.finalResult(postfixToInfixLogger, solutionPostfixToInfixLogger, infix);

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

       LogUtils.startConversionToPostfix(infixToPostFixLogger, solutionInfixToPostFixLogger, expression);

        MySinglyLinkedList<String> stack = new MySinglyLinkedList<>();
        List<String> operands = new ArrayList<>();

        String[] tokens = expression.split(" "); // Ausdruck in Tokens zerlegen

        for (String token : tokens) {
            //?If it is a number, then put it into new data structure: list
            if (!isOperatorExtended(token)) {
                LogUtils.noOperator(infixToPostFixLogger, token);

                if (Character.isDigit(token.charAt(0))) {
                    LogUtils.addDigit(infixToPostFixLogger, token);

                    operands.add(token);
                    LogUtils.listUpdated(infixToPostFixLogger, operands, "after adding");
                } else {
                    //Invalid token
                    LogUtils.invalidToken(infixToPostFixLogger, solutionInfixToPostFixLogger, token);
                    LogUtils.sectionBreak(infixToPostFixLogger, solutionInfixToPostFixLogger);

                    throw new IllegalArgumentException("One element of the given infix-notation is neither an operator nor a digit!");
                }
            } else {

                LogUtils.isOperator(infixToPostFixLogger, token);

                //? Example1: if token is = ")" the while loop will be ignored and the token will be added to the stack
                //? Example2: If token is = "-" and ")" is already in the stack, while loop will also be skipped, see hasLowerPrecendence()
                //? Example3: if token is = "+" and "*" is already in the stack, while loop will be called, we are then following the mathematical rules
                infixToPostFixLogger.info("Processing token: '{}'", token);

                while (!stack.isEmpty() && hasLowerPrecedence(token, stack.first())) {

                    infixToPostFixLogger.debug("Operator '{}' has lower or equal precedence, removing all operators from the stack and adding them to the operand list.", token);
                    infixToPostFixLogger.debug("Removing first element: '{}' from stack", stack.first());
                    infixToPostFixLogger.debug("Adding removed element: '{}' from stack to operands list", stack.first());

                    operands.add(stack.removeFirst()); //Remove all upper-level operators to the list of operands

                    LogUtils.stackUpdated(infixToPostFixLogger, stack, "after removing");
                    infixToPostFixLogger.debug("operands list after adding first element from stack: {}", operands.toString());

                }

                LogUtils.addingToStack(infixToPostFixLogger, token);
                stack.addFirst(token); //? After while loop (or not) token will be added to stack!

                LogUtils.stackUpdated(infixToPostFixLogger, stack, "after adding");

                int count = 0;
                //? Iterate backbwards until "(" is found
                if (token.equals(")")) {
                    infixToPostFixLogger.debug("Found closing parenthesis. Moving operators inside parentheses to the operand list.");
                    while (!stack.isEmpty() && !stack.first().equals("(")) {

                        if (count == 0) {
                            infixToPostFixLogger.debug("Removing first '(' from stack");
                            stack.removeFirst(); //if count == 0, then the value "(" will be called, since we don't need it, we will remove it

                            LogUtils.stackUpdated(infixToPostFixLogger, stack, "after removing");
                            count++;
                        }

                        infixToPostFixLogger.debug("Removing first element: '{}' from stack", stack.first());
                        infixToPostFixLogger.debug("Adding removed element: '{}' from stack to operands list", stack.first());

                        operands.add(stack.removeFirst()); //move all operators which were inside the parentheses to the operand list!
                        LogUtils.stackUpdated(infixToPostFixLogger, stack, "after removing");
                        
                        infixToPostFixLogger.debug("operands list after adding first element from stack: {}", operands.toString());
                    }

                    infixToPostFixLogger.debug("Removing the ')' in relation to the first '(' from stack");
                    stack.removeFirst(); //When "(" found, then remove ")" also!

                    infixToPostFixLogger.debug("stack after removing first ')': '{}'", stack.printListAsString());
                    infixToPostFixLogger.info("Processed token: {} --> END", token);

                }

            }
        }

        //? If the infix notation is at the end (for loop end), then move all remaining operators to operands list
        //? This will ensure, that the stack is empty at the end
        while (!stack.isEmpty()) {
            infixToPostFixLogger.info("Processing remaining operators in the stack, moving them to the operands list.");

            infixToPostFixLogger.debug("Removing first element: '{}' from stack", stack.first());
            infixToPostFixLogger.debug("Adding removed element: '{}' from stack to operands list", stack.first());

            operands.add(stack.removeFirst());

            LogUtils.stackUpdated(infixToPostFixLogger, stack, "after removing");
            infixToPostFixLogger.debug("operands list after adding first element from stack: {}", operands.toString());
        }

        infixToPostFixLogger.info("call calculatePostFix and try to calculate the expression first...");

        //Check if division by 0

        boolean divisionIsOk = true;

        try {
            String result = calculatePostFix(String.join(" ", operands));

        } catch (ArithmeticException e) {
            divisionIsOk = false;
        }

        if (divisionIsOk) {

            LogUtils.finalResult(infixToPostFixLogger, solutionInfixToPostFixLogger, String.join(" ", operands));

            return String.join(" ", operands);
        } else {
            LogUtils.divideByZero(infixToPostFixLogger, solutionInfixToPostFixLogger);
            LogUtils.sectionBreak(infixToPostFixLogger, solutionInfixToPostFixLogger);
            
            throw new ArithmeticException("The given infix-notation contains division by 0!");
        }

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
