package basic;

public class TestGeneric<T> {

    private T object;

    public void greet(){
        System.out.println(object);
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }
}
