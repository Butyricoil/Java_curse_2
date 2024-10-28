package Colections;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Set;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarMapTest {

    private CarMap carMap;

    @BeforeEach
    public void setUp() {
        carMap = new CarMapImpl(); // предполагается, что CarMapImpl — реализация CarMap
    }

    @Test
    void shouldThrowExceptionWhenPuttingNullKey() {
        CarOwner nullKey = null;
        Car value = new Car("Toyota", 123);

        assertThrows(IllegalArgumentException.class, () -> carMap.put(nullKey, value));
    }

    @Test
    void shouldThrowExceptionWhenPuttingNullValue() {
        CarOwner key = new CarOwner("John Doe");
        Car nullValue = null;

        assertThrows(IllegalArgumentException.class, () -> carMap.put(key, nullValue));
    }

    @Test
    void shouldThrowExceptionWhenRemovingNonExistentKey() {
        CarOwner nonExistentKey = new CarOwner("Jane Doe");

        assertThrows(IllegalArgumentException.class, () -> carMap.remove(nonExistentKey));
    }

    @Test
    void shouldReturnEmptyValuesListWhenMapIsEmpty() {
        List<Car> values = carMap.values();

        assertEquals(0, values.size(), "Список значений должен быть пустым при пустой карте");
    }

    @Test
    void shouldReturnEmptyKeySetWhenMapIsEmpty() {
        Set<CarOwner> keys = carMap.keySet();

        assertEquals(0, keys.size(), "Множество ключей должно быть пустым при пустой карте");
    }

    @Test
    void shouldReturnSizeZeroWhenMapIsEmpty() {
        int size = carMap.size();

        assertEquals(0, size, "Размер карты должен быть 0 при пустой карте");
    }

    @Test
    void shouldIncreaseSizeAfterAddingOneCar() {
        CarOwner key = new CarOwner("John Doe");
        Car value = new Car("Honda", 456);

        carMap.put(key, value);

        assertEquals(1, carMap.size(), "Размер карты должен быть 1 после добавления одного автомобиля");
    }

    @Test
    void shouldIncreaseSizeCorrectlyAfterAddingMultipleCars() {
        CarOwner key1 = new CarOwner("John Doe");
        Car value1 = new Car("Toyota", 123);
        CarOwner key2 = new CarOwner("Jane Doe");
        Car value2 = new Car("Ford", 789);

        carMap.put(key1, value1);
        carMap.put(key2, value2);

        assertEquals(2, carMap.size(), "Размер карты должен быть 2 после добавления двух автомобилей");
    }

    @Test
    void shouldDecreaseSizeAfterRemovingCar() {
        CarOwner key1 = new CarOwner("John Doe");
        Car value1 = new Car("Toyota", 123);
        CarOwner key2 = new CarOwner("Jane Doe");
        Car value2 = new Car("Ford", 789);

        carMap.put(key1, value1);
        carMap.put(key2, value2);

        int initialSize = carMap.size();
        assertEquals(2, initialSize, "Начальный размер карты должен быть 2");

        carMap.remove(key1);

        assertEquals(1, carMap.size(), "Размер карты должен быть 1 после удаления одного автомобиля");
    }
}
