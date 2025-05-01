package at.fhj.msd;

public class MySinglyLinkedList {
      private Node head;   

    public int size() 
    {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public String first() {
        return head.data;
    }
    
    public void addFirst(String newString) {
        Node newNode = new Node(newString);
        newNode.next = head;
        head = newNode;
    }

    public String removeFist() {
        Node deleted = head;
        Node current = head;
        current = current.next;
        head = current;
        return deleted.data;
    }

    public String last()
    {
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }

        return current.data;
    }

    public void addLast(String newString) {
        Node newNode = new Node(newString);

        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
    }

    // Drucke die gesamte Liste
    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}
