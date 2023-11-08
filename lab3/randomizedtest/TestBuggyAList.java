package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import timingtest.AList;

import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE
    @Test
    public void testThreeAddThreeRemove() {
        /* creat a full Alist for both NoResizing and BuggyAList */
        AListNoResizing<Integer> noresizing = new AListNoResizing<>();
        BuggyAList<Integer> buggy = new BuggyAList<>();
        for(int i = 0; i < noresizing.size(); i += 1) {
            noresizing.addLast(i);
            buggy.addLast(i);
        }
        /* add three (3, 4, 5) to the end of both buggy and noresizing */
        for(int i = 3; i < 6; i += 1) {
            noresizing.addLast(i);
            buggy.addLast(i);
        }
        /* Then remove the last three elements in both buggy and noresizing, and test whether true*/
        for(int i = 0; i < 3; i += 1) {
            assertEquals(noresizing.removeLast(), buggy.removeLast());
        }
    }
    @Test
    public void randomizedTest() {
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> B = new BuggyAList<>();
        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 3);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                B.addLast(randVal);
            } else if (operationNumber == 1) {
                // size
                int Lsize = L.size();
                int Bsize = B.size();
                assertEquals(Lsize, Bsize);
            }
            else {
                if(L.size() != 0) {
                    int Lremove = L.removeLast();
                    int Bremove = B.removeLast();
                    assertEquals(Lremove, Bremove);
                }
            }
        }
    }

}
