package gb_collections.Lists;

import gb_collections.GbList;

import java.util.Iterator;

import java.util.Iterator;

public class GbLinkedList<E> implements GbList<E> {
    private Node<E> head;
    private int size;

    public GbLinkedList() {
        head = null;
        size = 0;
    }

    @Override
    public void add(E value) {
        if (head == null) {
            head = new Node<>(value);
        } else {
            Node<E> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new Node<>(value);
        }
        size++;
    }

    @Override
    public void add(int index, E value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        if (index == 0) {
            head = new Node<>(value, head);
        } else {
            Node<E> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = new Node<>(value, current.next);
        }
        size++;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.value;
    }

    @Override
    public void remove(E value) {
        if (head == null) {
            return;
        }
        if (head.value.equals(value)) {
            head = head.next;
            size--;
            return;
        }
        Node<E> current = head;
        while (current.next != null) {
            if (current.next.value.equals(value)) {
                current.next = current.next.next;
                size--;
                return;
            }
            current = current.next;
        }
    }

    @Override
    public void removeByIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        if (index == 0) {
            head = head.next;
        } else {
            Node<E> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
        }
        size--;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<E> iterator() {
        return new LinkedListIterator();
    }

    private static class Node<E> {
        E value;
        Node<E> next;

        Node(E value) {
            this.value = value;
            this.next = null;
        }

        Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }

    private class LinkedListIterator implements Iterator<E> {
        private Node<E> current;

        LinkedListIterator() {
            current = head;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            E value = current.value;
            current = current.next;
            return value;
        }
    }
}
