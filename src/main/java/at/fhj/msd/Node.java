package at.fhj.msd;

public class Node<E> {
     public E data;       // Daten des Knotens
     public Node<E> next;      // Referenz auf den nächsten Knoten
     public Node<E> prev;      // Referenz auf den vorherigen Knoten (für DoubleLinkedList)

    public Node(E data) {
        this.data = data;
        this.next = null;
        this.prev = null; // Initialisierung der vorherigen Referenz
    }

   


}
