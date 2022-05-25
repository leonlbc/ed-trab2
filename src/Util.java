import java.util.NoSuchElementException;

import javax.management.InvalidAttributeValueException;
import javax.swing.JOptionPane;
import Exceptions.NodeAlreadyExists;
import OrderedList.OrderedList;

public class Util {
    public static void sellProduct(OrderedList<Product> stock) throws NoSuchElementException, InvalidAttributeValueException{
        String name = JOptionPane.showInputDialog("Product Name");
        Product productToSell = new Product(name);
        productToSell = stock.find(productToSell).toObject();
        
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
        String name = "";
        String expiration = "";
        int stock_amount = 0;

        while (name.trim().equals("")) {
            name = JOptionPane.showInputDialog("Product Name (Can't Be Blank)");
            if (name == null) {
                return;
            }
        }

        while (expiration.trim().equals("")) {
            expiration = JOptionPane.showInputDialog("Expiration Date (DD/MM/YY): ");
            if (expiration == null) {
                return;
            }
        }
        
        while (stock_amount <= 0){
            try {
                String input = JOptionPane.showInputDialog("Amount in Stock (At Least One)");
                if (input == null) {
                    return;
                }
                stock_amount = Integer.parseInt(input);
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Enter a valid positive number");
            }
        }
        
        Product product = new Product(name, stock_amount, expiration);
        stock.Insert(product);
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

    public static void optionPaneInput(){

    }
}
