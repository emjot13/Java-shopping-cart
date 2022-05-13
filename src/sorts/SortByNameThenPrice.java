package sorts;
import java.util.Comparator;

import product.Product;

public class SortByNameThenPrice implements Comparator<Product> {
    @Override
    public int compare(Product product1, Product product2) {
        return Comparator.comparing(Product::getName, String.CASE_INSENSITIVE_ORDER)
                .thenComparing(Product::getPrice)
                .compare(product1, product2);
    }
}
