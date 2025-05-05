package at.fhj.msd;

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
     * The isOperator method returns a boolean, if the method has found an
     * operator
     *
     * @param token
     * @return boolean
     */
    private boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
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
                int number2 = Integer.parseInt(stack.removeFist());
                int number1 = Integer.parseInt(stack.removeFist());

                if (token.equals("+")) {
                    result = number1 + number2;
                } else if (token.equals("-")) {
                    result = number1 - number2;
                } else if (token.equals("*")) {
                    result = number1 * number2;
                } else if (token.equals("/")) {
                    result = number1 / number2;
                }
                stack.addFirst(String.valueOf(result));
            }

        }

        return Integer.toString(result);

    }

}
