package OrderedList;
public class Node<T>{

    protected Node<T> right;
    protected Node<T> left;
    T data;

    protected Node(T data) {
        this.data = data;
    }

    public T toObject() {
        return this.data;
    }

}