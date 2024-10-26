package Colections;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarColectionsTest {

    private CarColections carColections;

    @Before
    public void setUp() throws Exception {
        carColections = new CarHashSet();
        for (int i = 0; i < 100; i++) {
            carColections.add(new Car("brand" + i, i)); // Добавление 100 автомобилей
        }
    }

    @Test
    public void containsCar() {
        Car car = new Car("brand50", 50);
        assertTrue(carColections.contains(car)); // Проверка наличия автомобиля в коллекции
    }

}
