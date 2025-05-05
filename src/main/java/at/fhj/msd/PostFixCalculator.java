package at.fhj.msd;

public class PostFixCalculator {

    public PostFixCalculator() {
    }

    private boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

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
                } else {
                    result = number1 / number2;
                }
                stack.addFirst(String.valueOf(result));
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
                String number2 = stack.removeFist();
                String number1 = stack.removeFist();

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

}
