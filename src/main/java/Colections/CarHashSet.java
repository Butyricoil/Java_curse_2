package Colections;

public class CarHashSet implements CarSet {
    private static final int INITIAL_CAPACITY = 16;
    private static final double LOAD_FACTOR = 0.75f;
    private int size = 0;
    private Entry[] array = new Entry[INITIAL_CAPACITY];

    @Override
    public boolean add(Car car) {
        if (size >= array.length * LOAD_FACTOR) {
            increaseArray();
        }
        boolean added = add(car, array);
        if (added) {
            size++;
        }
        return added;
    }

    @Override
    public boolean remove(Car car) {
        int position = getElementPosition(car, array.length);
        if (array[position] == null) {
            return false;
        }
        Entry secondLast = array[position];
        Entry last = secondLast.next;
        if (secondLast.value.equals(car)) {
            array[position] = last;
            size--;
            return true;
        }
        while (last != null) {
            if (last.value.equals(car)) {
                secondLast.next = last.next;
                size--;
                return true;
            }
            secondLast = last;
            last = last.next;
        }
        return false;
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

    private void increaseArray() {
        Entry[] newArray = new Entry[array.length * 2];
        for (Entry entry : array) {
            Entry existingElement = entry;
            while (existingElement != null) {
                add(existingElement.value, newArray);
                existingElement = existingElement.next;
            }
        }
        array = newArray;
    }

    boolean add(Car car, Entry[] dst) {
        int position = getElementPosition(car, dst.length);
        if (dst[position] == null) {
            dst[position] = new Entry(car, null);
            return true;
        } else {
            Entry existingElement = dst[position];
            while (true) {
                if (existingElement.value.equals(car)) {
                    return false;
                } else if (existingElement.next == null) {
                    existingElement.next = new Entry(car, null);
                    return true;
                } else {
                    existingElement = existingElement.next;
                }
            }
        }
    }

    private int getElementPosition(Car car, int arrayLength) {
        return Math.abs(car.hashCode()) % arrayLength;
    }

    private static class Entry {
        private Car value;
        private Entry next;

        public Entry(Car value, Entry next) {
            this.value = value;
            this.next = next;
        }
    }
}