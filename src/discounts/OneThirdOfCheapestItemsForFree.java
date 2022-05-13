package discounts;

import cart.Cart;
import product.Product;

import java.util.List;

public class OneThirdOfCheapestItemsForFree implements Discount {
  @Override
  public void apply(Cart cart) {
    int freeItemCount = Math.floorDiv(cart.getProducts().size(), 3);
    List<Product> cheapest = cart.budgetShopping(freeItemCount);
    for (Product product : cheapest) {
      product.setPriceAfterDiscount(0);
    }
  }

  @Override
  public boolean canApply(Cart cart) {
    return cart.getProducts().size() >= 3;
  }
}
