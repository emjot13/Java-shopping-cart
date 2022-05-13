package discounts;
import cart.Cart;

public class CartValueMoreThan300 implements Discount {
    @Override
    public void apply(Cart cart){
        cart.setCartValue(cart.getCartValue() * 0.95);
    }

    @Override
    public boolean canApply(Cart cart){
        cart.calculateCartValue();
        return cart.getCartValue() > 300;
    }
}
