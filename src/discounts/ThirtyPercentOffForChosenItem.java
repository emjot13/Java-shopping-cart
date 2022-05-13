package discounts;

import cart.Cart;
import product.Product;

public class ThirtyPercentOffForChosenItem implements Discount {
  private final String productID;

  public ThirtyPercentOffForChosenItem(String productID) {
    this.productID = productID;
  }

  @Override
  public void apply(Cart cart) {
    for (Product product : cart.getProducts()) {
      if (product.getProductID().equals(productID)) {
        product.setPriceAfterDiscount(product.getPrice() * 0.7);
      }
    }
  }

  @Override
  public boolean canApply(Cart cart) {
    return cart.getProducts().stream()
        .anyMatch(product -> productID.equals(product.getProductID()));
  }
}
