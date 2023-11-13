package deque;

public class Biggest<T> implements Comparator<T>{
    @Override
    public int compareTo(Object o1, Object o2) {
        if (o1 == null) {
            return 0;
        }
        if (o2 == null) {s
            return 1;
        }
        return (Integer) o1 - (Integer) o2;
    }
}
