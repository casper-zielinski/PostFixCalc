package at.fhj.msd;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MyLinkedListTest {

    MyLinkedList<String> list;

    @BeforeEach
    @DisplayName("Doubly LinkedList Setup")
    public void setup() {
        list = new MyLinkedList<>();
    }

    @Test
    @DisplayName("Doubly LinkedList size Test")
    void sizeTest() {

        list.addFirst("1");
        list.addFirst("2");
        list.addFirst("3");
        list.addFirst("4");

        assertEquals(4, list.size());
    }

    @Test
    @DisplayName("Doubly LinkedList Empty Test")
    void isEmptyTest() {
        assertEquals(true, list.isEmpty());
        list.addFirst("1");
        assertEquals(false, list.isEmpty());
    }

    @Test
    @DisplayName("Doubly LinkedList First Test")
    void FirstTest() {
        list.addFirst("1");
        list.addLast("10");
        list.addFirst("das erste");
        list.addFirst("wirklich das erste");
        list.addLast("1");
        assertEquals("wirklich das erste", list.first());
    }

    @Test 
    @DisplayName("Doubly LinkedList First Empty Test")
    void firstEmptyTest() {
        assertThrows(NoSuchElementException.class, () -> {
            list.first();
        });
    }

    @Test
    @DisplayName("Doubly LinkedList Remove First Test")
    void RemoveFirst() {
          list.addFirst("1");
          list.addFirst("2");
          list.removeFirst();
          assertEquals(1, list.size());
          list.removeFirst();
          assertEquals(true, list.isEmpty());
    }

    @Test
    @DisplayName("Double LinkedList Remove First Empty Test")
    void RemoveEmptyFirst() {
        assertThrows(NoSuchElementException.class, () -> {
            list.removeFirst();
        });
    }

    @Test
    @DisplayName("Doubly LinkedList Last Test")
    void LastTest() {
          list.addFirst("1");
          list.addFirst("2");
          list.addFirst("3");
          assertEquals("1", list.last());
    }

    @Test 
    @DisplayName("Doubly LinkedList Last Empty Test")
    void lastEmptyTest() {
        assertThrows(NoSuchElementException.class, () -> {
            list.last();
        });
    }


     @Test
      @DisplayName("Doubly LinkedList Add Last Test")
      void AddLastTest() {
            list.addFirst("1");
            list.addLast("2");
            list.addFirst("3");
            assertEquals("2", list.last());
      }

      @Test
      @DisplayName("Doubly Empty LinkedList Add Last Test")
      void AddLastTesttoEmpty() {
            list.addLast("1");
            assertEquals("1", list.first());
            assertEquals("1", list.last());
      }

      @Test
      @DisplayName("Doubly LinkedList Print Test")
      void PrintTest() {
            list.addFirst("1");
            list.addLast("2");
            list.addLast("3");

            ByteArrayOutputStream output = new ByteArrayOutputStream();
            PrintStream originalOut = System.out;
            System.setOut(new PrintStream(output));

            list.printList();

            System.setOut(originalOut);

            String outputContent = output.toString().trim();

            assertEquals("1 <-> 2 <-> 3 <-> null", outputContent);
      }

     @Test
     @DisplayName("Doubly LinkedList Print Empty Test")
      void printEmptyTest() {
        assertThrows(NoSuchElementException.class, () -> {
            list.printList();
        });
      }

}
