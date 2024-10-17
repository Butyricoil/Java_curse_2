package Collections.MyArrayList;

/**
 * Класс Car представляет собой модель автомобиля с брендом и номером.
 * Он инкапсулирует данные о марке и номере автомобиля.
 */
public class Car {
    private String brand; // Бренд автомобиля
    private int number;   // Номер автомобиля

    /**
     * Конструктор для создания объекта Car.
     *
     * @param brand марка автомобиля.
     * @param number номер автомобиля.
     */
    public Car(String brand, int number) {
        this.number = number;
        this.brand = brand;
    }

    /**
     * Возвращает марку автомобиля.
     *
     * @return марка автомобиля.
     */
    public String getBrand() {
        return brand;
    }

    /**
     * Возвращает номер автомобиля.
     *
     * @return номер автомобиля.
     */
    public int getNumber() {
        return number;
    }
}