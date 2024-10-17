package MyLinkedList;
import Collections.MyArrayList.Car;
import Collections.MyArrayList.CarList;

public class CarLinkedList implements CarList {

    @Override
    public Car get(int index) {
        return null;
    }

    @Override
    public void add(Car car) {

    }

    @Override
    public void add(Car car, int index) {

    }

    @Override
    public boolean remove(Car car) {
        return false;
    }

    @Override
    public boolean removeAt(int index) {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void clear() {
    }

    private static class Node {
        private Node previos;
        private Car value;
        private Node next;
    }
}
