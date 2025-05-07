# A Version of a Postfix Calculator

## Idea

**Mission**  
Read a string, interpret it as a postfix expression, evaluate it, and return the result. The result can be a string, integer, or double — the specific type doesn't matter for now.

**Concept**  
Use a loop over a character array to identify operators (`+`, `-`, `*`, `/`). When an operator is found, apply it to the last two numbers from the input or stack.

**Implementation Notes**  
Instead of character arrays, various types of arrays were used. A `count` variable and several attributes were employed to manage the process. The program works partially, but some cases — such as expressions with three numbers followed by a single operator — are not yet handled correctly.


## Actual Implementation

### Node Class (String)

> The ``Node.java`` Class serves as one element in the linked list's, it has a data Attribute, which is the Data Element, and a next attribute, which is a reference to the next Element and also a previous attribute, which point to the previous Element.

### MySingleLinkedList Class (T)

> Using the Node Object as a Element, the Object can be used as a Single Linked List. It comes with Methods such as ``addFirst``/ ``addLast()`` , ``first()``/``last()`` returning the first or last Element of the List, a ``size()`` method, returning the size of the list in a integer form, a ``isEmpty()`` Method, returning a true boolean if the List is empty and a ``printList()`` method, printing the Elements of the list and the pointer  
> *Example: 10 -> 20 -> null*

### MyLinkedList Class (T)

> Using the Node Object as a Element, the Object can be usede as a (Double) Linked List. It comes with Methods like ``size()``, returning the amount of Elements in the List as a Integer, ``isEmpty()``, returning a boolean value depending on if the list is empty or not, a ``first()`` method, returning the first element of the list and ``addFirst()``, adding an Element to the first position (head) of the List as well as ``removeFirst()``, removing the first Element of a list. It also has methods for the last position of the list (tail), such as ``last()``, returning the last element and ``addLast()``, adding a Element to the end of an list as well as a ``removeLast()`` removing the last Element of the list. For Test purposes it also comes with a ``printList()`` Method printing the list elements and their refrences:  
> *Example: 1 <-> 2 <-> 3 <-> null*

### PostFixCalculator Class

A Java class to calculate and convert Postfix and Infix mathematical expressions.

This class supports the evaluation of **Postfix (Reverse Polish Notation)** expressions and includes utility methods for converting between Postfix and Infix notation.  
It uses a **Singly Linked List** as the internal data structure for stack-like behavior.

---

#### ✅ isOperator(String token)

Checks whether a given token is a valid arithmetic operator.  
Supported operators: `+`, `-`, `*`, `/`

- **Returns:** `true` if the token is an operator, otherwise `false`.

---

#### ✅ isOperatorExtended(String token)

Checks whether a given token is a valid operator or parenthesis.  
Supported tokens: `+`, `-`, `*`, `/`, `(`, `)`

- **Returns:** `true` if the token is an operator or parenthesis, otherwise `false`.

---

#### 🧮 calculatePostFix(String expression)

Evaluates the result of a **Postfix expression**.  
The input string must be space-separated (e.g., `"3 4 + 5 *"`).  
Internally uses a singly linked list as a stack.

- **Input:** `"3 4 + 5 + 6 + 7 +"`
- **Output:** `"25"`

- **Throws:** `IllegalArgumentException` for invalid operators or values.

---

#### 🔁 convertPostfixToInfix(String expression)

Converts a **Postfix expression** into an **Infix expression** with proper parentheses.  
Useful for understanding the expression in a more familiar format.

- **Input:** `"3 4 + 2 *"`
- **Output:** `"((3 + 4) * 2)"`

- **Throws:** `IllegalArgumentException` for invalid tokens.

---

#### 🔄 convertInfixToPostfix(String expression)

Converts an **Infix expression** into **Postfix (RPN)** notation using operator precedence and parentheses.  
Uses the Shunting Yard Algorithm.

- **Input:** `"( 3 + 4 ) * 2"`
- **Output:** `"3 4 + 2 *"`

- **Note:** Input must be space-separated (e.g., `"3 + 4"` NOT `"3+4"`)

- **Throws:** `IllegalArgumentException` for invalid tokens.

---

#### 🧠 precedence(String operator)

Returns the **precedence level** of the provided operator, used in expression conversion.

| Operator | Precedence |
|----------|------------|
| `+`, `-` | 1          |
| `*`, `/` | 2          |
| `(`, `)` | 3          |

