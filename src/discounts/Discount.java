package discounts;
import cart.Cart;

public interface Discount {
    void apply(Cart cart);
    boolean canApply(Cart cart);
}
