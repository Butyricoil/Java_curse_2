package Collections;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarListTest {

    private CarList carList;

    @Before
    public void setUp() throws Exception {
        for (int i = 0; i < 100; i++) {
            carList.add(new Car("brand" + i, i));
        }}

    @Test
    public void whenAdded100EnementsThenSizeMustBe100 () {
        assertEquals(100, carList.size());
    }

    @Test
    public void whenElementRemovedByIndexThenSizeMustBedecresed () {
        assertEquals(100, carList.size());
        assertTrue(carList.remove(new Car("brand1", 0)));
        assertEquals(99, carList.size());
    }

    @Test
    public void whenElementRemovedThenSizeMustBedecresed () {
        Car car = new Car("toyota", 15);
        carList.add(car);
        assertEquals(101, carList.size());
        assertTrue(carList.remove(car));
        assertEquals(101, carList.size());
    }

    @Test
    public void whenNonExistentElementRemovedYhenReturnFalse() {
        Car car = new Car("toyota", 15);
        assertFalse(carList.remove(car));
    }

    @Test
    public void WhenListClearThenSizeMustBe0() {
        carList.clear();
        assertEquals(0, carList.size());
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void whenIndexOutOfBounceException() {
       carList.get(100);
    }

    @Test
    public void methodGetReturnedRightValue() {
        Car car = carList.get(0);
        assertEquals("brand0", car.getBrand());
    }
}