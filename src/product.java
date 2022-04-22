public class product {
    private double price;
    private String productID;
    private String name;
    private double priceAfterDiscount;

    public void init(double price, String productID, String name, double priceAfterDiscount){
        this.price = price;
        this.productID = productID;
        this.priceAfterDiscount = priceAfterDiscount;
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setPriceAfterDiscount(double priceAfterDiscount) {
        this.priceAfterDiscount = priceAfterDiscount;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public double getPriceAfterDiscount() {
        return priceAfterDiscount;
    }

    public String getProductID() {
        return productID;
    }
}
