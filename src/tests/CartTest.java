package tests;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import product.Product;
import cart.Cart;
import sorts.*;

import java.util.*;

public class CartTest {
    private Cart sut;
    @Before
    public void setUp(){
        sut = new Cart(new SortByPriceThenName());
    }

    @Test
    public void testAddedOneProduct(){
        sut.addProduct(new Product(20, "123", "shoes"));
        assertEquals(sut.getProducts().size(), 1);
    }

    @Test
    public void testGetCartValue(){
        sut.addProduct(new Product(20, "124", "football"));
        sut.addProduct(new Product(30, "125", "basketball"));
        sut.calculateCartValue();
        assertEquals(sut.getCartValue(), 50, 0.00001);
    }

    @Test
    public void testGetCartValueManyProducts(){
        addBalls();
        sut.calculateCartValue();
        assertEquals(sut.getCartValue(), 113.49, 0.00001);
    }


    @Test
    public void testFindCheapest(){
        sut.addProduct(new Product(20, "124", "football"));
        sut.addProduct(new Product(30, "125", "basketball"));
        assertEquals(sut.findCheapest().getPrice(), 20, 0.0001);
    }

    @Test
    public void findMostExpensive(){
        sut.addProduct(new Product(20, "124", "football"));
        sut.addProduct(new Product(30, "125", "basketball"));
        assertEquals(sut.findMostExpensive().getPrice(), 30, 0.0001);
    }

    @Test
    public void testSortByPriceAndName(){
        addBalls();
        sut.sortCart();
        assertTrue(sut.getProducts().get(0).getPrice() == 3 && Objects.equals(sut.getProducts().get(0).getName(), "rugby ball"));
    }

    @Test
    public void testSortByNameAndPrice(){
        addBalls();
        sut.setSortType(new SortByNameThenPrice());
        sut.sortCart();
        assertTrue(sut.getProducts().get(0).getPrice() == 30.99 && Objects.equals(sut.getProducts().get(0).getName(), "basketball"));
    }



    private void addBalls() {
        sut.addProduct(new Product(20, "124", "football"));
        sut.addProduct(new Product(30.99, "125", "basketball"));
        sut.addProduct(new Product(10.5, "124574", "volleyball"));
        sut.addProduct(new Product(21, "1209895", "tennis ball"));
        sut.addProduct(new Product(3, "1324", "rugby ball"));
        sut.addProduct(new Product(10, "12311125", "golf ball"));
        sut.addProduct(new Product(15, "1232194", "frisbee"));
        sut.addProduct(new Product(3, "12319065", "table tennis ball"));
    }
    @Test
    public void testFindNumberOfMostExpensiveItems(){
        addBalls();
        List<Product> mostExpensive = sut.expensiveItems(3);
        assertEquals(mostExpensive.get(1).getProductID(), "1209895");
    }

    @Test
    public void testFindNumberOfCheapestItems(){
        addBalls();
        List<Product> cheapest = sut.budgetShopping(5);
        assertEquals(cheapest.get(4).getProductID(), "1232194");
    }




}
