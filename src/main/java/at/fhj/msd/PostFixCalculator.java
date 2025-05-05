package at.fhj.msd;

import java.util.ArrayList;
import java.util.List;

public class PostFixCalculator {

    public PostFixCalculator() {
    }

    private boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    private boolean isOperatorExtended(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/") || token.equals("(") || token.equals(")");
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
                } else if (token.equals("/")) {
                    result = number1 / number2;
                }
                stack.addFirst(String.valueOf(result));
            }

        }

        return Integer.toString(result);

    }

    //? Watched the youtube video: https://www.youtube.com/watch?v=0Vnd41fBqY4
    //? for better understanding, how a method like this could look like.
    //? Based on the visuals in the video, I could implement the method and it works!

    public String convertInfixToPostfix(String expression) {

        MySinglyLinkedList<String> stack = new MySinglyLinkedList<>(); 
        List<String> operands = new ArrayList<>();
            
        
        String[] tokens = expression.split(" "); // Ausdruck in Tokens zerlegen

        for (String token : tokens) {

            //?If it is a number, then put it into new data structure: list
            //? Because in my implementation we want to seperate the numbers and operators

            if (!isOperatorExtended(token)) {
                if (Character.isDigit(token.charAt(0))) {
                    operands.add(token);
                } else {
                    throw new IllegalArgumentException("One of the given operators is not an actual operator");
                }
            } else {

                //? Example: if token is = ")" the while loop will be ignored and the token will be added to the stack
                //? Example2: If token is = "-" and ")" is already in the stack, while loop will also be skipped, see hasLowerPrecendence()
                //? Example3: if token is = "+" and "*" is already in the stack, while loop will be called, we are then following the mathematical rules

                while(!stack.isEmpty() && hasLowerPrecedence(token, stack.first())) {
                         
                    operands.add(stack.removeFist()); //Remove all upper-level operators to the list of operands
                }

                //? After while loop (or not) token will be added to stack!
            
                stack.addFirst(token);
                
                //? In my implementation I wanted to track down if a token is equal to ")".
                //? Why? Because I could iterate backbwards in the stack
                //? Example: if token is really ")" it will iterate backwards in the stack and put all operators into the operands list, until "(" is found
                //? I got the idea also from the video, linked above
                if (token.equals(")")) {
                    while(!stack.isEmpty() && !stack.first().equals("(")) {
                        int count = 0; 
                        if (count == 0) {
                            stack.removeFist(); //if count == 0, then the value "(" will be called, since we don't need it, we will remove it
                            count++;
                        }
                        operands.add(stack.removeFist()); //move all operators which were inside the parentheses to the operand list!
                    }
                   
                   stack.removeFist(); //When "(" found, then remove ")" also!
                }
               
            }
        }

        //? If the infix notation is at the end (for loop end), then move all remaining operators to operands list
        //? This will ensure, that the stack is empty at the end

        while(!stack.isEmpty()) {
            operands.add(stack.removeFist());
        }

        //? Remove all remaining parentheses and create a clean String!
        String s_clean = String.join(" ", operands).replace("(", "").replace(")", "");
        
        return String.join(" ", operands);
    }

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
                    return 4;
        }
    }

    public static boolean hasLowerPrecedence(String op1, String op2) {
        //? If op2 is ( or ), then this method should return false. 
        //? Why? --> Because the parentheses will be ignored in my whole implementation
        //? Example --> Let's say op1 is "-" and op2 is "("
        //? Altough the parentheses will return the value: 3 in precendence() method and minus will return the value: 1
        //? It still will not be true, because in my implementation, I will consider () = minus, etc. 
        //? Because, I need this logic to ensure that the parentheses will not be thrown out from the stack
        if (op2.equals("(") || op2.equals(")")) {
            return false;
        } else {
            return precedence(op1) < precedence(op2);
        }
        
    }
}
