package discounts;
import cart.Cart;
import product.Product;

public class FreeCup implements Discount{
    @Override
    public void apply(Cart cart){
        cart.addProduct(new Product(0, "8543", "special gratis cup"));
    }

    @Override
    public boolean canApply(Cart cart){
        cart.calculateCartValue();
        return cart.getCartValue() > 200;
    }


}
