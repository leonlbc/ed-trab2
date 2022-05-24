public class Product implements Comparable<Product> {

    private String name;
    private int stock_amount;
    private String expiration_date;

    public Product(){
    }

    public Product(String name){
        this.name = name;
    }

    public Product(String name, int stock_amount, String expiration_date){
        this.name = name;
        this.stock_amount = stock_amount;
        this.expiration_date = expiration_date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStockAmount() {
        return stock_amount;
    }

    public void setStockAmount(int stock_amount) {
        this.stock_amount = stock_amount;
    }

    public String getExpirationDate() {
        return expiration_date;
    }

    public void setExpirationDate(String expiration_date) {
        this.expiration_date = expiration_date;
    }

    @Override
    public String toString() {
        return "Name = " + name + " || Amount In Stock = " + stock_amount + " || Expiration Date = " + expiration_date;
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
