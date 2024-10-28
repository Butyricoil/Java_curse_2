package Colections;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

public class CarColectionsTest {

    private CarColections carColections;

    @Before
    public void setUp() throws Exception {
//        carColections = new CarHashSet();
//        carColections = new CarArrayList();
        carColections = new CarLinkedList();
        for (int i = 0; i < 100; i++) {
            carColections.add(new Car("brand" + i, i)); // Добавление 100 автомобилей
        }
    }

    @Test
    public void containsCar() {
        Car car = new Car("brand50", 50);
        assertTrue(carColections.contains(car)); // Проверка наличия автомобиля в коллекции
    }


    @Test
    public void testforEach() {
        int index = 0;

        // Создаём итератор один раз для while-цикла
        Iterator<Car> iterator = carColections.iterator();
        while (iterator.hasNext()) {
            Car car = iterator.next();
            index++;
        }

        assertEquals(100, index); // Проверка, что while-цикл проходит по всем автомобилям

        index = 0; // Сбрасываем индекс перед использованием for-each
        for (Car car : carColections) {
            index++;
        }

        assertEquals(100, index); // Проверка, что цикл forEach проходит по всем автомобилям
    }

}
