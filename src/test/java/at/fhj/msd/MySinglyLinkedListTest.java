package at.fhj.msd;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MySinglyLinkedListTest {

      MySinglyLinkedList list;

      @BeforeEach
      void setup()
      {
            list = new MySinglyLinkedList();
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
            list.addFirst("1");
            list.addFirst("2");
            list.removeFist();
            assertEquals(1, list.size());
            list.removeFist();
            assertEquals(true, list.isEmpty());
      }

      @Test
      @DisplayName("Single LinkedList Last Test")
      void LastTest() {
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
