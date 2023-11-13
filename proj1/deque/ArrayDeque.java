package deque;

import java.util.Iterator;

public class ArrayDeque<T> implements Iterable<T>, Deque<T>{
    int size;
    T[] array;
    int first;
    int last;
    public ArrayDeque() {
        array = (T[]) new Object[8];
        size = 0;
        first = 1;
        last = 1;
    }
    public void resize(int s) {
        T[] tmp = (T[]) new Object[s];
        for(int i = 1; i <= size; i += 1) {
            tmp[i] = array[checkindex(first)];
            first += 1;
            }
        first = 1;
        last = size + 1;
        array = tmp;
    }
    /* if an index is beyond the range, return the true index value, else just return */
    public int checkindex(int n) {
        while (n < 0) {
            n += array.length;;
        }
        if (n < 0) {
            return array.length + n;
        }
        while (n >= array.length) {
            n -= array.length;
        }
        return n;
    }
    public void addFirst(T item) {
        if (size == array.length) {
            resize(array.length * 2);
        }
        first -= 1;
        array[checkindex(first)] = item;
        size += 1;
    }
    public void addLast(T item) {
        if (size == array.length) {
            resize(array.length * 2);
        }
        array[checkindex(last)] = item;
        size += 1;
        last += 1;
    }

    public int size() {
        return size;
    }
    /* check whether resize the array after remove one element. */
    public void checksize() {
        if (size * 1.0 / array.length < 0.25 && array.length >= 16 ) {
            resize(array.length / 2);
        }
    }
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        T removed = array[checkindex(first)];
        array[checkindex(first)] = null;
        size -= 1;
        first += 1;
        checksize();
        return removed;
    }
     public T removeLast() {
         if (size == 0) {
             return null;
         }
        T removed = array[checkindex(last - 1)];
        array[checkindex(last - 1)] = null;
        last -= 1;
        size -= 1;
        checksize();
        return removed;
     }

     public T get(int index) {
        if (index < array.length){
            return array[checkindex(first + index)];
        } else {
            return null;
        }
     }
     public void printDeque() {

            int n = first;
            for (int i = 0; i < size; i += 1) {
                System.out.print(array[checkindex(n)]);
                if (i != size - 1) {
                    System.out.print(" ");
                }
                n += 1;
            }
         System.out.println();
     }
     /*
     Iterator for ArrayDeque
      */
    public Iterator<T> iterator() {
        return new IteratorBuilder();
    }
    private class IteratorBuilder implements Iterator {
        public int pos;
        public IteratorBuilder() {
            pos = 0;
        }
        public boolean hasNext() {
            return pos < size;
        }
        public T next() {
            T returnitem = get(pos);
            pos += 1;
            return returnitem;
        }
    }

    /*  Equals method for ArrayDeque
        1 same ArrayDeque should be equal.
        2 different ArrayDeque with same elements in same order should be equal.
        3 otherwise should be not equal.

     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o instanceof ArrayDeque) {
            ArrayDeque<T>  other = (ArrayDeque<T>) o;
            if (this.size == other.size) {
                for (int i = 0; i < size; i += 1) {
                    if (this.get(i) != other.get(i)) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

}