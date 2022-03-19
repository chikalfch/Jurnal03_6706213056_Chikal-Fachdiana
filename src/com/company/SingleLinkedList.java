package com.company;

import java.util.NoSuchElementException;

public class SingleLinkedList<E> {
    private NodeList<E> firstNode;
    private NodeList<E> lastNode;
    private String nama;

    public SingleLinkedList(String listNama) {
        nama = listNama;
        firstNode = lastNode = null;
    }
    public void insertAtFront(E insertItem) {
        NodeList newNode = new NodeList(insertItem);
        if (isEmpty()) {     //firstNode and lastNode untuk object yang sama
            firstNode = lastNode = new NodeList<E>(insertItem);
        } else {  // newNode is firstNode
            newNode.next = firstNode;
            firstNode = newNode;
        }
    }
        public void insertAtBack(E insertItem)  {
            NodeList newNode = new NodeList(insertItem);
            if(isEmpty()) { //firstNode and lastNode untuk object yang sama
                firstNode = lastNode = new NodeList<E>(insertItem);
            } else {    // lastNode is newNode
                lastNode.next = newNode;
                lastNode = newNode;
            }
        }
        public E removeFromFront() throws NoSuchElementException {
            if(isEmpty()) {      // throw exception for isEmpty
                throw new NoSuchElementException(nama + " is empty");
            }
            E removedItem = firstNode.data; // kembalikan data yang diremove

            NodeList current = firstNode;
            firstNode = firstNode.next;
            current = null;

             return removedItem; // kembalikan removed node Data
        }

    public E removeFromBack() throws NoSuchElementException {
        if(isEmpty()) {      // throw exception for isEmpty
            throw new NoSuchElementException(nama + " is empty");
        }
        E removedItem = lastNode.data; // kembalikan data yang diremove

       if(firstNode == lastNode) {
           firstNode = lastNode = null;
       } else { // lokasi baru lastNode
           NodeList<E> current = firstNode;
           while (current.next != lastNode) {   // while loop current node not lastNode
               current = current.next;
           }
           lastNode = current;      // current adalah lastNode
           current.next = null;
       }
        return removedItem;     // kembalikan removed node Data
    }
    private boolean isEmpty() { return firstNode == null; }
    public void print() {
        if (isEmpty()) {
            System.out.printf("Empty %s%n", nama);
            return;
        }
        System.out.printf("List %s adalah: %n", nama);
        NodeList<E> current = firstNode;
        while (current != null) {
            System.out.printf("%s ", current.data);
            current = current.next;
        }
        System.out.println();
    }
}