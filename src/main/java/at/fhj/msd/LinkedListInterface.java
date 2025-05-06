package at.fhj.msd;

/**
 * An interface for a simple linked list data structure.
 * This interface provides methods to manipulate the linked list, including adding, removing, and retrieving elements,
 * as well as checking its size, whether it is empty, and printing the list.
 * The list is composed of nodes, each containing data and a reference to the next node in the list.
 * 
 * @param <E> the type of elements in the linked list.
 * @see Node
 */
public interface LinkedListInterface<E> {

    /**
     * The size method calculates the number of elements in the linked list.
     * It iterates through the list, counting each node until it reaches the end (null).
     * @return the number of elements in the list.
     */
    int size();

    /**
     * Checks if the linked list is empty.
     * An empty list has no nodes, meaning the head is null.
     * @return true if the list is empty, false otherwise.
     */
    boolean isEmpty();

    /**
     * The first method returns the first element of the linked list.
     * It retrieves the data from the head node. The head node is the first node in the list.
     * So it just returns the data of the head node.
     * @return the data of the first node in the list.
     */
    E first();

    /**
     * Adds a new string to the beginning of the linked list.
     * A new node is created with the provided string, and it becomes the new head of the list.
     * The previous head becomes the second node in the list.
     * @param newElement the Datatype to be added to the list.
     * @param <E> the type of the element to be added.
     */
    void addFirst(E newElement);

    /**
     * Removes the first element from the linked list.
     * The head node is removed, and the next node becomes the new head.
     * @return the data of the removed node.
     */
    E removeFirst();

    /**
     * The last method returns the last element of the linked list.
     * It iterates through the list until it reaches the last node (where next is null).
     * @return the data of the last node in the list.
     */
    E last();

    /**
     * Adds a new Element to the end of the linked list.
     * A new node is created with the provided Element, and it is added after the last node in the list.
     * If the list is empty, the new node becomes the head.
     * @param newElement the Datatype to be added to the list.
     * @param <E> the type of the element to be added.
     */
    void addLast(E newElement);

    /**
     * printList method prints the elements of the linked list in order.
     * It starts from the head and iterates through each node, printing the data until it reaches the end (null).
     * It also prints a " -> " between each element to indicate the link between nodes.
     * Finally, it prints "null" to indicate the end of the list.
     */
    void printList();
}