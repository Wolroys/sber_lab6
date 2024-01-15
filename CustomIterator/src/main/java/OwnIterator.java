import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class OwnIterator implements Iterator<Object> {

    private Object[] arr;
    private int position = 0;

    public OwnIterator(Object[] arr) {
        this.arr = arr;
    }

    @Override
    public boolean hasNext() {
        return position < arr.length;
    }

    @Override
    public Object next() {
        if (!hasNext())
            throw new NoSuchElementException();
        return arr[position++];
    }

    @Override
    public void remove() {
        if (position <= 0) {
            throw new IllegalStateException();
        }
        int index = position - 1;
        Object[] newArray = new Object[arr.length - 1];
        System.arraycopy(arr, 0, newArray, 0, index);
        System.arraycopy(arr, index + 1, newArray, index, arr.length - index - 1);
        arr = newArray;
        position--;
    }

    @Override
    public void forEachRemaining(Consumer<? super Object> action) {
        while (hasNext())
            action.accept(next());
    }
}
