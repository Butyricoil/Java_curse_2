
package Collections;

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
    public int hashCode() {
        // Переопределение метода hashCode, если потребуется
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        // Переопределение метода equals для сравнения объектов CarArrayList
        return super.equals(obj);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        // Переопределение метода clone для создания копии CarArrayList
        return super.clone();
    }

    @Override
    public String toString() {
        // Переопределение метода toString для получения строкового представления CarArrayList
        return super.toString();
    }

    @Override
    public Car get(int index) {
        checkIndex(index); // Проверка на допустимость индекса
        return array[index]; // Возврат автомобиля по индексу
    }

    @Override
    public void add(Car car) {
        // Увеличение размера массива, если необходимо
        if (size >= array.length) {
            array = Arrays.copyOf(array, array.length * 2);
        }
        array[size] = car; // Добавление нового автомобиля
        size++; // Увеличение размера списка
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
}
