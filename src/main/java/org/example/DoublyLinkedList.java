
package org.example;

/**
 *
 * @author MoaathAlrajab
 */
class Node {
   public int data;
   public Node next;
   public Node previous;

   public Node(int initialData) {
      data = initialData;
      next = null;
      previous = null;
   }
}

public class DoublyLinkedList {
   private Node head;
   private Node tail;

   public DoublyLinkedList() {
      head = null;
      tail = null;
   }

   public void append(Node newNode) {
      if (head == null) {
         head = newNode;
         tail = newNode;
      } else {
         tail.next = newNode;
         newNode.previous = tail;
         tail = newNode;
      }
   }

   public void prepend(Node newNode) {
      if (head == null) {
         head = newNode;
         tail = newNode;
      } else {
         newNode.next = head;
         head.previous = newNode;
         head = newNode;
      }
   }

   public void printList() {
      Node node = head;
      while (node != null) {
         System.out.print(node.data + " ");
         node = node.next;
      }
      System.out.println();
   }

   public void insertAfter(Node currentNode, Node newNode) {
      if (head == null) {
         head = newNode;
         tail = newNode;
      } else if (currentNode == tail) {
         tail.next = newNode;
         newNode.previous = tail;
         tail = newNode;
      } else {
         Node successor = currentNode.next;
         newNode.next = successor;
         newNode.previous = currentNode;
         currentNode.next = newNode;
         successor.previous = newNode;
      }
   }

   public void remove(Node currentNode) {
      Node successor = currentNode.next;
      Node predecessor = currentNode.previous;

      if (successor != null)
         successor.previous = predecessor;

      if (predecessor != null)
         predecessor.next = successor;

      if (currentNode == head)
         head = successor;

      if (currentNode == tail)
         tail = predecessor;
   }

   public int[] toArray(){
      Node currentNode = head;
      int sizeOfArray = 0;
      int index = 0;
      while(currentNode != null){
         sizeOfArray++;
         currentNode = currentNode.next;
      }
      currentNode = head;
      int[] arr = new int[sizeOfArray];
      while(currentNode != null){
         arr[index] = currentNode.data;
         index++;
         currentNode = currentNode.next;
      }
      return arr;
   }
   public int indexOf(int target){
      Node currentNode = head;
      int index = 0; //array starts at 0
      while(currentNode != null){
         if(currentNode.data == target){//if node is found, return the index
            return index;
         }
         index++;
         currentNode = currentNode.next;
      }
      return -1; //didnt find target
   }

   //}
   public void sumOfAllElements(DoublyLinkedList list){

   }
}
