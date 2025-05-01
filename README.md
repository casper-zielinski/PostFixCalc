# A (test) Version of a PostFix Calculator

## (test) Idea

<h2>

>**Mission**: reading a String and interpreting it as a Post Fix Calculation and then solving it and
>returning the solution (as a String or a Integer or Double, doesn't matter for now)
>

<br>

>**Idea**: using char arrays with a loop and checking if the char is a operator like: (+,-,*,/) and then with the operator calculating the last two digits.
>
>

<h2>

> **Practice**: Used different types of arrays, but not character arrays. Also made use of a `count` variable and several attributes. The program works to some extent, but not entirely — for example, a calculation with three numbers followed by an operator does not work correctly.

## Actual Implementation


### Node Class (String)

> The ``Node.java`` Class serves as one element in the linked list's, it has a data Attribute, which is the Data Element, and a next attribute, which is a reference to the next Element and also a previous attribute, which point to the previous Element.

### MySingleLinkedList Class (String)

> Using the Node Object as a Element, the Object can be used as a Single Linked List. It comes with Methods such as addFirst/Last, First/Last returning the first or last Element of the List, a size method, returning the size of the list in a integer form, a isEmpty Method, returning a true boolean if the List is empty and a printList method, printing the Elements of the list and the pointer (Example: 10 -> 20 -> null )

