
package Collections;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Класс CarListTest содержит набор тестов для проверки функциональности класса CarArrayList,
 * реализующего интерфейс CarList.
 */
public class CarListTest {

    private CarList carList; // Переменная для хранения списка автомобилей

    /**
     * Метод setUp выполняется перед каждым тестом.
     * Он инициализирует объект CarArrayList и добавляет 100 автомобилей в список.
     *
     * @throws Exception если возникла ошибка при инициализации.
     */
    @Before
    public void setUp() throws Exception {
        carList = new CarArrayList(); // Создание нового списка автомобилей
        for (int i = 0; i < 100; i++) {
            carList.add(new Car("brand" + i, i)); // Добавление 100 автомобилей
        }
    }

    /**
     * Тест проверяет, что при добавлении 100 элементов размер списка равен 100.
     */
    @Test
    public void whenAdded100ElementsThenSizeMustBe100() {
        assertEquals(100, carList.size()); // Проверка размера списка
    }

    /**
     * Тест проверяет, что размер списка уменьшается при удалении элемента.
     */
    @Test
    public void whenElementRemovedThenSizeMustBeDecreased() {
        CarList carList = new CarArrayList(); // Создание нового списка
        carList.add(new Car("Toyota", 0)); // Добавление первого элемента
        carList.add(new Car("Honda", 1)); // Добавление второго элемента
        carList.remove(carList.get(0)); // Удаляем первый элемент

        // Проверка размера
        assertTrue(carList.size() == 1); // Ожидается, что размер будет 1
    }

    /**
     * Тест проверяет, что размер списка уменьшается при удалении конкретного элемента.
     */
    @Test
    public void whenSpecificElementRemovedThenSizeMustBeDecreased() {
        Car car = new Car("toyota", 15);
        carList.add(car); // Добавление автомобиля
        assertEquals(101, carList.size()); // Проверка размера после добавления
        assertTrue(carList.remove(car)); // Удаление автомобиля
        assertEquals(100, carList.size());  // Проверка размера после удаления
    }

    /**
     * Тест проверяет, что попытка удаления несуществующего элемента возвращает false.
     */
    @Test
    public void whenNonExistentElementRemovedThenReturnFalse() {
        Car car = new Car("toyota", 15); // Создание автомобиля
        assertFalse(carList.remove(car)); // Проверка удаления несуществующего автомобиля
    }

    /**
     * Тест проверяет, что размер списка равен 0 после его очистки.
     */
    @Test
    public void whenListClearThenSizeMustBe0() {
        carList.clear(); // Очистка списка
        assertEquals(0, carList.size()); // Проверка размера
    }

    /**
     * Тест ожидает выброса исключения IndexOutOfBoundsException
     * при попытке доступа к элементу по индексу, выходящему за пределы допустимого диапазона.
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void whenIndexOutOfBoundsExceptionThrown() {
        carList.get(100);  // Ожидается исключение при обращении по индексу вне диапазона
    }

    /**
     * Тест проверяет, что метод get возвращает правильное значение.
     */
    @Test
    public void methodGetReturnedRightValue() {
        Car car = carList.get(0); // Получение первого автомобиля
        assertEquals("brand0", car.getBrand()); // Проверка бренда первого автомобиля
    }
}
