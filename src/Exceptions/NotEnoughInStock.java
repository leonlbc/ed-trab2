package Exceptions;

public class NotEnoughInStock extends Exception{
    public NotEnoughInStock(){
        super("There aren't enough items in stock");
    }
}
