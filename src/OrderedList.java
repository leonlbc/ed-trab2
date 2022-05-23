import Exceptions.ObjectAlreadyExists;

public class OrderedList<T extends Comparable<T>> {
    Node<T> first, last;

    public void Insert(T obj) throws ObjectAlreadyExists{
        Node<T> aux = new Node<>(obj);
        boolean existe = checkExists(aux);

        if(!existe){
            if(first == null) {
                first = aux;
                last = aux;
            } else {
                for (Node<T> i = first; i != null; i = i.right) {
                    if (aux.data.compareTo(i.data) <= 0) {
                        aux.right = i;
                        i.left = aux;
                        if (i == first) {
                            first = aux;
                        }
                    } 
                    else if (i == last) {
                        aux.left = i;
                        i.right = aux;
                        last = aux;
                    }
                }
            }
        } else {
            throw new ObjectAlreadyExists();
        }    
    }

    public boolean checkExists(Node<T> Node){
        boolean exists = false;
        
        for (Node<T> i = first; i != null; i = i.right) {
            if(i.data.equals(Node.data)){
                exists = true;
            }
        }

        return exists;
    }
}
