package deque;

import net.sf.saxon.functions.Minimax;


public class MaxArrayDeque<T> extends ArrayDeque<T>{
    Comparator<T> cmpt;
    public MaxArrayDeque(Comparator<T> c) {
        cmpt = c;
    }
    public T max() {
        T returnitem = null;
        for(int i = 0; i < size; i += 1) {
            if(cmpt.compareTo(returnitem, get(i)) <= 0) {
                returnitem = get(i);
            }
        }
        return returnitem;
    }
    public T max(Comparator<T> c) {
        T returnitem = null;
        for (int i = 0; i < size; i += 1) {
            if(c.compareTo(returnitem, get(i)) <= 0) {
                returnitem = get(i);
            }
        }
        return returnitem;
    }
}
