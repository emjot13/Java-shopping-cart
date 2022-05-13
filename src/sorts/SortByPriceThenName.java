package sorts;
import java.util.Comparator;
import product.Product;

public class SortByPriceThenName implements Comparator<Product> {
    @Override
    public int compare(Product product1, Product product2) {
        return Comparator.comparing(Product::getPrice)
                .thenComparing(Product::getName, String.CASE_INSENSITIVE_ORDER)
                .compare(product1, product2);
    }
}