package tests;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import product.Product;
import cart.Cart;
import discounts.*;
import sorts.*;



public class CouponTests {
    private Cart sut;
    @Before
    public void setUp(){
        sut = new Cart(new SortByPriceThenName());
    }

    @Test
    public void test5PercentOff(){
        sut.addProduct(new Product(500, "1", "TV"));
        sut.addDiscount(new CartValueMoreThan300());
        assertEquals(sut.getCartValue(), 475, 0.0001);
    }

    @Test
    public void test5PercentOffShouldNotBeApplied(){
        sut.addProduct(new Product(299, "1", "TV"));
        sut.addDiscount(new CartValueMoreThan300());
        assertEquals(sut.getCartValue(), 299, 0.0001);
    }

    @Test
    public void testFreeCup(){
        sut.addProduct(new Product(500, "1", "TV"));
        sut.addDiscount(new FreeCup());
        assertTrue(sut.getProducts().stream()
                .anyMatch(product -> "special gratis cup".equals(product.getName())));
    }

    @Test
    public void testFreeCupShouldNotBeApplied(){
        sut.addProduct(new Product(199, "1", "TV"));
        sut.addDiscount(new FreeCup());
        assertFalse(sut.getProducts().stream()
                .anyMatch(product -> "special gratis cup".equals(product.getName())));
    }

    @Test
    public void testOneThirdOfCheapestItemsForFree(){
        sut.addProduct(new Product(500, "1", "TV"));
        sut.addProduct(new Product(200, "2", "phone"));
        sut.addProduct(new Product(100, "3", "calculator"));
        sut.addDiscount(new OneThirdOfCheapestItemsForFree());
        sut.calculateCartValue();
        assertEquals(sut.getCartValue(), 700, 0.0001);

    }

    @Test
    public void testOneThirdOfCheapestItemsForFreeCorrectNumberOfFreeItems(){
        sut.addProduct(new Product(500, "1", "TV"));
        sut.addProduct(new Product(200, "2", "phone"));
        sut.addProduct(new Product(100, "3", "calculator"));
        sut.addProduct(new Product(150, "4", "mouse"));
        sut.addProduct(new Product(800, "5", "speakers"));
        sut.addProduct(new Product(4000, "6", "PC"));
        sut.addProduct(new Product(5000, "7", "PS5"));
        sut.addDiscount(new OneThirdOfCheapestItemsForFree());
        sut.sortCart();
        assertTrue(sut.getProducts().get(0).getPriceAfterDiscount() == 0 && sut.getProducts().get(0).getPrice() == 100 && sut.getProducts().get(1).getPriceAfterDiscount() == 0 && sut.getProducts().get(1).getPrice() == 150);

    }

    @Test
    public void testOneThirdOfCheapestItemsForFreeShouldNotBeApplied(){
        sut.addProduct(new Product(500, "1", "TV"));
        sut.addProduct(new Product(200, "2", "phone"));
        sut.addDiscount(new OneThirdOfCheapestItemsForFree());
        sut.calculateCartValue();
        assertEquals(sut.getCartValue(), 700, 0.0001);
    }

    @Test
    public void testThirtyPercentOffForChosenItem(){
        sut.addProduct(new Product(100, "1", "scarf"));
        sut.addDiscount(new ThirtyPercentOffForChosenItem("1"));
        sut.calculateCartValue();
        assertEquals(sut.getCartValue(), 70, 0.001);
    }

    @Test
    public void testThirtyPercentOffForChosenItemBadId(){
        sut.addProduct(new Product(100, "1", "scarf"));
        sut.addDiscount(new ThirtyPercentOffForChosenItem("2"));
        sut.calculateCartValue();
        assertEquals(sut.getCartValue(), 100, 0.001);
    }



}
