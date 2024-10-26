
package Colections;

import java.util.Arrays;

/**
 * Класс CarArrayList представляет собой реализацию списка автомобилей с использованием массива.
 * Он поддерживает динамическое изменение размера массива при добавлении новых автомобилей.
 */
public class CarArrayList implements CarList {

    private Car[] array = new Car[10]; // Начальный массив для хранения автомобилей
    private int size = 0; // Текущий размер списка

    /**
     * Конструктор для создания объекта CarArrayList.
     * Инициализирует внутренний массив и размер списка.
     */
    public CarArrayList() {
        super();
    }

    @Override
    public Car get(int index) {
        checkIndex(index); // Проверка на допустимость индекса
        return array[index]; // Возврат автомобиля по индексу
    }

    @Override
    public boolean add(Car car) {
        increaseArray();
        array[size] = car; // Добавление нового автомобиля
        size++;
        return true;// Увеличение размера списка
    }

    @Override
    public boolean add(Car car, int index) {
        // Увеличение размера массива, если необходимо
        increaseArray();
        // Сдвигаем элементы вправо для освобождения места
        for (int i = size - 1; i >= index; i--) {
            array[i + 1] = array[i];
        }
        array[index] = car; // Вставляем новый элемент
        size++; // Увеличиваем размер списка
        return true;
    }

    @Override
    public boolean remove(Car car) {
        // Поиск и удаление указанного автомобиля
        for (int i = 0; i < size; i++) {
            if (array[i].equals(car)) {
                return removeAt(i); // Удаление автомобиля по индексу
            }
        }
        return false; // Если автомобиль не найден
    }

    @Override
    public boolean removeAt(int index) {
        checkIndex(index); // Проверка на допустимость индекса
        // Сдвиг элементов для удаления
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--; // Уменьшение размера списка
        array[size] = null; // Очистка последнего элемента
        return true; // Успешное удаление
    }

    @Override
    public int size() {
        return size; // Возврат текущего размера списка
    }

    @Override
    public void clear() {
        // Сброс массива и размера
        array = new Car[10];
        size = 0;
    }

    /**
     * Проверяет допустимость индекса.
     *
     * @param index индекс для проверки.
     * @throws IndexOutOfBoundsException если индекс выходит за пределы допустимого диапазона.
     */
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

    private void increaseArray() {
        // Увеличение размера массива, если необходимо
        if (size >= array.length) {
            array = Arrays.copyOf(array, array.length * 2);
        }
    }
}
