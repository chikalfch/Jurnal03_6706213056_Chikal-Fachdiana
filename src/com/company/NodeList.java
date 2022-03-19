package com.company;

public class NodeList<E> {
  E data;
  NodeList<E> next;

    public NodeList(E object) {
        data = object;
        this.next = null;
    }
    public E getData() {
        return data;
    }
}
