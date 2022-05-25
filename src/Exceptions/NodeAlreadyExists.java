package Exceptions;

public class NodeAlreadyExists extends Exception{
    public NodeAlreadyExists(){
        super("This object already exists");
    }
}
