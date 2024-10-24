package Colections;

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

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Car) {
            Car car = (Car) obj;
            return car.brand.equals(this.brand) && car.number == this.number;
        } else {
            return false;
        }
    }


    @Override
    public int hashCode() {
        return brand.hashCode() + number;
    }

}
