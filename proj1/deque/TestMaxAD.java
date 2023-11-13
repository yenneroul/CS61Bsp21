package deque;

import org.junit.Test;
import static org.junit.Assert.*;
public class TestMaxAD {
    /* return biggest integer in Maxarray */
    @Test
    public void returnbiggest() {
        Comparator<Integer> biggestcmp = new Biggest<>();
        MaxArrayDeque<Integer> maxarray = new MaxArrayDeque<>(biggestcmp);
        for (int i = 0; i < 1000; i += 1) {
            maxarray.addLast(i);
        }
        assertTrue(999 == maxarray.max());
    }
}
