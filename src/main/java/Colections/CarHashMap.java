
package Colections;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarHashMap implements CarMap {

    private static final int INITIAL_CAPACITY = 16;
    private static final float LOAD_FACTOR = 0.75f;

    private Entry[] array = new Entry[INITIAL_CAPACITY];
    private int size = 0;

    @Override
    public void put(CarOwner key, Car value) {
        if (size >= array.length * LOAD_FACTOR) {
            increaseArray();
        }
        boolean putSuccessful = put(key, value, array);
        if (putSuccessful) {
            size++;
        }
    }

    @Override
    public Car get(CarOwner key) {
        int position = getElementPosition(key, array.length);
        Entry existingElement = array[position];
        while (existingElement != null) {
            if (existingElement.key.equals(key)) {
                return existingElement.value;
            }
            existingElement = existingElement.next;
        }
        return null;
    }

    @Override
    public Set<CarOwner> keySet() {
        Set<CarOwner> result = new HashSet<>();
        for (Entry entry : array) {
            Entry existingElement = entry;
            while (existingElement != null) {
                result.add(existingElement.key);
                existingElement = existingElement.next;
            }
        }
        return result;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        array = new Entry[INITIAL_CAPACITY];
        size = 0;
    }

    @Override
    public boolean remove(CarOwner key) {
        int position = getElementPosition(key, array.length);
        Entry existingElement = array[position];
        Entry previousElement = null;
        while (existingElement != null) {
            if (existingElement.key.equals(key)) {
                if (previousElement == null) {
                    array[position] = existingElement.next;
                } else {
                    previousElement.next = existingElement.next;
                }
                size--;
                return true;
            }
            previousElement = existingElement;
            existingElement = existingElement.next;
        }
        return false;
    }

    @Override
    public List<Car> values() {
        List<Car> result = new ArrayList<>();
        for (Entry entry : array) {
            Entry existingElement = entry;
            while (existingElement != null) {
                result.add(existingElement.value);
                existingElement = existingElement.next;
            }
        }
        return result;
    }

    private void increaseArray() {
        Entry[] newArray = new Entry[array.length * 2];
        for (Entry entry : array) {
            Entry existingElement = entry;
            while (existingElement != null) {
                put(existingElement.key, existingElement.value, newArray);
                existingElement = existingElement.next;
            }
        }
        array = newArray;
    }

    private boolean put(CarOwner key, Car value, Entry[] dst) {
        int position = getElementPosition(key, dst.length);
        Entry existingElement = dst[position];
        if (existingElement == null) {
            dst[position] = new Entry(key, value, null);
            return true;
        } else {
            while (true) {
                if (existingElement.key.equals(key)) {
                    existingElement.value = value;
                    return false;
                }
                if (existingElement.next == null) {
                    existingElement.next = new Entry(key, value, null);
                    return true;
                }
                existingElement = existingElement.next;
            }
        }
    }

    private int getElementPosition(CarOwner carOwner, int arrayLength) {
        return Math.abs(carOwner.hashCode() % arrayLength);
    }

    private static class Entry {
        private CarOwner key;
        private Car value;
        private Entry next;

        public Entry(CarOwner key, Car value, Entry next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
}
