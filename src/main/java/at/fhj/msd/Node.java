package at.fhj.msd;

public class Node {
     public String data;       // Daten des Knotens
     public Node next;      // Referenz auf den nächsten Knoten
     public Node prev;      // Referenz auf den vorherigen Knoten (für DoubleLinkedList)

    public Node(String data) {
        this.data = data;
        this.next = null;
        this.prev = null; // Initialisierung der vorherigen Referenz
    }

   


}
