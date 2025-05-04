package at.fhj.msd;

public class PostFixCalculator {

    private String expression;

    public PostFixCalculator() {
    }

    public PostFixCalculator(String expression) {
        this.expression = expression;
    }

    private boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    public void calculatePostFix(String expression) {
        // Erstelle eine Instanz der LinkedList-Klasse
        MySinglyLinkedList<String> stack = new MySinglyLinkedList<>(); // Stack für die Berechnung
        String[] tokens = expression.split(" "); // Ausdruck in Tokens zerlegen

        // Berechne den Wert des Postfix-Ausdrucks

        for (String token : tokens) {
            if (!isOperator(token)) {
                stack.addFirst(token);
            } else {
                int number2 = Integer.parseInt(stack.removeFist());
                int number1 = Integer.parseInt(stack.removeFist());

                int result = switch (token) {
                    case "+" -> number1 + number2;
                    case "-" -> number1 - number2;
                    case "*" ->  number1 * number2;
                    case "/" ->  number1 / number2;
                    default  -> throw new IllegalArgumentException("Illegal Operator");
                };

               stack.addFirst(String.valueOf(result));
            }
        

        }

        stack.printList();

    }

}
