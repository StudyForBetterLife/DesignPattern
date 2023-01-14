package iterator.iter;

/**
 * java.util.Iterator 와 구성요소가 거의 동일
 */
public interface Iterator<T> {
    boolean hasNext();

    T next();
}
