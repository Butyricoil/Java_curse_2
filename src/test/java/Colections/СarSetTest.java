package Collections;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CarSetTest {

    private CarSet carSet;
    private Car car1;
    private Car car2;

    @Before
    public void setUp() throws Exception {
        carSet = new CarSetImpl(); // Замените на конкретную реализацию CarSet
        car1 = new Car("Toyota", "Camry", 2020);
        car2 = new Car("Honda", "Civic", 2019);
    }

    @Test
    public void add() {
        assertTrue(carSet.add(car1)); // Проверка, что car1 добавлен успешно
        assertEquals(1, carSet.size()); // Убедиться, что размер стал 1
        assertFalse(carSet.add(car1)); // Проверка, что дубликат car1 не добавляется
    }

    @Test
    public void remove() {
        carSet.add(car1);
        assertTrue(carSet.remove(car1)); // Проверка, что car1 удален успешно
        assertEquals(0, carSet.size()); // Размер должен быть 0 после удаления
        assertFalse(carSet.remove(car1)); // Проверка, что повторное удаление car1 возвращает false
    }

    @Test
    public void size() {
        assertEquals(0, carSet.size()); // Проверка начального размера
        carSet.add(car1);
        carSet.add(car2);
        assertEquals(2, carSet.size()); // Размер должен быть 2 после добавления car1 и car2
    }

    @Test
    public void clear() {
        carSet.add(car1);
        carSet.add(car2);
        carSet.clear();
        assertEquals(0, carSet.size()); // Проверка, что размер 0 после очистки
    }
}
