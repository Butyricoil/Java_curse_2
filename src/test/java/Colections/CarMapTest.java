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


}
