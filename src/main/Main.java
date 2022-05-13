package main;

import cart.Cart;
import product.Product;
import sorts.SortByPriceThenName;
import discounts.*;
import java.util.List;

import static java.lang.System.out;

public class Main {
    public static void main(String[] args) {
        Cart cart = new Cart(new SortByPriceThenName());
        Product firstOne = new Product(27.5, "001234", "shoes");
        Product secondOne = new Product(2, "001234", "T-shirt");

        cart.addProduct(firstOne);
        cart.addProduct(secondOne);
        cart.addProduct(new Product(2, "0012634", "bananas"));
        cart.addProduct(new Product(10, "23495", "ball"));
        cart.addProduct(new Product(6, "21162842395", "screwdriver"));
        cart.addProduct(new Product(20, "1218395", "cake"));
        cart.addProduct(new Product(80, "32839545", "watch"));
        cart.addProduct(new Product(9, "28656595", "toy car"));
        cart.addProduct(new Product(280, "abugabu", "phone"));
//        cart.getCartValue();
        Product maxPrice = cart.findMostExpensive();
        Product minPrice = cart.findCheapest();
        List<Product> cheapest = cart.budgetShopping(5);
        List<Product> mostExpensive = cart.expensiveItems(5);
        cart.sortCart();
//        out.printf("The most expensive product is : %s%n", maxPrice);
//        out.printf("The cheapest items: %s%n", cheapest);
//        out.println("5 cheapest products are: " + cheapest);
//        out.println("5 most expensive products are: " + mostExpensive);
//        out.println(cart);
        cart.calculateCartValue();
        out.println(cart.getCartValue());
        cart.addDiscount(new CartValueMoreThan300());
        cart.addDiscount(new FreeCup());
        cart.calculateCartValue();
        out.println(cart.getCartValue());
        cart.sortCart();
        out.println(cart.getProducts());
    }
}
