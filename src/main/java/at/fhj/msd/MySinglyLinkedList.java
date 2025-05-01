package at.fhj.msd;

/**
 * A simple implementation of a singly linked list.
 * This class provides methods to manipulate the linked list, including adding, removing, and retrieving elements
 * as well as checking its size and whether it is empty and printing the list.
 * The list is composed of nodes, each containing a string data and a reference to the next node.
 * @param <E> the type of elements in the linked list.
 * @see Node
 */
public class MySinglyLinkedList<E> {
      private Node<E> head;   // Anfang der Liste

    /**
     * The size method calculates the number of elements in the linked list.
     * It iterates through the list, counting each node until it reaches the end (null).
     * @return the number of elements in the list.
     */
    public int size() 
    {
        int count = 0;
        Node<E> current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    /**
     * Checks if the linked list is empty.
     * An empty list has no nodes, meaning the head is null.
     * @return true if the list is empty, false otherwise.
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * The first method returns the first element of the linked list.
     * It retrieves the data from the head node. The head node is the first node in the list.
     * So it just returns the data of the head node.
     * @return the data of the first node in the list.
     */
    public E first() {
        return head.data;
    }
    
    /**
     * Adds a new string to the beginning of the linked list.
     * A new node is created with the provided string, and it becomes the new head of the list.
     * The previous head becomes the second node in the list.
     * @param newElement the Datatype to be added to the list.
     * @param <E> the type of the element to be added.
     */
    public void addFirst(E newElement) {
        Node<E> newNode = new Node<>(newElement);
        newNode.next = head;
        head = newNode;
    }

    /**
     * Removes the first element from the linked list.
     * The head node is removed, and the next node becomes the new head.
     * @return the data of the removed node.
     */
    public E removeFist() {
        Node<E> deleted = head;
        Node<E> current = head;
        current = current.next;
        head = current;
        return deleted.data;
    }

    /**
     * The last method returns the last element of the linked list.
     * It iterates through the list until it reaches the last node (where next is null).
     * @return the data of the last node in the list.
     */
    public E last()
    {
        Node<E> current = head;
        while (current.next != null) {
            current = current.next;
        }

        return current.data;
    }

    /**
     * Adds a new Element to the end of the linked list.
     * A new node is created with the provided Element, and it is added after the last node in the list.
     * If the list is empty, the new node becomes the head.
     * @param newElement the Datatype to be added to the list.
     * @param <E> the type of the element to be added.
     */
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
     * printList method prints the elements of the linked list in order.
     * It starts from the head and iterates through each node, printing the data until it reaches the end (null).
     * It also prints a " -> " between each element to indicate the link between nodes.
     * Finally, it prints "null" to indicate the end of the list.
     */
    public void printList() {
        Node<E> current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}
