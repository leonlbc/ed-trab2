import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        int option = 0;
        OrderedList<Product> stock = new OrderedList<Product>();

        try {
            do {
                option = Integer.parseInt(JOptionPane.showInputDialog(Util.options()));
                switch (option) {
                    case 1:
                        Util.registerProduct();
                        break;
                    case 2:
                        Util.listProducts();
                        break;
                    case 3:
                        Util.sellProduct();
                        break;
                    default:
                        break;
                }
            } while (option != 4);
        } catch (Exception e) {
            //TODO Handle Exceptions
            System.out.println(e);
        }   
    }
}
