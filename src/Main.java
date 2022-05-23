import Exceptions.ObjectAlreadyExists;

public class Main {
    public static void main(String[] args) {
        int option = 0;
        OrderedList<Product> stock = new OrderedList<Product>();

        try {
            do {
                option = Integer.parseInt(Util.chooseOption());
                switch (option) {
                    case 1:
                        Util.registerProduct(stock);
                        break;
                    case 2:
                        Util.listProducts(stock);
                        break;
                    case 3:
                        Util.sellProduct();
                        break;
                    default:
                        break;
                }
            } while (option != 4);
        } catch (ObjectAlreadyExists e) {
            // TODO
        }
        catch (Exception e) {
            //TODO Handle Exceptions
            System.out.println(e);
        }
    }
}
