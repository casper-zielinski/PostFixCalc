package at.fhj.msd;

public class PostFixCalculator {

    public PostFixCalculator() {
    }

    private boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    @SuppressWarnings("ConvertToStringSwitch")
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

}
