package Collections;

public interface CarList {
    Car ger(int index);
    void add(Car car);
    boolean remove(Car car);
    boolean removeAt(int index);
    int size();
    void clear();
}
