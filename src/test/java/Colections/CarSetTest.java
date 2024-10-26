package Colections;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CarSetTest {

    private CarHashSet carSet;
    private Car car1;
    private Car car2;

    @Before
    public void setUp() throws Exception {
        carSet = new CarHashSet();
        car1 = new Car("Toyota", 2);
        car2 = new Car("Honda", 3);
    }

    @Test
    public void add() {
        // Проверка на добавление нового элемента
        assertTrue(carSet.add(car1));
        assertEquals(1, carSet.size());

        // Проверка на добавление дубликата
        assertFalse(carSet.add(car1));
        assertEquals(1, carSet.size());

        // Добавление второго элемента
        assertTrue(carSet.add(car2));
        assertEquals(2, carSet.size());
    }

    @Test
    public void remove() {
        // Добавление элементов для удаления
        carSet.add(car1);
        carSet.add(car2);

        // Удаление существующего элемента
        assertTrue(carSet.remove(car1));
        assertEquals(1, carSet.size());

        // Попытка удалить несуществующий элемент
        assertFalse(carSet.remove(car1));
        assertEquals(1, carSet.size());

        // Удаление последнего элемента
        assertTrue(carSet.remove(car2));
        assertEquals(0, carSet.size());
    }

    @Test
    public void size() {
        // Проверка начального размера
        assertEquals(0, carSet.size());

        // Добавление элементов и проверка размера
        carSet.add(car1);
        carSet.add(car2);
        assertEquals(2, carSet.size());

        // Удаление и проверка размера
        carSet.remove(car1);
        assertEquals(1, carSet.size());
    }

    @Test
    public void clear() {
        // Добавление элементов
        carSet.add(car1);
        carSet.add(car2);

        // Очистка множества
        carSet.clear();
        assertEquals(0, carSet.size());

        // Проверка, что множество пустое
        assertFalse(carSet.remove(car1));
    }
}