- **Throws:** `IllegalArgumentException` for unknown operators.

---

#### ⚖️ hasLowerPrecedence(String op1, String op2)

Compares two operators to determine if the first one (`op1`) has **lower or equal precedence** than the second (`op2`).  
Used to decide whether to pop from the operator stack during infix-to-postfix conversion.

- **Returns:** `true` if `op1` has lower or equal precedence, or is the same as `op2`.

---

#### 📌 Example Usage

```java
PostFixCalculator calc = new PostFixCalculator();
String result = calc.calculatePostFix("3 4 + 5 + 6 + 7 +"); // → "25"
String infix = calc.convertPostfixToInfix("3 4 + 2 *"); // → "((3 + 4) * 2)"
String postfix = calc.convertInfixToPostfix("( 3 + 4 ) * 2"); // → "3 4 + 2 *"
```

#### Logging in PostFixCalculator Class

The `PostFixCalculator` class uses multiple dedicated loggers to track different aspects of calculation and conversion processes. These loggers provide detailed insights for debugging and monitoring.

#### Logging in PostFixCalculator Class

The `PostFixCalculator` class uses multiple dedicated loggers to track different aspects of calculation and conversion processes. These loggers provide detailed insights for debugging and monitoring.

##### Logger Declarations
```java
// Step-by-step calculation logger
private static final Logger logger = LoggerFactory.getLogger("PostFixCalculator");
// Solution output logger
private static final Logger solutionLogger = LoggerFactory.getLogger("PostFixCalculator.solution");
// Postfix to Infix conversion logger
private static final Logger postfixToInfixLogger = LoggerFactory.getLogger("PostFixCalculator.postfixToInfix");
// Postfix to Infix solution logger
private static final Logger solutionPostfixToInfixLogger = LoggerFactory.getLogger("PostFixCalculator.solutionPostfixToInfix");
// Infix to Postfix conversion logger
private static final Logger infixToPostFixLogger = LoggerFactory.getLogger("PostFixCalculator.infixToPostFix");
// Infix to Postfix solution logger
private static final Logger solutionInfixToPostFixLogger = LoggerFactory.getLogger("PostFixCalculator.solutionInfixToPostFix");
```

### Logger Overview

1. **`logger` (Step-By-Step Logger)**
   - **Purpose:** Tracks the detailed flow of `calculatePostFix()`
   - **Logs:**
     - Token checks (operator/operand)
     - Stack operations (push/pop)
     - Intermediate calculations
   - **Levels:**
     - `info`: Main calculation flow
     - `debug`: Stack state and operand processing
     - `error`: Invalid tokens

2. **`solutionLogger` (Solution Logger)**
   - **Purpose:** Logs expression and final result
   - **Logs:**
     - Initial expression
     - Final calculation result
   - **Levels:**
     - `info`: Expression and result
     - `debug`: Formatting details

3. **`postfixToInfixLogger` (Conversion Logger)**
   - **Purpose:** Tracks Postfix-to-Infix conversion
   - **Logs:**
     - Token parsing
     - Stack operations
     - Parentheses handling
   - **Levels:**
     - `info`: Conversion start/end
     - `debug`: Detailed stack operations

4. **`solutionPostfixToInfixLogger` (Conversion Result Logger)**
   - **Purpose:** Logs Postfix-to-Infix results
   - **Logs:**
     - Original Postfix expression
     - Resulting Infix expression

5. **`infixToPostFixLogger` (Infix Conversion Logger)**
   - **Purpose:** Tracks Infix-to-Postfix conversion
   - **Logs:**
     - Operator precedence handling
     - Parentheses processing
     - Stack operations

6. **`solutionInfixToPostFixLogger` (Infix Conversion Result Logger)**
   - **Purpose:** Logs Infix-to-Postfix results
   - **Logs:**
     - Original Infix expression
     - Resulting Postfix expression

##### Log Storage
- Logs are stored in the `hardcodedLogs/` directory
- Committed to Git as reference examples
- Helps users understand:
  - Execution flow
  - Expected output formats
  - Debugging patterns

##### Why This Matters
- **Debugging:** Pinpoints exact failure points
- **Learning:** Shows real processing examples
- **Documentation:** Serves as live system documentation
- **Maintenance:** Clear separation of logging concerns
