package Colections;

public class CarOwner {
    private String name; // Имя владельца автомобиля
    private String lastName; // Фамилия
    private int id; // индефекатор
    // Конструктор для создания объекта CarOwner
    public CarOwner(String name, String lastName, int id) {
        this.name = name;
        this.lastName = lastName;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setId(int id) {
        this.id = id;
    }
}
