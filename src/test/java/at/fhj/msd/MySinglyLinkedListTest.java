package at.fhj.msd;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.NoSuchElementException;

import org.apache.logging.log4j.CloseableThreadContext;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MySinglyLinkedListTest {

      MySinglyLinkedList<String> list;

      @BeforeEach
      @DisplayName("Single LinkedList Setup")
      public void setup()
      {
            list = new MySinglyLinkedList<>();
      }

      @Test
      @DisplayName("Single LinkedList size Test")
      void SizeTest()
      {
            list.addFirst("1");
            list.addFirst("2");
            list.addFirst("3");
            list.addFirst("4");

            assertEquals(4, list.size());

      }

      @Test
      @DisplayName("Single LinkedList Empty Test")
      void isEmptyTest()
      {
            assertEquals(true, list.isEmpty());
            list.addFirst("1");
            assertEquals(false, list.isEmpty());
      }

      @Test
      @DisplayName("Single LinkedList First Test")
      void FirstTest(){
            list.addFirst("1");
            list.addLast("10");
            list.addFirst("das erste");
            list.addFirst("wirklich das erste");
            list.addLast("1");
            assertEquals("wirklich das erste", list.first());
      }

      @Test
      @DisplayName("Single LinkedList Remove First Test")
      void RemoveFirst() {
            assertThrows(NoSuchElementException.class, () -> {list.first();}   );
            assertThrows(NoSuchElementException.class, () -> {list.removeFirst();}   );
            list.addFirst("1");
            list.addFirst("2");
            list.removeFirst();
            assertEquals(1, list.size());
            list.removeFirst();
            assertEquals(true, list.isEmpty());
      }

      @Test
      @DisplayName("Single LinkedList Last Test")
      void LastTest() {
            assertThrows(NoSuchElementException.class, () -> {list.last();}   );
            list.addFirst("1");
            list.addFirst("2");
            list.addFirst("3");
            assertEquals("1", list.last());
      }

      @Test
      @DisplayName("Single LinkedList Add Last Test")
      void AddLastTest() {
            list.addFirst("1");
            list.addLast("2");
            list.addFirst("3");
            assertEquals("2", list.last());
      }

      @Test
      @DisplayName("Single Empty LinkedList Add Last Test")
      void AddLastTesttoEmpty() {
            list.addLast("1");
            assertEquals("1", list.first());
            assertEquals("1", list.last());
      }

      @Test
      @DisplayName("Single LinkedList Print Test")
      void PrintTest() {
            assertThrows(NoSuchElementException.class, () -> {list.printList();} );
            list.addFirst("1");
            list.addLast("2");
            list.addLast("3");

            ByteArrayOutputStream output = new ByteArrayOutputStream();
            PrintStream originalOut = System.out;
            System.setOut(new PrintStream(output));

            list.printList();

            System.setOut(originalOut);

            String outputContent = output.toString().trim();

            assertEquals("1 -> 2 -> 3 -> null", outputContent);
      }     


}