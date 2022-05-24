import java.util.NoSuchElementException;

import javax.management.InvalidAttributeValueException;
import javax.swing.JOptionPane;
import Exceptions.NodeAlreadyExists;
import OrderedList.OrderedList;

public class Util {
    public static void sellProduct(OrderedList<Product> stock) throws NoSuchElementException, InvalidAttributeValueException{
        String name = JOptionPane.showInputDialog("Product Name");
        Product productToSell = new Product(name);
        productToSell = stock.find(productToSell).toObject(); // Throws NoSuchE..
        
        int stock_amount = productToSell.getStockAmount();
        int amount = Integer.parseInt(JOptionPane.showInputDialog(
                     String.format("Amount to Sell \n[%s in stock]", stock_amount)));
        
        stock_amount -= amount;
        if (stock_amount > 0) {
            productToSell.setStockAmount(stock_amount);
        } else if ( stock_amount == 0) {
            stock.remove(productToSell);
        } 
        else {
            throw new InvalidAttributeValueException(
                "Operation Failed: \n Not enough stocks to sell");
        }
    }

    public static void listProducts(OrderedList<Product> stock){
        JOptionPane.showMessageDialog(null, stock.listAll());
    }

    public static void registerProduct(OrderedList<Product> stock) throws NodeAlreadyExists{ 
        String name = JOptionPane.showInputDialog("Product Name: ");
        String expiration = JOptionPane.showInputDialog("Expiration Date (DD/MM/YY): ");
        int stock_amount = Integer.parseInt(JOptionPane.showInputDialog("Amount in Stock: "));
        
        Product product = new Product(name, stock_amount, expiration);
        stock.Insert(product); //throws NodeAlreadyExists
        JOptionPane.showMessageDialog(null, "Product Added Successfully!");
    }

    public static String chooseOption() {
        String opt;
        opt = JOptionPane.showInputDialog(Util.options());
        opt = opt == "" || opt == null ? "4" : opt;
        return opt;
    }

    public static String options() {
        String options = "---------";
        options += "Choose an option:";
        options += "\n 1. Register Product";
        options += "\n 2. List All Products";
        options += "\n 3. Sell Product";
        options += "\n 4. Exit";
        return options;
    }

    public static void errorMessage(String message) {
        JOptionPane.showMessageDialog(null, message);
    }


}
