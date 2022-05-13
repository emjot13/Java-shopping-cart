package cart;

import discounts.Discount;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import product.Product;
import sorts.SortByPriceThenName;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import static java.lang.System.out;

@ToString
@Getter
@Setter
public class Cart {
  private List<Product> products;
  private double cartValue;
  private Comparator<Product> sortType;
  private List<Discount> discounts;

  public Cart(Comparator<Product> sortType) {
    this.sortType = sortType;
    this.products = new ArrayList<>();
    this.cartValue = 0;
    this.discounts = new ArrayList<>();
  }

  public void addDiscount(Discount discount){
    if (discount.canApply(this)){
        discount.apply(this);
    }
  }

  public void addProduct(Product product) {
    products.add(product);
  }

  public Product findCheapest() {
    return Collections.min(products, Comparator.comparing(Product::getPrice));
  }

  public Product findMostExpensive() {
    return Collections.max(products, Comparator.comparing(Product::getPrice));
  }

  public void sortCart() {
    products.sort(sortType);
  }

  public void calculateCartValue() {
    this.cartValue = 0;
      for (Product product : products) {
          this.cartValue += product.getPriceAfterDiscount();
      }
  }


  public List<Product> budgetShopping(int howMany) {
    List<Product> copy = new ArrayList<>(products);
    copy.sort(new SortByPriceThenName());
    return copy.subList(0, howMany);
  }

  public List<Product> expensiveItems(int howMany) {
    List<Product> copy = new ArrayList<>(products);
    List<Product> mostExpensive = new ArrayList<>();
    for (int i = 0; i < howMany; i++) {
      Product tmp = Collections.max(copy, Comparator.comparing(Product::getPrice));
      copy.remove(tmp);
      mostExpensive.add(tmp);
    }
    return mostExpensive;
  }

}
