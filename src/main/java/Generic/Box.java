package Generic;

public class Box {
    private Object object;

    public void setObject(Object object) {
        this.object = object;
    }

        public Box(Object object) {
        this.object = object;
    }

    public int getObject() {
        return (int) object;
    }
}
