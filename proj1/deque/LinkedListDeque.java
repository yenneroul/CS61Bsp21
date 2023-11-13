package deque;

import jh61b.junit.In;
import net.sf.saxon.functions.ConstantFunction;

import java.util.Iterator;

public class LinkedListDeque<T> implements Iterable<T>, Deque<T>{
    public class Box {
        T items;
        Box next;
        Box prev;
        public Box(T item, Box p, Box n) {
            items = item;
            prev = p;
            next = n;
        }
    }

    public int size;
    public Box sentinel;
    public LinkedListDeque() {
        sentinel = new Box(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
    }

    public void addFirst(T item) {
        sentinel.next.prev = new Box(item, sentinel, sentinel.next);
        sentinel.next = sentinel.next.prev;
        size += 1;
    }
    public void addLast(T item) {
        sentinel.prev.next = new Box(item, sentinel.prev, sentinel);
        sentinel.prev = sentinel.prev.next;
        size += 1;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        Box p = sentinel.next;
        for (int i = 1; i <= size; i += 1) {
            System.out.print(p.items);
            if (i == size) {
                System.out.println();
            } else {
                System.out.print(" ");
            }
            p = p.next;
        }
    }

    public T removeFirst() {
        T removed = sentinel.next.items;
        if (removed == null) {
            return null;
        }
        sentinel.next.next.prev = sentinel;
        sentinel.next = sentinel.next.next;
        size -= 1;
        return removed;
    }

    public T removeLast() {
        T removed = sentinel.prev.items;
        if (removed == null) {
            return null;
        }
        sentinel.prev.prev.next = sentinel;
        sentinel.prev = sentinel.prev.prev;
        size -= 1;
        return removed;
    }

    public T get(int index) {
        if (index > size) {
            return null;
        } else{
            Box p = sentinel.next;
            for(int i = 0; i < index; i += 1) {
                p = p.next;
            }
            return p.items;
        }
    }

    /* use recursive to get the indexth items. */
    private T Recursive(int index, Box p) {
        if (index == 0) {
            return p.items;
        } else {
            return Recursive(index - 1, p.next);
        }
    }
    public T getRecursive(int index) {
        if (index > size) {
            return null;
        } else {
            return Recursive(index, sentinel);
        }
    }
    /* Iterator for linked list */
    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }
    /* Helper method for iterator */
    private class LinkedListIterator implements Iterator{
        public int pos;
        public LinkedListIterator() {
            pos = 0;
        }
        public boolean hasNext(){
            if (pos >= size) {
                return false;
            }
            else {
                return true;
            }
        }
        public T next() {
            T returnitem = get(pos);
            pos += 1;
            return returnitem;
        }
    }
    /* override equals method for Linked list */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o instanceof LinkedListDeque) {
            LinkedListDeque<T> oll = (LinkedListDeque<T>) o;
            if (oll.size == this.size) {
                for(int i = 0; i < size; i += 1) {
                    if(!this.get(i).equals(oll.get(i))) {
                        return false;
                    }
                    return true;
                }
            }
        }
        return false;
    }
}