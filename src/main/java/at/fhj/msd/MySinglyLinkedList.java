package at.fhj.msd;

import java.util.NoSuchElementException;

/**
 * A simple implementation of a singly linked list that implements the
 * {@link LinkedListInterface}. This class provides methods to manipulate the
 * linked list, including adding, removing, and retrieving elements as well as
 * checking its size, whether it is empty, and printing the list. The list is
 * composed of nodes, each containing a string data and a reference to the next
 * node.
 *
 * @param <E> the type of elements in the linked list.
 * @see Node
 * @see LinkedListInterface
 */
public class MySinglyLinkedList<E> implements LinkedListInterface<E> {

    private Node<E> head;   // Anfang der Liste

    /**
     * {@inheritDoc}
     */
    @Override
    public int size() {
        int count = 0;
        Node<E> current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public E first() {

        if (this.isEmpty() == true) {
            throw new NoSuchElementException("Linked List is Empty");
        }
        return head.data;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addFirst(E newElement) {
        Node<E> newNode = new Node<>(newElement);
        newNode.next = head;
        head = newNode;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public E removeFirst() {
        if (this.isEmpty() == true) {
            throw new NoSuchElementException("Linked List is Empty");
        }
        Node<E> deleted = head;
        Node<E> current = head;
        current = current.next;
        head = current;
        return deleted.data;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public E last() {
        if (this.isEmpty() == true) {
            throw new NoSuchElementException("Linked List is Empty");
        }
        Node<E> current = head;
        while (current.next != null) {
            current = current.next;
        }

        return current.data;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addLast(E newElement) {
        Node<E> newNode = new Node<>(newElement);

        if (head == null) {
            head = newNode;
            return;
        }

        Node<E> current = head;
        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void printList() {
        if (this.isEmpty() == true) {
            throw new NoSuchElementException("Linked List is Empty");
        }
        Node<E> current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public String printListAsString() {

        StringBuilder printList = new StringBuilder();
        boolean status = true; //This will be used to only print "stack is empty". Therefore printlist.append("null") will be ignored --> better readability

        if (this.isEmpty() == true) {
            printList.append("Stack is empty.");
            status = false;
        }
        
        Node<E> current = head;
        while (current != null) {
            printList.append(current.data).append(" -> ");
            current = current.next;
        }

        if (!status) {

        } else {
            printList.append("null");
            
        }
        return printList.toString();
    }
}
