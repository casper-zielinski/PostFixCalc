package at.fhj.msd;

import java.util.NoSuchElementException;

public class MyDoublyLinkedList<E> {

    private Node<E> head;
    private Node<E> tail;

    /**
     * The size method calculates the number of elements in the linked list. It
     * iterates through the list, counting each node until it reaches the end
     * (null).
     *
     * @return the number of elements in the list.
     */
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
     * Checks if the linked list is empty. An empty list has no nodes, meaning
     * the head is null.
     *
     * @return true if the list is empty, false otherwise.
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * The first method returns the first element of the linked list. It
     * retrieves the data from the head node. The head node is the first node in
     * the list. So it just returns the data of the head node.
     *
     * @return the data of the first node in the list.
     */
    public E first() {

        if (isEmpty()) {
            throw new NoSuchElementException("The list is empty!");
        }

        return head.data;
    }

    /**
     * Adds a new string to the beginning of the linked list. A new node is
     * created with the provided string, and it becomes the new head of the
     * list. The previous head becomes the second node in the list.
     *
     * @param newElement the Datatype to be added to the list.
     * @param <E> the type of the element to be added.
     */
    public void addFirst(E newElement) {

        Node<E> newNode = new Node<>(newElement);

        if (head == null) {
            // Liste war leer
            head = newNode;
            tail = newNode;
            return;
        }

        newNode.next = head;
        head.prev = newNode;
        head = newNode;

    }

    /**
     * Removes the first element from the linked list. The head node is removed,
     * and the next node becomes the new head.
     *
     * @return the data of the removed node.
     */
    public E removeFirst() {

        if (isEmpty()) {
            throw new NoSuchElementException("The list is empty!");
        }

        Node<E> deleted = head;
        Node<E> current = head;
        current = current.next;
        head = current;
        return deleted.data;
    }

    public E last() {

        if (isEmpty()) {
            throw new NoSuchElementException("The list is empty!");
        }

        tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }

        return tail.data;
    }

    public void addLast(E newElement) {

        Node<E> newNode = new Node<>(newElement);

        if (head == null) {
            head = newNode;
            tail = newNode;
            return;
        }

        tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }

        tail.next = newNode;
        newNode.prev = tail;

        tail = newNode;

    }

    public void printList() {

        if (isEmpty()) {
            throw new NoSuchElementException("The list is empty!");
        }

        Node<E> current = head;
        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.next;
        }
        System.out.println("null");
    }

}
