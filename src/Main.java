import OrderedList.OrderedList;

public class Main {
    public static void main(String[] args) {
        int option = 0;
        OrderedList<Product> stock = new OrderedList<Product>();

        do {
            try {
                option = Integer.parseInt(Util.chooseOption());
                switch (option) {
                    case 1:
                        Util.registerProduct(stock);
                        break;
                    case 2:
                        Util.listProducts(stock);
                        break;
                    case 3:
                        Util.sellProduct(stock);
                        break;
                    default:
                        break;
                }
            }
            catch (NumberFormatException e){
                e.printStackTrace();
                Util.errorMessage("Invalid Option");
            }
            catch (Exception e) {
                System.out.println(e);
                String message = e.getMessage() == null ? "Operation Failed" : e.getMessage();
                Util.errorMessage(message);
            }
        } while (option != 4);
    }
}
