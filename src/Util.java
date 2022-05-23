import javax.swing.JOptionPane;

import Exceptions.ObjectAlreadyExists;

public class Util {
    public static void sellProduct() {
    }

    public static void listProducts(OrderedList<Product> stock) {
        JOptionPane.showMessageDialog(null, stock.listAll());
    }

    public static void registerProduct(OrderedList<Product> stock) throws ObjectAlreadyExists{ 
        String name = JOptionPane.showInputDialog("Product Name: ");
        String expiration = JOptionPane.showInputDialog("Expiration Date (DD/MM/YY): ");
        int stock_quantity = Integer.parseInt(JOptionPane.showInputDialog("Quantity in Stock: "));
        
        Product product = new Product(name, stock_quantity, expiration);
        
        try {
            stock.Insert(product);
        } catch (Exception e) {
            throw new ObjectAlreadyExists();
        }
        
        JOptionPane.showMessageDialog(null, "Product Added Successfully!");
    }

    public static String chooseOption() {
        return JOptionPane.showInputDialog(Util.options());
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


}
