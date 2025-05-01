package at.fhj.msd;

import java.util.ArrayList;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        MySinglyLinkedList<String> list = new MySinglyLinkedList<>();

        list.addLast("10");
        list.addLast("20");
        list.addFirst("5");
        System.out.println("Size of the list: " + list.size()); // Ausgabe: 3
      

        list.printList();  // Ausgabe: 10 -> 20 -> 30 -> null
        System.out.println(list.first());
        list.removeFist();
        list.printList();
        System.out.println(list.last());
        

            }
        }
