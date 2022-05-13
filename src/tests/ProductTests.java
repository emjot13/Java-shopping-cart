package tests;

import org.junit.Before;
import org.junit.Test;
import product.Product;



import static org.junit.Assert.assertEquals;

public class ProductTests {
  private Product sut;

  @Before
  public void setup() {
    sut = new Product(20, "01234", "shoes");
  }


  @Test
  public void testConstructorPrice() {
    assertEquals(sut.getPrice(), 20, 0.00001);
  }

  @Test
  public void testConstructorID() {
    assertEquals(sut.getProductID(), "01234");
  }

  @Test
  public void testConstructorName() {
    assertEquals(sut.getName(), "shoes");
  }

  @Test
  public void testConstructorPriceAfterDiscountIsTheSameAsPriceAtInit() {
    assertEquals(sut.getPrice(), sut.getPriceAfterDiscount(), 0.000001);
  }
}
