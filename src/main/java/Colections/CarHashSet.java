package Colections;

public class CarHashSet implements СarSet {
    private static final int INITIAL_CAPACITY = 16;
    private int size = 0;
    private Entry[] array = new Entry[INITIAL_CAPACITY];


    @Override
    public boolean add(Car car) {
        return add(car, array);
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
        while (last != null && !last.value.equals(car)) {

            if (last.value.equals(car)) {
                secondLast.next = last.next;
                size--;
                return true;
            } else {
                secondLast = last;
                last = last.next;
            }
            return false;
        }
    }

    @Override
    public int size() {
        return 0;
    }


    @Override
    public void clear() {

    }

    private void increaseArray () {
        Entry[] newArray = new Entry[array.length * 2];
        for (Entry entry : array) {
            Entry existingElement = entry;
            while (entry!= null) {
               add(existingElement.value, newArray);
               existingElement = existingElement.next;
            }
        }
        array = newArray;
    }

    boolean add (Car car, Entry[] dst) {
        int position = getElementPosition(car, dst.length);
        if (dst[position] == null) {
            dst[position] = new Entry(car, null);
            size++;
            return true;
        } else {
            Entry existingEelement = dst[position];
            while (true) {
                if (existingEelement.value.equals(car)) {
                    return false;
                } else if (existingEelement.next == null) {
                    existingEelement.next = new Entry(car, null);
                    size++;
                    return true;
                } else {
                    existingEelement = existingEelement.next;
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
            this.next = next;
            this.value = value;
        }
    }

}
