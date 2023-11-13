package deque;

import org.junit.Test;
import static org.junit.Assert.*;
import edu.princeton.cs.algs4.StdRandom;

import java.lang.reflect.Array;
import java.util.Iterator;

public class ArrayDequeTest {
    @Test
    public void AddThreeRemoveThree() {
        ArrayDeque<Integer> test = new ArrayDeque<>();
        test.addFirst(2);
        test.addFirst(1);
        test.addLast(3);
        int removed1 = test.removeFirst();
        int removed2 = test.removeFirst();
        int remove3 = test.removeLast();
        assertEquals(1, removed1);
        assertEquals(2, removed2);
        assertEquals(3, remove3);
    }

    @Test
    public void Testresize() {
        ArrayDeque<Integer> test = new ArrayDeque<>();
        for (int i = 0; i < 10; i++) {
            test.addFirst(i);
        }
        int first = test.get(9);
        assertEquals(0, first);
    }

    @Test
    public void AddMuchNumsAndRemove() {
        ArrayDeque<Integer> test = new ArrayDeque<>();
        for (int i = 0; i < 16; i++) {
            test.addFirst(i);
        }
        int fisrt = test.get(0);
        assertEquals(15, fisrt);
        for (int i = 0; i < 15; i++) {
            test.removeLast();
        }
        fisrt = test.get(0);
        assertEquals(15, fisrt);

    }

    @Test
    public void printarray() {
        ArrayDeque<Integer> test = new ArrayDeque<>();
        for (int i = 0; i < 16; i++) {
            test.addFirst(i);
        }
        test.printDeque();
        for (int i = 0; i < 8; i++) {
            test.removeLast();
        }
        test.printDeque();
    }

    @Test
    /* ramdom test compare whth LinkedListDeque */
    public void comparetest() {
        ArrayDeque<Integer> array = new ArrayDeque<>();
        LinkedListDeque<Integer> linklist = new LinkedListDeque<>();
        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 6);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                linklist.addLast(randVal);
                array.addLast(randVal);
            } else if (operationNumber == 1) {
                // size
                int listsize = linklist.size();
                int arraysize = array.size();
                assertEquals(listsize, arraysize);
            }
            /* add first */
            else if (operationNumber == 2) {
                int randVal = StdRandom.uniform(0, 100);
                linklist.addFirst(randVal);
                array.addFirst(randVal);
            } else if (operationNumber == 3) {
                assertEquals(linklist.removeFirst(), array.removeFirst());
            } else if (operationNumber == 4) {
                int randVal = StdRandom.uniform(0, 20);
                assertEquals(linklist.get(randVal), array.get(randVal));
            } else {
                assertEquals(linklist.removeLast(), array.removeLast());
            }
        }
    }
    /* Test for ArrayDeque iterator constructor, hasNext, next method.
     */

    @Test
    public void TestIterator() {
        ArrayDeque<Integer> testarray = new ArrayDeque<>();
        for (int i = 0; i < 10; i += 1) {
            testarray.addLast(i);
        }
        Iterator<Integer> testit = testarray.iterator();
        for (int i = 0; i < 10; i += 1) {
            assertEquals(testarray.get(i), testit.next());
        }
        for (int i = 0; i < 9; i += 1) {
            testarray.removeLast();
        }
        Iterator<Integer> lastit = testarray.iterator();
        assertEquals(testarray.get(0), lastit.next());
    }

    /*
    Test same

     */
    static void samearray() {
        ArrayDeque<Integer> testarray = new ArrayDeque<>();
        for (int i = 0; i < 10; i += 1) {
            testarray.addLast(i);
        }
        ArrayDeque<Integer> copy = testarray;
        assertTrue(testarray.equals(copy));
    }
    /*      Test same value is equal


     */

    @Test
    public void samevalue() {
        ArrayDeque<Integer> testarray = new ArrayDeque<>();
        ArrayDeque<Integer> samevalue = new ArrayDeque<>();
        ArrayDeque<Integer> diffvalue = new ArrayDeque<>();
        ArrayDeque<Integer> difflength = new ArrayDeque<>();
        ArrayDeque<String> difftype = new ArrayDeque<>();
        for (int i = 0; i < 10; i ++) {
            testarray.addLast(i);
            samevalue.addLast(i);
            diffvalue.addLast(i + 1);
        }
        for (int i = 0; i < 20; i += 1) {
            difflength.addLast(i);
        }
        difftype.addLast("this");
        difftype.addLast("is");
        difftype.addLast("a");
        difftype.addLast("test");
        difftype.addLast("array");
        difftype.addLast("test");
        difftype.addLast("different");
        difftype.addLast("type");
        difftype.addLast("is");
        difftype.addLast("different");
        /*
        Test same value is TRUE
         */
        assertTrue(testarray.equals(samevalue));
        /*
            different value is FALSE
         */
        assertFalse(testarray.equals(diffvalue));
        /*
        different length is FALSE
         */
        assertFalse(testarray.equals(difflength));
        /*
        different type is FALSE
         */
        assertFalse(testarray.equals(difftype));
    }
}