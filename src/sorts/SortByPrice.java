package sorts;
import java.util.Comparator;
import product.Product;

public class SortByPrice implements Comparator<Product> {
    @Override
    public int compare(Product product1, Product product2) {
        return Comparator.comparing(Product::getPrice)
                .compare(product1, product2);
    }
}
