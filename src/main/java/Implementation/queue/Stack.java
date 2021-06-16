package Implementation.queue;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class Stack<Item> implements Iterable<Item> {

    private Node top;
    private int indexlength;

    private class Node {
        Item item;
        Node next;
    }

    public Stack() {
    }

    public void push(Item item) {
        Node oldfirst = top;
        top = new Node();
        top.item = item;
        top.next = oldfirst;
        indexlength++;
    }

    public Item pop() {
        Item item = top.item;
        top = top.next;
        indexlength--;
        return item;
    }

    public boolean IsEmpty() {
        return top == null;
    }

    public int size() {
        return indexlength;
    }

    public Iterator<Item> iterator() {
        return new ListIteratorNodes();
    }

    private class ListIteratorNodes implements Iterator<Item> {
        private Node current = top;

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
        }

        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    public void forEach(Consumer<? super Item> action) {

    }

    public Spliterator<Item> spliterator() {
        return null;
    }
}
