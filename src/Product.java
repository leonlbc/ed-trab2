public class Product implements Comparable<Product> {

    private String name;
    private int stock_quantity;
    private String expiration_date;

    public Product(){
    }

    public Product(String name, int stock_quantity, String expiration_date){
        this.name = name;
        this.stock_quantity = stock_quantity;
        this.expiration_date = expiration_date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStockQuantity() {
        return stock_quantity;
    }

    public void setStockQuantity(int stock_quantity) {
        this.stock_quantity = stock_quantity;
    }

    public String getExpirationDate() {
        return expiration_date;
    }

    public void setExpirationDate(String expiration_date) {
        this.expiration_date = expiration_date;
    }

    @Override
    public String toString() {
        return "{name: " + name + ", qtd_em_estoque: " + stock_quantity + ", data_de_validade: " + expiration_date + "}";
    }

    @Override
    public boolean equals(Object obj) {
        Product product = (Product) obj;
        return this.getName().equals(product.getName());
    }

    @Override
    public int compareTo(Product product) {
        return this.expiration_date.compareTo(product.expiration_date);
    }
    
}
