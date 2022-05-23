import Exceptions.ObjetoJaAdicionado;

public class ListaOrdenada<T extends Comparable<T>> {
    No<T> inicio, fim;

    public void Inserir(T obj) throws ObjetoJaAdicionado{
        No<T> aux = new No<>(obj);
        boolean existe = verificarExistencia(aux);

        if(!existe){
            if(inicio == null) {
                inicio = aux;
                fim = aux;
            } else {
                for (No<T> i = inicio; i != null; i = i.dir) {
                    if (aux.dado.compareTo(i.dado) <= 0) {
                        aux.dir = i;
                        i.esq = aux;
                        if (i == inicio) {
                            inicio = aux;
                        }
                    } 
                    else if (i == fim) {
                        aux.esq = i;
                        i.dir = aux;
                        fim = aux;
                    }
                }
            }
        } else {
            throw new ObjetoJaAdicionado();
        }    
    }

    public boolean verificarExistencia(No<T> no){
        No<T> noIterador = inicio;
        boolean existe = false;
        
        while(noIterador != null){
            if(noIterador.dado.equals(no.dado)){
                existe = true;
            }else{
                noIterador = noIterador.dir;
            }      
        }

        return existe;
    }
}
