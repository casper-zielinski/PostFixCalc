package at.fhj.msd;

import java.util.NoSuchElementException;


/**
 * A doubly linked list implementation that follows the {@link LinkedListInterface}.
 * This class supports operations for manipulating the linked list, such as adding, removing, and retrieving elements,
 * as well as checking the size, whether the list is empty, and printing the list.
 * Each node contains references to both the next and the previous node, allowing traversal in both directions.
 *
 * @param <E> the type of elements in the linked list.
 * @see LinkedListInterface
 * @see Node
 */

public class MyLinkedList<E> implements LinkedListInterface<E> {

    private Node<E> head;
    private Node<E> tail;

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

        if (this.isEmpty()) {
            throw new NoSuchElementException("The list is empty!");
        }

        return head.data;
    }

     /**
     * Adds a new element to the beginning of the list.
     * This method creates a new node, sets its `next` reference to the current head, 
     * and then updates the head of the list to be the new node. 
     * If the list was empty, both the `head` and `tail` will point to the new node.
     * 
     * <p>Unlike the singly linked list, this doubly linked list also updates the `prev` reference 
     * of the new head node to be `null` and the `prev` reference of the old head node is updated to 
     * point to the new head.</p>
     * 
     * @param newElement the element to be added to the beginning of the list.
     */
    @Override
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
     * {@inheritDoc}
     */
    @Override
    public E removeFirst() {

        if (this.isEmpty()) {
            throw new NoSuchElementException("The list is empty!");
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

        if (this.isEmpty()) {
            throw new NoSuchElementException("The list is empty!");
        }

        tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }

        return tail.data;
    }

    /**
     * Adds a new element to the end of the list.
     * This method traverses the list to find the last node and then updates its `next` reference
     * to point to the new node. It also updates the `prev` reference of the new node to point to
     * the old tail node. If the list was empty, both the `head` and `tail` will point to the new node.
     * 
     * <p>Unlike the singly linked list, this doubly linked list uses the `prev` pointer of the tail 
     * node to link the new node back to the previous last node.</p>
     * 
     * @param newElement the element to be added to the end of the list.
     */
    @Override
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

    /**
     * Removes the last element from the list.
     * This method removes the last node by updating the `tail` reference to its `prev` node. 
     * If the list becomes empty, it updates both `head` and `tail` to `null`.
     * 
     * <p>In the doubly linked list, the `prev` pointer of the new tail node is updated to `null` 
     * while the `next` pointer of the old tail is disconnected. If the list is empty after removal, 
     * both the head and tail references are set to `null`.</p>
     * 
     * @return the data of the removed node.
     */

    public E removeLast()
    {
        if (isEmpty())
        {
            throw new NoSuchElementException("The list is empty!");
        }

        Node <E> deleted = tail;
        tail = tail.prev;

        if (tail != null) {
            tail.next = null;
        } else {
            head = null; // Liste ist jetzt leer
        }
        
        return deleted.data;

    }

    /**
     * {@inheritDoc}
     */
    @Override
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
