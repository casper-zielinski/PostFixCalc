package at.fhj.msd;

public class MyLinkedList {
      private Node head;   // Anfang der Liste
      private Node tail;   // Ende der Liste

      public void append(String data) {
          Node newNode = new Node(data);
          if (head == null) {
              head = newNode;
              tail = newNode;
          } else {
              tail.next = newNode;
              newNode.prev = tail;
              tail = newNode;
          }
      }

      public void previous() {
          Node current = tail;
          while (current != null) {
              System.out.print(current.data + " <- ");
              current = current.prev;
          }
          System.out.println("null");
      }

}
