package Generic;

public class Box <T> {
    private T object;

    public T getObject() {
        return object;
    }

    public T setObject(T object) {
        return  object;
    }

    public Box(T object) {
        this.object = object;
    }
}
