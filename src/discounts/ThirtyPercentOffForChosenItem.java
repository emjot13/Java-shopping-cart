package discounts;

import cart.Cart;

public class ThirtyPercentOffForChosenItem implements Discount{
    @Override
    public void apply(Cart cart){
        cart.;
    }

    @Override
    public boolean canApply(Cart cart){
        boolean used = false;
        return cart.getCartValue() > 300;
    }
}
