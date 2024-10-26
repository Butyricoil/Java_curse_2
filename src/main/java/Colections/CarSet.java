package Colections;

public interface CarSet extends CarColections {

    boolean add (Car car);
    boolean remove (Car car);
    int size();
    void clear ();
    boolean contains (Car car);

}
