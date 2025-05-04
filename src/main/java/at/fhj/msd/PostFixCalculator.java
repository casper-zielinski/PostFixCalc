package at.fhj.msd;

public class PostFixCalculator {

    private String expression;

    public PostFixCalculator() {
    }

    public PostFixCalculator(String expression) {
        this.expression = expression;
    }

    public void calculatePostFix(String expression) {
        // Erstelle eine Instanz der LinkedList-Klasse
        MySinglyLinkedList<String> stack = new MySinglyLinkedList<>(); // Stack für die Berechnung
        String[] tokens = expression.split(" "); // Ausdruck in Tokens zerlegen

        // Berechne den Wert des Postfix-Ausdrucks
        boolean status = true;
        boolean status2 = true;
        String operator = "";
        int count = 0;

        while (status) {
            for (;count < tokens.length; count++) {
                if (tokens[count].equals("+") || tokens[count].equals("-") || tokens[count].equals("*") || tokens[count].equals("/")) {
                    operator = tokens[count];
                    status2 = false;
                    count++;
                    break;
                }
                stack.addFirst(tokens[count]);
            }
               
                int result = 0;

                if (status2 == false) {
                    int number2 = Integer.parseInt(stack.removeFist());
                    int number1 = Integer.parseInt(stack.removeFist());

                    if (operator.equals("+")) {
                        result = number1 + number2;
                    }
                    if (operator.equals("-")) {
                        result = number1 - number2;
                    }
                    if (operator.equals("*")) {
                        result = number1 * number2;
                    }
                    if (operator.equals("/")) {
                        result = number1 / number2;
                    }

                    String resultString = Integer.toString(result);

                    stack.addFirst(resultString);
                    status2 = true;
                }

               if (count == tokens.length) {
                status = false;
               }
            
        }
        stack.printList();

    }

}
