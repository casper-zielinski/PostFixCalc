# A (test) Version of a PostFix Calculator

## (test) Idea

>**Mission**: reading a String and interpreting it as a Post Fix Calculation and then solving it and
>returning the solution (as a String or a Integer or Double, doesn't matter for now)
>  

>**Idea**: using char arrays with a loop and checking if the char is a operator like: (+,-,*,/) and then with the operator calculating the last two digits.
>  

> **Practice**: Used different types of arrays, but not character arrays. Also made use of a `count` variable and several attributes. The program works to some extent, but not entirely — for example, a calculation with three numbers followed by an operator does not work correctly.

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

> A Class to calculate Postfix Equations. The first Method checks if the String provided a Operator is (**+,-,\*,/**), hence the name ``isOperator()``. The CalculatePostFix Method calculates the Postfix Equation and returns it as a String. It implements the SingleLinkedList and uses it to calculate the provided Equation. The Provided String hat to be in this Format, separated by Whitespaces,  
> *Example: ... ``calculatePostFix("3 4 + 5 + 6 + 7 +")`` --> 25*
