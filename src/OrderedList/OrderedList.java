package OrderedList;
import java.util.NoSuchElementException;
import Exceptions.NodeAlreadyExists;

public class OrderedList<T extends Comparable<T>> {
    private Node<T> first, last;

    public void Insert(T obj) throws NodeAlreadyExists{
        Node<T> aux = new Node<>(obj);
        boolean exists = nodeExists(aux);
        if(!exists){
            if(first == null) {
                first = aux;
                last = aux;
            } else {
                for (Node<T> i = first; i != null; i = i.right) {
                    if (aux.data.compareTo(i.data) <= 0) {
                        aux.left = i.left;
                        i.left = aux;
                        aux.right = i;
                        if (i == first) {
                            first = aux;
                            break;
                        }
                        aux.left.right = aux;
                        break;
                    } 
                    else if (i == last) {
                        aux.left = i;
                        i.right = aux;
                        last = aux;
                        break;
                    }
                }
            }
        } else {
            throw new NodeAlreadyExists();
        }    
    }

    public boolean nodeExists(Node<T> Node){
        boolean exists = false;
        if (!isEmpty()) {
            for (Node<T> i = first; i != null; i = i.right) {
                if(i.data.equals(Node.data)){
                    exists = true;
                }
            }
        }
        return exists;
    }

    public Node<T> find(T obj) throws NoSuchElementException{
        if (!isEmpty()) {
            Node<T> aux = new Node<T>(obj);
            for (Node<T> i = first; i != null; i = i.right) {
                if(i.data.equals(aux.data)){
                    return i;
                }
            }
        }
        throw new NoSuchElementException("No objects found.");
    }

    public void remove(T obj) throws NoSuchElementException{
        if (!isEmpty()){
            Node<T> aux = find(obj);
            if (aux == first) {
                first = aux.right;
                aux.right.left = null;
            } else if (aux == last) {
                last = aux.left;
                aux.left.right = null;
            } else {
                aux.left.right = aux.right;
                aux.right.left = aux.left;
            }
        }
    }

    public String listAll(){
        String list = "[";
        if (!isEmpty()) {
            for (Node<T> i = first; i != null; i = i.right) {
                list = i == last ? list + i.data.toString() : list + i.data.toString() + "\n";
            }
        }
        list += "]";
        return list;
    }

    public boolean isEmpty() {
        if (first == null) {
            return true;
        }
        return false;
    }

}
