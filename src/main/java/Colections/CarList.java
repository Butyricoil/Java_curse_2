
package Colections;

/**
 * Интерфейс CarList представляет собой абстракцию списка автомобилей.
 * Он определяет основные операции, которые могут быть выполнены с коллекцией автомобилей.
 */
public interface CarList {

    /**
     * Получает автомобиль по указанному индексу.
     *
     * @param index индекс автомобиля в списке.
     * @return автомобиль, соответствующий указанному индексу.
     * @throws IndexOutOfBoundsException если индекс выходит за пределы текущего размера списка.
     */
    Car get(int index);

    /**
     * Добавляет новый автомобиль в список.
     *
     * @param car автомобиль, который необходимо добавить.
     */
    void add(Car car);


    /**
     * Добавляет новый автомобиль в список.
     *
     * @param car автомобиль, который необходимо добавить.
     */
    void add(Car car, int index);


    /**
     * Удаляет указанный автомобиль из списка.
     *
     * @param car автомобиль, который необходимо удалить.
     * @return true, если автомобиль был успешно удален, иначе false.
     */
    boolean remove(Car car);

    /**
     * Удаляет автомобиль по указанному индексу.
     *
     * @param index индекс автомобиля, который необходимо удалить.
     * @return true, если автомобиль был успешно удален, иначе false.
     * @throws IndexOutOfBoundsException если индекс выходит за пределы текущего размера списка.
     */
    boolean removeAt(int index);

    /**
     * Возвращает текущее количество автомобилей в списке.
     *
     * @return размер списка (количество элементов).
     */
    int size();

    /**
     * Очищает список, удаляя все автомобили.
     */
    void clear();
}
