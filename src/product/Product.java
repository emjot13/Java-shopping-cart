package product;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString


public class Product {
    private double price;
    private String productID;
    private String name;
    private double priceAfterDiscount;

    public Product(double price, String productID, String name){
        this.productID = productID;
        this.name = name;
        this.price = price;
        this.priceAfterDiscount = price;
    }




}
