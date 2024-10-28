package telran.interview;
import java.util.HashMap;

public class MyArray<T> { 
    private int size;
    private T value;
    private HashMap<Integer, T> newValues = new HashMap<>();

    public MyArray(int size) {
        this.size = size;        
        }    

    public void setAll(T value) {
        this.value = value;
        this.newValues = new HashMap<>();
    }

    private void checkIndex(int index) {
        if (index < 0 || index > size - 1) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public void set(int index, T value) {
        checkIndex(index);
        this.newValues.put(index, value);
    }

    public T get(int index) {
        checkIndex(index);        
        return newValues.getOrDefault(index, value);
    }
 }


